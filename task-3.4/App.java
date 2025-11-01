import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {
        BookingRepository bookingRepo = new BookingRepoRealisation();
        RoomRepository roomRepo = new RoomRepoRealisation();
        ServiceRepository serviceRepo = new ServiceRepoRealisation();

        HotelService admin = new HotelService(bookingRepo, roomRepo, serviceRepo);

        System.out.println("ДЕМО: Электронный администратор гостиницы.");

        admin.addRoom(1, 3500, "101");
        admin.addRoom(2, 2500, "102");
        admin.addService(1, 500, "Завтрак");
        admin.addService(2, 1000, "Трансфер");

        admin.changeRoomPrice(2, 2700);
        admin.changeServicePrice(1, 550);

        admin.changeRoomStatus(2, RoomStatus.MAINTENANCE);
        admin.changeRoomStatus(2, RoomStatus.SERVICED);
        admin.changeRoomStatus(2, RoomStatus.AVAILABLE);

        Guest dima = new Guest("Дима", 101);
        Guest katya = new Guest("Катя", 102);

        LocalDateTime now = LocalDateTime.now();
        admin.checkIn(dima, 1, now, now.plusDays(2));
        admin.checkIn(katya, 2, now.plusHours(2), now.plusDays(1).plusHours(2));

        System.out.println("--- Текущие бронирования ---");
        for (Booking b : bookingRepo.getBookings()) {
            System.out.println(b);
        }

    }
}
