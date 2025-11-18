import java.time.LocalDateTime;

public class Service {
    private final int id;
    private final String name;
    private int price;
    private final int guestId;
    private final LocalDateTime arrangedTime;

    public Service(int id, String name, int price, int guestId, LocalDateTime arrangedTime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.guestId = guestId;
        this.arrangedTime = arrangedTime;
    }

    public LocalDateTime getArrangedTime() {
        return arrangedTime;
    }

    public int getGuestId() {
        return guestId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void changePrice(int price) {
        if (price != this.price && price > 0) {
            this.price = price;
            System.out.println("Стоимость услуги успешно обновлена");
        } else {
            System.out.println("Не получилось поменять стоимость услуги");
        }
    }
    public String toString() {
        return "Услуга: " + getName() + " Стоимость: " + getPrice();
    }
}
