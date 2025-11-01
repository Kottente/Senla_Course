public class Assembler {
    public static void main(String[] args) {
        IAssemblyLine carLine = new AssemblyLine(
                new BodyStep(),
                new ChassisStep(),
                new EngineStep()
        );

        Car blankCar = new Car();
        Car readyCar = (Car) carLine.assembleProduct(blankCar);

        System.out.println("Готово: " + readyCar);
    }
}
