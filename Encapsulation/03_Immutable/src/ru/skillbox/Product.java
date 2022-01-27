package ru.skillbox;

public class Product {
    private final String name;
    private int price;
    private final float barCode;

    public Product(String name, float barCode) {
        this.name = name;
        this.barCode = barCode;
    }

    public float getBarCode() {
        return barCode;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
