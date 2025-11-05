public class Guest {
    private final String name;
    private final int id;
    public Guest(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public String toString() {
        return "Имя: " + name + " ID: " + id;
    }
}
