public class Processor {
    private final double cpuFrequency;
    private final int amountCore;
    private final TypeCPU type;
    private final double weight;


    public Processor(double cpuFrequency, int amountCore, TypeCPU type, double weight) {
        this.cpuFrequency = cpuFrequency;
        this.amountCore = amountCore;
        this.type = type;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "\nПроцессор:\n " +
                "частота процессора " + cpuFrequency +
                ", \n количество ядер " + amountCore +
                ", \n тип процессора " + type +
                ", \n вес процессора " + weight + " кг.";
    }
}
