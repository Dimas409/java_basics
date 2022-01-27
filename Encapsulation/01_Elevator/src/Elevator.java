public class Elevator {
    private int currentFloor = 1;
    private int minFloor;
    private int maxFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }
    public void moveUp() {
        currentFloor = (currentFloor < maxFloor) ? currentFloor + 1 : currentFloor;
    }
    public void moveDown() {
        currentFloor = (currentFloor > minFloor) ? currentFloor - 1 : currentFloor;
    }
    public void move(int floor) {
        while (currentFloor != floor){
            if (floor < minFloor || floor > maxFloor) {
                System.out.println("Этаж введен некорректно");
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