public class Printer {
    static int firstCounter = 0;
    static int secondCounter = 0;
    static int thirdCounter = 0;
    static int count1 = 0;
    static int count2 = 0;
    static int count3 = 0;
    static private String queue = "";
    public static void main(String[] args) {
        append("Страничка", 1);
        append("Документ", 2);
        append("Текст", "Методичка", 23);
        append("Входной контроль", 3, "Заказ-заявка");
        print("");
        System.out.println("Количество страниц на печать: ");
        System.out.println(getPendingPagesCount());
        clear();
        print("");
        System.out.println(getPendingPagesCount());
        System.out.println("Страниц распечатано за все время: ");
        System.out.println(totalNumberOfPrintedPages());

    }

    public static   void append (String textOfDoc, int count ){
        queue += "\n" + textOfDoc +" "+ count + " шт.";
        thirdCounter += count;
        count1 += count;
    }
    public static   void append (String textOfDoc, int count , String nameOfDoc ){
        queue += "\n" + textOfDoc +" "+ nameOfDoc +" "+ count + " шт.";
        secondCounter += count;
        count2 += count;
    }
    public static   void append (String textOfDoc, String nameOfDoc, int count ){
        queue += "\n" + textOfDoc +" "+ nameOfDoc +" "+ count + " шт.";
        firstCounter+=count;
        count3 += count;
    }
    public static int getPendingPagesCount(){
        return firstCounter+
                secondCounter+
                thirdCounter;

    }
    public static int totalNumberOfPrintedPages() {
        return count1+
                count2+
                count3;
    }

    public static void clear() {
        queue = "";
        firstCounter = 0;
        secondCounter = 0;
        thirdCounter = 0;
    }
    public static void print (String title){
        System.out.println(title);
        if(queue.isEmpty()){
            System.out.println("Очередь печати: ");
        } else {
            System.out.println(queue);
        }
    }
}
