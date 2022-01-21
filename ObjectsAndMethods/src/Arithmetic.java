public class Arithmetic {
    static int sum = 0;
    static int product = 0;
    static int maxNumber = 0;
    static int minNumber = 0;
    public static void main(String[] args) {
        getSum(20, 20);
        System.out.println();
        getProduct(27, 32);
        System.out.println(product);
        getMinNumber(47, 34);
        System.out.println(minNumber);
        getMaxNumber(57, 63);
        System.out.println(maxNumber);


    }
    public static int getSum (int number, int number1){
        sum = number + number1;
        return sum;
    }
    public static int getProduct (int number, int number1){
        product = number * number1;
        return product;
    }
    public static int getMaxNumber (int number, int number1) {
        if (number > number1){
            maxNumber = number;
        } else {
            maxNumber = number1;
        }
        return maxNumber;
    }
    public static int getMinNumber (int number, int number1) {
        if (number < number1) {
            minNumber = number;
        } else {
            minNumber = number1;
        }
        return minNumber;
    }
}
