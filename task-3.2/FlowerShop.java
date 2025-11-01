import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args) {
        boolean running = true;
        Bouquet bouquet = new Bouquet();
        while (running) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Выбери что будешь делать: ");
            System.out.println("1. Добавить цветок в букет");
            System.out.println("2. Убрать цветок из букета");
            System.out.println("3. Показать собранный букет и его цену");
            System.out.println("4. Показать цену букета отдельно");
            System.out.println("5. Закончить сборку букета");
            int choice = sc.nextInt();
            int NoOfFlower;
            switch (choice) {
                case 1:
                    System.out.println("Выберите Цветок:");
                    System.out.println("1.Роза - 500 р.");
                    System.out.println("2.Тюльпан - 200р.");
                     NoOfFlower = sc.nextInt();
                    bouquet.expandBouquet(NoOfFlower);
                    break;
                case 2:
                    System.out.println("Выберите Цветок:");
                    System.out.println("1.Роза");
                    System.out.println("2.Тюльпан");
                     NoOfFlower = sc.nextInt();
                     switch (NoOfFlower) {
                         case 1:
                             bouquet.remFlower(bouquet.getFlowerByName("Роза"));
                             break;
                         case 2:
                             bouquet.remFlower(bouquet.getFlowerByName("Тюльпан"));
                     }

                    break;
                case 3:
                    bouquet.displayBouquet();
                    break;
                case 4:
                    System.out.println("Общая цена: ");
                    System.out.println(bouquet.fullPrice());
                    break;
                case 5:
                    bouquet.displayBouquet();
                    running = false;
                    break;
                default:
                    System.out.println("Недопустимый ввод");
            }
        }
    }
}
