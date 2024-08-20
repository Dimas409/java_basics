

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ForkJoinPool;


public class SiteMapCrawler {
    public static final String BASE_URL = "https://www.playback.ru";
    public static final int PAUSE_TIME_MS = 200;
    public static final int MAX_DEPTH = 20;

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        Set<String> visitedUrls = new TreeSet<>();
        visitedUrls.add(BASE_URL);
        Set<String> links = pool.invoke(new CrawlTask(BASE_URL,  visitedUrls, 0));
        CrawlTask.saveUrlToFile(links);

    }
}
