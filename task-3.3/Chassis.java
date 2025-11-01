public class Chassis implements IProductPart {
    private final String drive;
    public Chassis(String drive) { this.drive = drive; }
    public String toString() { return "Шасси (" + drive + ")"; }
}