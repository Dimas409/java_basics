

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ForkJoinPool;


public class SiteMapCrawler {
    public static final String BASE_URL = "https://skillbox.ru/";
    public static final int PAUSE_TIME_MS = 200;
    public static final int MAX_DEPTH = 3;

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        Set<String> visitedUrls = new TreeSet<>();
        pool.invoke(new CrawlTask(BASE_URL, 0, visitedUrls));

    }
}
