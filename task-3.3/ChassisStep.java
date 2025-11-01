public class ChassisStep implements ILineStep {
    @Override
    public IProductPart buildProductPart() {
        System.out.println("ChassisStep: собираю шасси…");
        sleepShort();
        Chassis chassis = new Chassis("передний привод");
        System.out.println("ChassisStep: готово → " + chassis);
        return chassis;
    }
    private static void sleepShort() { try { Thread.sleep(200); } catch (InterruptedException ignored) {} }
}