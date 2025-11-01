public class Engine implements IProductPart {
    private final String model;
    public Engine(String model) { this.model = model; }
    public String toString() { return "Двигатель (" + model + ")"; }
}