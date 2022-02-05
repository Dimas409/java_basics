package ru.skillbox;

public class CargoInfo {
    private final Dimensions dimensions;
    private final float mass ;
    private final String deliveryAddress;
    private final String abilityToFlip;
    private final String fragileCargo;

    public CargoInfo( Dimensions dimensions, float mass, String deliveryAddress, String abilityToFlip, String fragileCargo) {
        this.dimensions = dimensions;
        this.mass = mass;
        this.deliveryAddress = deliveryAddress;
        this.abilityToFlip = abilityToFlip;
        this.fragileCargo = fragileCargo;
    }

    public CargoInfo(Dimensions dimensions) {
        this.dimensions = dimensions;
        mass = 0;
        deliveryAddress = "N/A";
        abilityToFlip = "N/A";
        fragileCargo = "N/A";
    }

    public Dimensions getDimensions() {
        return dimensions ;
    }
    public CargoInfo setDimensions(Dimensions dimensions) {
        return new CargoInfo(dimensions, mass, deliveryAddress, abilityToFlip, fragileCargo);
    }

    public float getMass() {
        return mass;
    }
    public CargoInfo setMass(float mass) {
        return new CargoInfo(dimensions, mass, deliveryAddress, abilityToFlip, fragileCargo);
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }
    public CargoInfo setDeliveryAddress(String deliveryAddress) {
        return new CargoInfo(dimensions, mass, deliveryAddress, abilityToFlip, fragileCargo);
    }

    public String getAbilityToFlip() {
        return abilityToFlip;
    }
    public CargoInfo setAbilityToFlip(String abilityToFlip) {
        return new CargoInfo(dimensions, mass, deliveryAddress, abilityToFlip, fragileCargo);
    }

    public String getFragileCargo() {
        return fragileCargo;
    }
    public CargoInfo setFragileCargo(String fragileCargo) {
        return new CargoInfo(dimensions, mass, deliveryAddress, abilityToFlip, fragileCargo);
    }
}