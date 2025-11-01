public class Service {
    private final int id;
    private final String name;
    private int price;

    public Service(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void changePrice(int price) {
        if (price != this.price && price > 0) {
            this.price = price;
            System.out.println("Стоимость услуги успешно обновлена");
        } else {
            System.out.println("Не получилось поменять стоимость услуги");
        }
    }
}
