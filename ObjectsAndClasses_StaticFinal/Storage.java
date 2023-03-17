public class Storage {
    private final TypeStorage type;
    private final int volumeOfStorage;
    private final double weight;

    public Storage(TypeStorage type, int volumeOfStorage, double weight) {
        this.type = type;
        this.volumeOfStorage = volumeOfStorage;
        this.weight = weight;
    }

    public TypeStorage getType() {
        return type;
    }

    public int getVolumeOfStorage() {
        return volumeOfStorage;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "\nНакопитель информации:\n " +
                "тип накопителя " + type +
                ", \n объём памяти накопителя " + volumeOfStorage +
                ", \n вес накопителя " + weight + " кг.";
    }
}
