

public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket(50.5);
        basket.add("Pasta", 56, 2, 0.45);
        basket.add("Rice", 80, 1, 4.5);
        basket.print("Basket");
        System.out.println(basket.getTotalPrice());
        System.out.println(basket.getTotalWeight());



    }
}
