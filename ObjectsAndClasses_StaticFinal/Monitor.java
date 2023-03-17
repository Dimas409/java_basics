public class Monitor {
    private final double diagonal;
    private final TypeMatrix type;
    private final double weight;

    public Monitor(double diagonal, TypeMatrix type, double weight) {
        this.diagonal = diagonal;
        this.type = type;
        this.weight = weight;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public TypeMatrix getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "\nМонитор:\n " +
                "диагональ монитора " + diagonal +
                ", \n тип матрицы " + type +
                ", \n вес монитора " + weight + " кг.";
    }
}
