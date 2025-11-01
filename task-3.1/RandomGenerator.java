import java.util.Random;

public class RandomGenerator {
    private static int generateRandomInt() {
        return (int) (new Random().nextInt(900) + 100);
    }
    private static int calculateSum(int a){
        return a % 10 + a % 100 / 10 + a / 100;
    }
    public static void main(String[] args) {
        int x = generateRandomInt();
        System.out.println(x);
        System.out.println(calculateSum(x));
    }
}
