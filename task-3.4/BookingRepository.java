import java.util.List;

public interface BookingRepository {

    void addBooking(Booking booking);
    void updateBooking(Booking booking);
    boolean checkBooking(Booking booking);
    void deleteBooking(Booking booking);
    List<Booking> getBookings();
    public int CurBookingId();
    public Booking GetBookingById(int id);
}
