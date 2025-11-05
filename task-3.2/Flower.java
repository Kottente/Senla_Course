public abstract class Flower {
    protected int price;
    protected String name;
    public Flower(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public int getPrice() {
        return price;
    }

    public String ToString(){
        return name;
    };

}
