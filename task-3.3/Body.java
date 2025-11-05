public class Body implements IProductPart {
    private final String type;
    public Body(String type) { this.type = type; }
    public String toString() { return "Кузов (" + type + ")"; }
}