import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bouquet {
//    private final Scanner sc;
//    Bouquet(Scanner sc) {
//        this.sc = sc;
//    }
    private final List<Flower> flowerList = new ArrayList<>();
    public void addFlower(Flower flower) {
        flowerList.add(flower);
    }
    public void expandBouquet(int sc) {
        switch (sc) {
            case 1:
                Rose rose = new Rose("Роза",500);
                addFlower(rose);
                break;
            case 2:
                Tulip tulip = new Tulip("Тюльпан",200);
                addFlower(tulip);
                break;
            default:
                System.out.println("Неверный ввод!");
                break;
        }
    }
    public void displayBouquet() {
        if(flowerList.isEmpty()){
            System.out.println("Пока цветов в букете нет");
            return;
        }
        for(Flower flower : flowerList){
            System.out.println(flower.ToString());
        }
        System.out.println("Общая цена: " + fullPrice());
    }
    public int fullPrice(){
        int sum = 0;
        for(Flower flower : flowerList){
            sum += flower.getPrice();
        }
        return sum;
    }
    public Flower getFlowerByName(String name) {
        for(Flower flower : flowerList){
            if(flower.name.equals(name)){
                return flower;
            }
        }
        System.out.println("Цветок не найден");
        return null;
    }
    public void remFlower(Flower flower) {
        if(!flowerList.contains(flower)){
            System.out.println("Такого цветка в букете нет");
            return;
        }
        flowerList.remove(flower);
    }
}
