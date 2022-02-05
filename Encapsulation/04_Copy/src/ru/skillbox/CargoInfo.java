package ru.skillbox;

public class CargoInfo {
    private final Dimensions dimensions;
    private final float mass ;
    private final String deliveryAddress;
    private final boolean abilityToFlip;
    private final boolean fragileCargo;

    public CargoInfo( Dimensions dimensions, float mass, String deliveryAddress, boolean abilityToFlip, boolean fragileCargo) {
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
        abilityToFlip = true;
        fragileCargo = true;
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

    public boolean getAbilityToFlip() {
        return abilityToFlip;
    }
    public CargoInfo setAbilityToFlip(boolean abilityToFlip) {
        return new CargoInfo(dimensions, mass, deliveryAddress, abilityToFlip, fragileCargo);
    }

    public boolean getFragileCargo() {
        return fragileCargo;
    }
    public CargoInfo setFragileCargo(boolean fragileCargo) {
        return new CargoInfo(dimensions, mass, deliveryAddress, abilityToFlip, fragileCargo);
    }
}
