import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Loader implements Runnable {
    private static final char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
    private final int startRegion;
    private final int endRegion;

    public Loader(int startRegion, int endRegion) {
        this.startRegion = startRegion;
        this.endRegion = endRegion;
    }

    public static void main(String[] args) {
        int maxCountRegions = 199;
        int countOfThreads = 3;
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(countOfThreads);
        for(int i = 0; i < countOfThreads; i++){
            int startRegion = i * (maxCountRegions / countOfThreads) + 1;
            int endRegion = (i + 1) * (maxCountRegions / countOfThreads) + 1;
            executorService.submit(new Loader(startRegion, endRegion));
        }

        executorService.shutdown();
        try {
            if(!executorService.awaitTermination(1, TimeUnit.MINUTES)){
                System.err.println("Не удалось завершить выполнение всех задач в течение заданного времени.");
            }
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.err.println("Произошло прерывание ожидания завершения задач.");
        }
        System.out.println((System.currentTimeMillis() - start) + " ms");
    }
    private static String padNumber(int number, int numberLength) {
        int maxLen = Math.max(numberLength, Integer.toString(number).length());
        StringBuilder paddedStr = new StringBuilder(maxLen);
        for (int i = 0; i < maxLen - Integer.toString(number).length(); i++) {
            paddedStr.append('0');
        }
        paddedStr.append(number);
        return paddedStr.toString();
    }

    @Override
    public void run() {
            try (PrintWriter writer = new PrintWriter("res/numbers" + startRegion + ".txt")) {
                for (int regionCode = startRegion; regionCode < endRegion; regionCode++) {
                    StringBuilder builder = new StringBuilder();
                    for (int number = 1; number < 1000; number++) {
                        for (char firstLetter : letters) {
                            for (char secondLetter : letters) {
                                for (char thirdLetter : letters) {
                                    builder.append(firstLetter)
                                            .append(padNumber(number, 3))
                                            .append(secondLetter)
                                            .append(thirdLetter)
                                            .append(padNumber(regionCode, 2))
                                            .append("\n");
                                }
                            }
                        }
                    }
                    writer.write(builder.toString());
                }
            } catch (IOException e) {
                throw new RuntimeException();
            }
    }
}
