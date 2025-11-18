import java.util.List;

public interface BookingRepository {

    void addBooking(Booking booking);
    void updateBooking(Booking booking);
    boolean checkBooking(Booking booking);
    void deleteBooking(Booking booking);
    List<Booking> getBookings();
    int CurBookingId();
    Booking GetBookingById(int id);
    List<Booking> findBookingForGuest(int guestId);
    Booking GetBookingByGuest(Guest guest);
    List<Booking> findBookingForRoom(int roomId);
}
