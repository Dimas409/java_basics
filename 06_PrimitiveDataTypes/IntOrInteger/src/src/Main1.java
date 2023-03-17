



public class Main1 {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());


        for (int i = 168; i < 1104; i++) {
                char s = (char)i;
                if(i == 203 || i == 235 || i >= 1040){
                    System.out.println(i +" - "+ s);
                }

        }

    }
}
