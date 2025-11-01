import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.sort;

public class BookingRepoRealisation implements BookingRepository {
    private final Map<Integer, Booking> bookings = new HashMap<>();
    @Override
    public Booking GetBookingById(int id) {
        return bookings.get(id);
    }

    @Override
    public int CurBookingId() {
        if (bookings.isEmpty()) return 0;
        List<Integer> bookingIds = new ArrayList<>(bookings.keySet());
        sort(bookingIds);
        int missedKey = -1;
        for (int i = 0; i < bookingIds.size(); i++) {
            if (i != bookingIds.get(i)) {
                missedKey = i;
                break;
            }
        }
        if (missedKey == -1) return bookingIds.size();

        return missedKey;
    }

    @Override
    public void addBooking(Booking booking) {
        int id = booking.getBookingID();
        if (bookings.get(id) != null) {
            System.out.println("Такой идентификатор уже существует");
        }
        if (!checkBooking(booking)) return;
        bookings.put(id, booking);
    }

    @Override
    public void updateBooking(Booking booking) {
        if (bookings.get(booking.getBookingID()) == null) {
            System.out.println("Не получилось обновить информацию о бронировании");
        }
        bookings.put(booking.getBookingID(), booking);
    }

    @Override
    public boolean checkBooking(Booking booking) {
        int roomId = booking.getRoomId();
        for (Booking i : bookings.values()) {
            if (i.getRoomId() == roomId) {
                LocalDateTime in = booking.getCheckInDate();
                LocalDateTime out = i.getCheckOutDate();
                if (out.isAfter(in)) {
                    System.out.println("Бронь на это время уже существует");
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void deleteBooking(Booking booking) {
        if (bookings.containsKey(booking.getBookingID())) {
            bookings.remove(booking.getBookingID());
            return;
        }
        System.out.println("Такого бронирования пока нет");
    }

    @Override
    public List<Booking> getBookings() {
        return new ArrayList<>(bookings.values());
    }
}
