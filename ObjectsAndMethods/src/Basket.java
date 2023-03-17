public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private int totalCount;
    private double maxWeight;
    private double totalWeight = 0;
    public static int averagePriceInAllBaskets;
    public static int priceItemsInAllBaskets;
    public static int amountItemsInAllBaskets;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 100000;
        this.maxWeight = 200;


    }

    public Basket (double maxWeight) {
        this.maxWeight = maxWeight;
        this.items = " ";
        getTotalWeight();
        this.limit = 30;
        getTotalPrice();


    }


    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public static int getAveragePriceAllItemsInAllBaskets() {
        return priceItemsInAllBaskets / amountItemsInAllBaskets;
    }
    public static int averagePriceAllBaskets(){
        return priceItemsInAllBaskets / count;
    }

    public static int getPriceItemsInAllBaskets() {
        return priceItemsInAllBaskets;
    }

    public static void setPriceItemsInAllBaskets(int priceItemsInAllBaskets) {
        Basket.priceItemsInAllBaskets += priceItemsInAllBaskets;
    }

    public static int getAmountItemsInAllBaskets() {
        return amountItemsInAllBaskets;
    }

    public static void setAmountItemsInAllBaskets(int amountItemsInAllBaskets) {
        Basket.amountItemsInAllBaskets += amountItemsInAllBaskets;
    }

    public static int getCount() {
        return count;
    }
    public double getTotalWeight() {
        return totalWeight;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }


    public void add(String name, int price) {
        add(name, price, 1, 0);
    }
    public void add(String name , int price, double weight){
        add(name, price, 1, weight);
    }

    public void add(String name, int price, int count) {
        add(name, price, count,0);


    }
    public void add(String name, int price, int count, double weight){
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }
        if(totalWeight + weight >= maxWeight) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }
        items = items + "\n" + name + " - " +
                count + " шт. - " + price + " руб " + (weight > 0 ? weight +" кг. ": "");
        totalWeight += weight;
        totalPrice = totalPrice + (count * price);
        totalCount = totalCount + count;
        setPriceItemsInAllBaskets(count * price);
        setAmountItemsInAllBaskets(count);


    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
