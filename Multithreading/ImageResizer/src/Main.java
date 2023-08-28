import java.io.File;

public class Main {
    public static int NUMBER_OF_FILE = 0;
    public static int THREAD_NUMBER = 1;
    public static int NEW_WIDTH = 1600;
    public static String DST_FOLDER = "C:\\Users\\User\\IdeaProjects\\java_basics\\Multithreading\\ImageResizer\\dstImages";
    public static String SRC_FOLDER = "C:\\Users\\User\\IdeaProjects\\java_basics\\Multithreading\\ImageResizer\\sourseImages";
    public static long START = System.currentTimeMillis();
    public  static int AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();
    public static void main(String[] args) {
        File srcDir = new File(SRC_FOLDER);
        File[] files = srcDir.listFiles();

        for (int i = 0; i < AVAILABLE_PROCESSORS; i++) {
            assert files != null;
            resizeMethod(files);
        }

    }
    public static void resizeMethod(File[] files){
        File[] file = new File[files.length / AVAILABLE_PROCESSORS];
        System.arraycopy(files, NUMBER_OF_FILE, file,0,  file.length);
        ImageResizer imageResizer = new ImageResizer(file, NEW_WIDTH, DST_FOLDER, START, THREAD_NUMBER);
        new Thread(imageResizer).start();
        NUMBER_OF_FILE += files.length / AVAILABLE_PROCESSORS;
        THREAD_NUMBER++;
    }
}
