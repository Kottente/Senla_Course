package Hotel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomRepositoryImpl implements RoomRepository {
    private final Map<Integer, Room> RoomList = new HashMap<>();

    @Override
    public Room getRoomByID(int id) {
        if(RoomList.get(id) == null) {
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
        if(RoomList.get(room.getRoomID()) == null) {
            System.out.println("Такой комнаты не существует");
        }
        else {
            RoomList.put(room.getRoomID(), room);
        }
    }

    @Override
    public List<Room> getAllRooms() {
        return new ArrayList<>(RoomList.values());
    }

}
