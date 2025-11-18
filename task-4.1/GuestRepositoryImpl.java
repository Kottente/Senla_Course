import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GuestRepositoryImpl implements GuestRepository {
    private final Map<Integer, Guest> guests = new HashMap<>();
    public Comparator<Guest> byName = Comparator.comparing(Guest::getName);

    @Override
    public void addGuest(Guest g) {
        if (!guests.containsKey(g.getId())) {
            guests.put(g.getId(), g);
            return;
        }
        System.out.println("Гость с таким идентификатором уже существует");
    }

    @Override
    public Guest getGuestById(int id) {
        if (!guests.containsKey(id)) {
            System.out.println("Гостя с таким идентификатором не существует");
            return null;
        }
        return guests.get(id);
    }

    @Override
    public void deleteGuest(int id) {
        if (!guests.containsKey(id)) {
            System.out.println("Гостя с таким идентификатором не существует");
            return;
        }
        guests.remove(id);
    }

    @Override
    public List<Guest> GetAllGuestsNames() {
        return guests.values().stream().sorted(byName).collect(Collectors.toList());
    }
}
