import java.util.*;

public class RoomRepositoryImpl implements RoomRepository {
    private final Map<Integer, Room> RoomList = new HashMap<>();
    public final Comparator<Room> byPriceCapacityCategory = Comparator.comparingInt(Room::getPrice)
            .thenComparing(Room::getCapacity)
            .thenComparing((Room r) -> switch (r.getCategory()) {
                case STANDARD -> 1;
                case SUPERIOR -> 2;
                case DELUXE -> 3;
                case SUITE -> 4;
            });

    @Override
    public Room getRoomByID(int id) {
        if (RoomList.get(id) == null) {
            System.out.println("Такой комнаты не существует");
            return null;
        }
        return RoomList.get(id);
    }

    @Override
    public void addRoom(Room room) {
        if (RoomList.get(room.getRoomID()) == null) {
            RoomList.put(room.getRoomID(), room);
        } else {
            System.out.println("Такая комната уже существует");
        }
    }

    @Override
    public void updateRoom(Room room) {
        if (RoomList.get(room.getRoomID()) == null) {
            System.out.println("Такой комнаты не существует");
        } else {
            RoomList.put(room.getRoomID(), room);
        }
    }

    @Override
    public List<Room> getAllRooms() {
        return RoomList.values().stream().sorted(byPriceCapacityCategory).toList();
    }

    @Override
    public List<Room> getAllVacantRooms() {
        ArrayList<Room> rooms = new ArrayList<>(RoomList.values().stream().toList());
        ArrayList<Room> vacantRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getStatus() == RoomStatus.AVAILABLE) {
                vacantRooms.add(room);
            }
        }
        vacantRooms.sort(byPriceCapacityCategory);
        return vacantRooms;
    }

}
