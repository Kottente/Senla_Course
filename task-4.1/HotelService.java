import java.time.*;
import java.util.*;

public class HotelService {
    private final BookingRepository bookingRepo;
    private final RoomRepository roomRepo;
    private final ServiceRepository serviceRepo;
    private GuestRepository guestRepo;

    public HotelService(BookingRepository bookingRepo, RoomRepository roomRepo, ServiceRepository serviceRepo, GuestRepository guestRepo) {
        this.guestRepo = guestRepo;
        this.bookingRepo = bookingRepo;
        this.roomRepo = roomRepo;
        this.serviceRepo = serviceRepo;
    }

    private final Comparator<Booking> bookingComparator =
            Comparator.comparing(
                    (Booking b) -> guestRepo.getGuestById(b.getGuestId()).getName()
            ).thenComparing(Booking::getCheckOutDate);

    public void checkIn(Guest guest, int roomId, LocalDateTime checkInDate, LocalDateTime checkOutDate) {
        if (roomRepo.getRoomByID(roomId) != null) {
            Room room = roomRepo.getRoomByID(roomId);
            int bookingId = bookingRepo.CurBookingId();
            Booking booking = new Booking(bookingId, checkInDate, checkOutDate, guest.getId(), roomId);
            if (!bookingRepo.checkBooking(booking)) return;
            bookingRepo.addBooking(booking);
            guest.setRoomId(roomId);
            guestRepo.addGuest(guest);
            System.out.println("Регистрация постояльца " + guest.getName() + " прошла успешно");
            if (room.getStatus() == RoomStatus.AVAILABLE) {
                room.markOccupied();
            }
        } else {
            roomRepo.getRoomByID(roomId);
            System.out.println("Не получилось заселить постояльца" + guest.getName());
        }

    }

    public void checkOut(Guest guest) {

        Booking booking = bookingRepo.GetBookingByGuest(guest);
        if (booking == null) return;
        Room room = roomRepo.getRoomByID(booking.getRoomId());
        if (room == null) return;
        booking.closeBooking();

        room.markAvailable();
        System.out.println("Выселение прошло успешно");
    }

    public void changeRoomStatus(int roomId, RoomStatus newStatus) {
        Room room = roomRepo.getRoomByID(roomId);
        if (room == null) return;
        switch (newStatus) {
            case AVAILABLE:
                room.markAvailable();
                break;
            case OCCUPIED:
                room.markOccupied();
                break;
            case MAINTENANCE:
                room.markMaintenance();
                break;
            case SERVICED:
                room.markAsServiced();
                break;
        }
        roomRepo.updateRoom(room);
        System.out.println("Статус комнаты был изменён");
    }

    public void changeRoomPrice(int roomId, int newPrice) {
        Room room = roomRepo.getRoomByID(roomId);
        if (room == null) return;
        room.changePrice(newPrice);
        roomRepo.updateRoom(room);
    }

    public void changeServicePrice(int serviceId, int newPrice) {
        Service service = serviceRepo.findById(serviceId);
        if (service == null) return;
        service.changePrice(newPrice);
        serviceRepo.update(service);
    }

    public void addRoom(int roomId, int price, String number) {
        Room room = new Room(roomId, number, price);
        roomRepo.addRoom(room);
        System.out.println("Добавлена новая комната");
    }

    public void addRoom(int roomId, int price, String number, RoomCategory category) {
        Room room = new Room(roomId, number, price, category);
        roomRepo.addRoom(room);
        System.out.println("Добавлена новая комната");
    }

    public void addRoom(int roomId, int price, String number, RoomCategory category, int capacity) {
        Room room = new Room(roomId, number, price, capacity, category);
        roomRepo.addRoom(room);
        System.out.println("Добавлена новая комната");
    }

    public void addService(int serviceId, int price, String number, int guestId, LocalDateTime arrangedTime) {
        Service service = new Service(serviceId, number, price, guestId, arrangedTime);
        serviceRepo.add(service);
        System.out.println("Добавлена новая услуга");
    }

    public void printOccupiedRooms() {
        List<Booking> bookings = bookingRepo.getBookings();
        bookings.sort(bookingComparator);
        for (Booking b : bookings) {
            Guest g = guestRepo.getGuestById(b.getGuestId());
            Room r = roomRepo.getRoomByID(b.getRoomId());
            if (b.isBooked()) {
                System.out.println(g.getName() + " — комната " + r.getNumber());
            }
        }

    }

    public void printAvailableRooms() {
        int count = 0;
        for (Room room : roomRepo.getAllRooms()) {
            if (room.getStatus() == RoomStatus.AVAILABLE) {
                System.out.println(room);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Все номера заняты");
        }
    }

    public void printAllGuests() {
        int count = 0;
        for (int i = 0; i < guestRepo.GetAllGuestsNames().size(); i++) {
            if (guestRepo.getGuestById(i) != null) {
                System.out.println(guestRepo.getGuestById(i));
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Ни одного постояльца на данный момент");
        }
    }

    public void printRoomsAvailableAt(LocalDateTime checkOutDate) {
        List<Booking> bookings = bookingRepo.getBookings();
        List<Room> rooms = new ArrayList<>();
        bookings.sort(bookingComparator);
        int count = 0;
        for (Booking b : bookings) {
            if (!rooms.contains(roomRepo.getRoomByID(b.getRoomId()))) {
                rooms.add(roomRepo.getRoomByID(b.getRoomId()));
                if (b.getCheckOutDate().isBefore(checkOutDate)) {
                    System.out.println(roomRepo.getRoomByID(b.getRoomId()));
                    count++;
                }
            }

        }
        if (count == 0) {
            System.out.println("Все номера забронированы на данную дату");
        }
    }

    public void printFullPrice(Booking booking) {
        int dailyPrice = roomRepo.getRoomByID(booking.getRoomId()).getPrice();
        int price = dailyPrice * ((int) (Duration.between(booking.getCheckInDate(), booking.getCheckOutDate())).toDays());
        System.out.println("Общая стоимость брони номера для постояльца " + guestRepo.getGuestById(booking.getGuestId()).getName() + " равна: " + price);
    }

    public void printLastGuests(int roomId) {
        System.out.println("Список последних трех постояльцев номера постояльцев:");
        List<Booking> books = bookingRepo.findBookingForRoom(roomId);
        for (int i = 1; i < 4; i++) {
            Booking b = books.get(i - 1);
            System.out.println("Постоялец: " + guestRepo.getGuestById(b.getGuestId()).getName() + " Время пребывания с" + b.getCheckInDate() + " до " + b.getCheckOutDate());
        }
    }

    public void printAllPrices() {
        System.out.println("Список сервисов: ");
        List<Room> rooms = roomRepo.getAllRooms();
        for (Room r : rooms) {
            System.out.println("Комната номер " + r.getNumber() + " Стоимость " + r.getPrice());
        }
        System.out.println("Список номеров: ");
        List<Service> services = serviceRepo.GetAllByPrice();
        for (Service s : services) {
            System.out.println("Услуга: " + s.getName() + " Стоимость: " + s.getPrice());
        }
    }

    public void printDetails(int roomId) {
        Room room = roomRepo.getRoomByID(roomId);
        System.out.println(room);
    }
    public void printGuestServiceList(Guest guest) {
        List<Service> result = serviceRepo.GetByGuest(guest);
        if(!result.isEmpty()) {
            System.out.println("Список оказанных постояльцу услуг: ");
            for (Service s : result) {
                System.out.println(s);
            }
        }

    }
}
