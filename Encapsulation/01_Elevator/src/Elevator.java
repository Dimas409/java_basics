public class Elevator {
    private int currentFloor = 1;
    private int minFloor;
    private int maxFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }
    public void moveUp() {
        currentFloor++;
    }
    public void moveDown() {
        currentFloor--;
    }
    public void move(int floor) {
        while (currentFloor != floor){
        if (floor > maxFloor || floor < minFloor) {
            System.out.println("Этаж введен не корректно!");
            break;
        }
        if (currentFloor < floor) {
            moveUp();
            System.out.println(currentFloor);
        }
        if (currentFloor > floor) {
            moveDown();
            System.out.println(currentFloor);
        }
        }
    }
}