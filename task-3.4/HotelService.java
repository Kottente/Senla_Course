import java.time.LocalDate;
import java.time.LocalDateTime;

public class HotelService {
    private BookingRepository bookingRepo;
    private RoomRepository roomRepo;
    private ServiceRepository serviceRepo;

    public HotelService(BookingRepository bookingRepo, RoomRepository roomRepo, ServiceRepository serviceRepo) {
        this.bookingRepo = bookingRepo;
        this.roomRepo = roomRepo;
        this.serviceRepo = serviceRepo;
    }

    public void checkIn(Guest guest, int roomId, LocalDateTime checkInDate, LocalDateTime checkOutDate) {
        if (roomRepo.getRoomByID(roomId) != null) {
            Room room = roomRepo.getRoomByID(roomId);
            int bookingId = bookingRepo.CurBookingId();
            Booking booking = new Booking(bookingId, checkInDate, checkOutDate, guest.getId(), roomId);
            if (!bookingRepo.checkBooking(booking)) return;
            bookingRepo.addBooking(booking);
            System.out.println("Регистрация постояльца прошла успешно");
            if (room.getStatus() == RoomStatus.AVAILABLE) {
                room.markOccupied();
            }
        } else {
            roomRepo.getRoomByID(roomId);
            System.out.println("Не получилось заселить постояльца");
        }

    }

    public void checkOut(int bookingId) {
        Booking booking = bookingRepo.GetBookingById(bookingId);
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
    public void addService(int serviceId, int price, String number) {
        Service service = new Service(serviceId, number, price);
        serviceRepo.add(service);
        System.out.println("Добавлена новая услуга");
    }
}
