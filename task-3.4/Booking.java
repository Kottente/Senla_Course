import java.time.LocalDateTime;

public class Booking {
    private final int bookingID;
    private final LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;
    private final int guestId;
    private final int roomId;
    private boolean booked;

    public Booking(int bookingID, LocalDateTime checkInDate, LocalDateTime checkOutDate, int guestId, int roomId) {
        this.roomId = roomId;
        this.bookingID = bookingID;
        this.checkInDate = checkInDate;
        this.guestId = guestId;
        this.booked = true;
        this.checkOutDate = checkOutDate;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getBookingID() {
        return bookingID;
    }

    public LocalDateTime getCheckInDate() {
        return checkInDate;
    }

    public LocalDateTime getCheckOutDate() {
        return checkOutDate;
    }

    public int getGuestId() {
        return guestId;
    }

    public boolean isBooked() {
        return booked;
    }

    public void closeBooking() {
        this.booked = false;
    }

    public void updateCheckOutDate(LocalDateTime Date) {
        this.checkOutDate = Date;
    }

    public String toString() {
        return "bookingID: " + bookingID + " checkInDate: " + checkInDate + " checkOutDate: " + checkOutDate + " guestID: " + guestId;
    }
}
