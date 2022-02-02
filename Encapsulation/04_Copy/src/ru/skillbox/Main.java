package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(22, 23, 25);
        dimensions.Volume();
        System.out.println(dimensions.Volume());

        CargoInfo cargoInfo = new CargoInfo(25,45, "Lenina Street 12", "Don't flip", "Fragile cargo");
        System.out.println(cargoInfo.getAbilityToFlip());
        System.out.println(cargoInfo.getFragileCargo());
        System.out.println(cargoInfo.getDeliveryAddress());
        System.out.println(cargoInfo.getDimensions());
        System.out.println(cargoInfo.getMass());
    }
}
