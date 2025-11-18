public class Guest {
    private final String name;
    private final int id;
    private int roomId;
    public Guest(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public Guest(String name, int id, int roomId) {
        this.name = name;
        this.id = id;
        this.roomId = roomId;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public boolean checkRoom(Room room) {
        return room.getRoomID() == roomId;
    }
    public int getRoomId() {
        if (roomId == 0) {
            return -1;
        }
        return roomId;
    }
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
    public String toString() {
        return "Имя: " + name + " RoomId: " + roomId;
    }
}
