public class Computer {
     private final String vendor;
     private final String name;
    private Processor processor;
    private RAM ram;
    private Storage storage;
    private Monitor monitor;
    private Keyboard keyboard;



    public Computer(String vendor, String name, Processor processor, RAM ram, Storage storage, Monitor monitor, Keyboard keyboard) {
        this.vendor = vendor;
        this.name = name;
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.monitor = monitor;
        this.keyboard = keyboard;
    }

    public String getVendor() {
        return vendor;
    }


    public String getName() {
        return name;
    }


    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public double weightOfComputer(){
        return processor.getWeight() + ram.getWeight() + storage.getWeight() + monitor.getWeight() + keyboard.getWeight();
    }

    @Override
    public String toString() {
        return "Компьютер:\n " +
                "производитель - " + vendor + '\'' +
                ", \n название компьтера - " + name + '\'' +
                ", " + processor +
                ", " + ram +
                ", " + storage +
                ", " + monitor +
                ", " + keyboard;
    }
}
