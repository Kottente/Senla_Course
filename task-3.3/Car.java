public class Car implements IProduct {
    private Body body;
    private Chassis chassis;
    private Engine engine;

    public void setBody(Body body) {
        this.body = body;
    }

    public void setChassis(Chassis chassis) {
        this.chassis = chassis;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Автомобиль:\n" +
                "  - " + body + "\n" +
                "  - " + chassis + "\n" +
                "  - " + engine;
    }

    @Override
    public void setPart1(IProductPart part) {
        this.body = (Body) part;
    }

    @Override
    public void setPart2(IProductPart part) {
        this.chassis = (Chassis) part;
    }

    @Override
    public void setPart3(IProductPart part) {
        this.engine = (Engine) part;
    }
}