public class BodyStep implements ILineStep {
    @Override
    public IProductPart buildProductPart() {
        System.out.println("BodyStep: изготавливаю кузов…");
        sleepShort();
        Body body = new Body("седан");
        System.out.println("BodyStep: готово → " + body);
        return body;
    }
    private static void sleepShort() { try { Thread.sleep(200); } catch (InterruptedException ignored) {} }
}
