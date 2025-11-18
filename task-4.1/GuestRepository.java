import java.util.List;

public interface GuestRepository {
    void addGuest(Guest g);
    Guest getGuestById(int id);
    void deleteGuest(int id);
    List<Guest> GetAllGuestsNames();
}
