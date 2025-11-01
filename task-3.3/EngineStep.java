public class EngineStep implements ILineStep {
    @Override
    public IProductPart buildProductPart() {
        System.out.println("EngineStep: собираю двигатель…");
        sleepShort();
        Engine engine = new Engine("1.6L MPI");
        System.out.println("EngineStep: готово → " + engine);
        return engine;
    }
    private static void sleepShort() { try { Thread.sleep(200); } catch (InterruptedException ignored) {} }
}