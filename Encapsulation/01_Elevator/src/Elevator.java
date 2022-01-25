public class Elevator {
    private int currentFloor = 1;
    private int minFloor;
    private int maxFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;

    }

    public void move(int floor) {
        while (currentFloor != floor){
        if (floor > maxFloor || floor < minFloor) {
            System.out.println("Этаж введен не корректно!");
            break;
        }
        if (currentFloor < floor) {
            currentFloor++;
            System.out.println(currentFloor);
        }
        if (currentFloor > floor) {
            currentFloor--;
            System.out.println(currentFloor);
        }

        }

    }
}