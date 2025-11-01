public class AssemblyLine implements IAssemblyLine {
    private final ILineStep step1;
    private final ILineStep step2;
    private final ILineStep step3;

    public AssemblyLine(ILineStep step1, ILineStep step2, ILineStep step3) {
        this.step1 = step1;
        this.step2 = step2;
        this.step3 = step3;
    }

    @Override
    public IProduct assembleProduct(IProduct product) {
        product.setPart1(step1.buildProductPart());
        product.setPart2(step2.buildProductPart());
        product.setPart3(step3.buildProductPart());
        return product;
    }
}