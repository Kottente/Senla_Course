import java.util.List;

public interface RoomRepository {
    Room getRoomByID(int id);
    void addRoom(Room room);
    List<Room> getAllRooms();
    void updateRoom(Room room);
}
