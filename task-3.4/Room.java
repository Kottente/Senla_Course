public class Room {
    private final int roomID;
    private RoomStatus status;
    private final String number;
    private int price;

    public Room(int roomID, String number, int price) {
        this.price = price;
        this.number = number;
        this.roomID = roomID;
    }

    public int getRoomID() {
        return roomID;
    }

    public int getPrice() {
        return price;
    }

    public void changePrice(int price) {
        if (price != this.price && price > 0) {
            this.price = price;
            System.out.println("Цена на комнату успешно обновлена");
        } else {
            System.out.println("Не получилось поменять цену комнаты");
        }
    }

    public void markMaintenance() {
        this.status = RoomStatus.MAINTENANCE;
    }

    public void markAvailable() {
        this.status = RoomStatus.AVAILABLE;
    }

    public void markOccupied() {
        this.status = RoomStatus.OCCUPIED;
    }

    public void markAsServiced() {
        this.status = RoomStatus.SERVICED;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public String getNumber() {
        return number;
    }
}
