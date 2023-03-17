public class RAM {
    private final TypeRAM type;
    private final int amountOfRAM;
    private final double weight;

    public RAM(TypeRAM type, int amountOfRAM, double weight) {
        this.type = type;
        this.amountOfRAM = amountOfRAM;
        this.weight = weight;
    }

    public TypeRAM getType() {
        return type;
    }

    public int getAmountOfRAM() {
        return amountOfRAM;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "\nОперативная память:\n " +
                "тип памяти " + type +
                ", \n количество памяти " + amountOfRAM +
                ", \n вес памяти " + weight + " кг.";
    }
}
