public class Keyboard {
    private final TypeKeyboard type;
    private final Backlight backlight;
    private final double weight;

    public Keyboard(TypeKeyboard type, Backlight backlight, double weight) {
        this.type = type;
        this.backlight = backlight;
        this.weight = weight;
    }

    public TypeKeyboard getType() {
        return type;
    }

    public Backlight getBacklight() {
        return backlight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "\nКлавиатура:\n " +
                "тип клавиатуры " + type +
                ", \n наличие подсветки " + backlight +
                ", \n вес клавиатуры " + weight + " кг.";
    }
}
