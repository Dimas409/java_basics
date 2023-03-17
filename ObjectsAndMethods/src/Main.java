

public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Макароны", 56, 2, 0.45);
        basket.add("Рис", 80, 1, 4.5);
        basket.add("Молоко", 69);
        basket.add("Сникерс", 56, 3);
        basket.add("Картофель", 200, 4.5);
        basket.print("Первая корзина");
        Basket basket1 = new Basket();
        basket1.add("Мороженое", 250);
        basket1.add("Лопата", 300, 1);
        basket1.add("Кружка", 70, 2);
        basket1.print("Вторая корзина");
        Basket basket2 = new Basket();
        basket2.add("Клавиатура", 2000, 1);
        System.out.println("Цена во всех корзинах " + Basket.getPriceItemsInAllBaskets());
        System.out.println("Количество товаров во всех корзинах: " + Basket.getAmountItemsInAllBaskets());
        System.out.println("Средняя цена товара во всех корзинах: " + Basket.getAveragePriceAllItemsInAllBaskets());
        System.out.println("Средняя цена корзнины: " + Basket.averagePriceAllBaskets());



    }
}
