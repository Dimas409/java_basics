public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer("MSI", "Creator P50",
                new Processor(4.40, 6, TypeCPU.INTEL, 0.05),
                new RAM(TypeRAM.DDR4, 16, 0.08),
                new Storage(TypeStorage.SSD, 1000, 0.1),
                new Monitor(27.0, TypeMatrix.IPS, 7.0),
                new Keyboard(TypeKeyboard.MEMBRANE, Backlight.NO,0.7));
        System.out.printf("Вес компьютера: %.2f кг.", computer.weightOfComputer());
        System.out.println();
        System.out.println(computer);
        Computer computer1 = new Computer("ALIENWARE", "Aurora",
                new Processor(5.2, 8, TypeCPU.INTEL, 0.05),
                new RAM(TypeRAM.DDR5, 64, 0.08),
                new Storage(TypeStorage.SSD, 2000, 0.05),
                new Monitor(32.0, TypeMatrix.IPS, 8.5),
                new Keyboard(TypeKeyboard.MECHANICAL, Backlight.YES, 0.8));
        System.out.printf("Вес компьютера: %.2f", computer1.weightOfComputer());
        System.out.println();
        System.out.println(computer1);



    }
}
