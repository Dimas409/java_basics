package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(22, 23, 25);
        dimensions.Volume();
        System.out.println(dimensions.Volume());
        CargoInfo cargoInfo = new CargoInfo(new Dimensions(23, 25,45), 25,
                "Lenina street 15", false, false);

        System.out.println(cargoInfo);

    }
}
