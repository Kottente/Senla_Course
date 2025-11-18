import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {
        BookingRepository bookingRepo = new BookingRepositoryImpl();
        RoomRepository roomRepo = new RoomRepositoryImpl();
        ServiceRepository serviceRepo = new ServiceRepositoryImpl();
        GuestRepository guestRepo = new GuestRepositoryImpl();
        HotelService admin = new HotelService(bookingRepo, roomRepo, serviceRepo, guestRepo);

        System.out.println("ДЕМО: Электронный администратор гостиницы.");

        admin.addRoom(1, 3500, "101");
        admin.addRoom(2, 2500, "102");
        admin.addRoom(3, 9999, "103", RoomCategory.DELUXE);


        admin.changeRoomStatus(2, RoomStatus.MAINTENANCE);
        admin.changeRoomStatus(2, RoomStatus.SERVICED);
        System.out.println(roomRepo.getAllRooms());
        admin.changeRoomStatus(2, RoomStatus.AVAILABLE);

        Guest dima = new Guest("Дима", 101);
        Guest katya = new Guest("Катя", 102);
        Guest danya = new Guest("Даня", 103);
        Guest tonya = new Guest("Тоня", 104);
        Guest tanya = new Guest("Таня", 105);
        Guest roma = new Guest("Рома", 106);
        Guest odysseus = new Guest("Одиссей", 107);
        LocalDateTime now = LocalDateTime.now();
        admin.addService(1, 500, "Завтрак", dima.getId(), now);
        admin.addService(3, 15000, "Уборка", dima.getId(), now);
        admin.addService(2, 1000, "Трансфер", katya.getId(), now);
        admin.printGuestServiceList(dima);
        admin.changeRoomPrice(2, 2700);
        admin.changeServicePrice(1, 550);
        admin.printAvailableRooms();
        admin.printRoomsAvailableAt(now.minusDays(1));
        admin.checkIn(dima, 3, now.minusDays(20), now.minusDays(19));
        admin.checkOut(dima);
        admin.checkIn(katya, 3, now.minusDays(18), now.minusDays(17));
        admin.checkOut(katya);
        admin.checkIn(danya, 3, now.minusDays(16), now.minusDays(15));
        admin.checkOut(danya);
        admin.checkIn(tonya, 3, now.minusDays(13), now.minusDays(12));
        admin.checkOut(tonya);
        admin.checkIn(tanya, 3, now.minusDays(11), now.minusDays(10));
        admin.checkOut(tanya);
        admin.checkIn(roma, 3, now.minusDays(9), now.minusDays(8));
        admin.checkOut(roma);
        admin.checkIn(odysseus, 3, now.minusDays(7), now.minusDays(6));

        admin.checkIn(dima, 1, now, now.plusDays(2));
        admin.checkIn(katya, 2, now.plusHours(2), now.plusDays(5).plusHours(2));
        admin.checkIn(danya, 2, now.plusDays(3), now.plusDays(4));
        admin.printFullPrice(bookingRepo.GetBookingByGuest(katya));
        admin.printRoomsAvailableAt(now.plusDays(6));
        admin.printAvailableRooms();
        admin.printOccupiedRooms();
        admin.printLastGuests(3);
        System.out.println("--- Текущие бронирования ---");
        for (Booking b : bookingRepo.getBookings()) {
            System.out.println(b);
        }

    }
}
