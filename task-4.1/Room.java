public class Room {
    private final int roomID;
    private RoomStatus status;
    private final String number;
    private final int capacity;
    private int price;
    private final RoomCategory category;

    public Room(int roomID, String number, int price) {
        this.category = RoomCategory.STANDARD;
        this.capacity = 1;
        this.price = price;
        this.number = number;
        this.roomID = roomID;
        this.status = RoomStatus.AVAILABLE;
    }
    public Room(int roomID, String number, int price, RoomCategory category) {
        this.category = category;
        this.capacity = 1;
        this.price = price;
        this.roomID = roomID;
        this.number = number;
    }
    public Room(int roomID, String number, int price, int capacity, RoomCategory category) {
        this.capacity = capacity;
        this.price = price;
        this.roomID = roomID;
        this.number = number;
        this.category = category;
    }
    public int getCapacity() {
        return capacity;
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
    public RoomCategory getCategory() {
        return category;
    }
    public String toString() {
        return "ID: " + roomID + " статус: " + status + " Тип: " + category + " Цена: " + price;
    }
}
