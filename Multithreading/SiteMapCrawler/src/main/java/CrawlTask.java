import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.RecursiveTask;

public class CrawlTask extends RecursiveTask<Set<String>> {
    private final String url;
    private final int depth;
    private final Set<String> visited;

    public CrawlTask(String url, Set<String> visitedUrls,  int depth) {
        this.url = url;
        this.depth = depth;
        this.visited = visitedUrls;
    }

    @Override
    protected Set<String> compute() {
        Set<String > links = new HashSet<>();
        if (depth > SiteMapCrawler.MAX_DEPTH) {
            return links;
        }
        try {
            Thread.sleep(SiteMapCrawler.PAUSE_TIME_MS);
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36")
                    .referrer("https://www.google.com")
                    .get();
            Elements elements = document.select("a[href]");
            for (Element element : elements) {
                String link = element.attr("abs:href");
                if (!visited.contains(link) && isValidUrl(link)) {
                    visited.add(link);
                    links.add(link);

                    CrawlTask task = new CrawlTask(link, visited, depth + 1);
                    task.fork();
                    links.addAll(task.join());
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return links;
    }

    private boolean isValidUrl(String url) {
        return url.startsWith(SiteMapCrawler.BASE_URL) &&
                !url.contains("#") &&
                !url.contains(".pdf") &&
                !url.endsWith(".jpg") &&
                !url.endsWith(".png");
    }

    public static void saveUrlToFile(Set<String> set) {
        ArrayList<String> arrayList = new ArrayList<>(set);
        ArrayList<String> correctDepthList = new ArrayList<>();
        Collections.sort(arrayList);
        arrayList.forEach(link -> {
            int count = (int) link.chars().filter(ch -> ch == '/').skip(3).count();
            String indentedLink = "\t".repeat(Math.max(0, count)) + link;
            correctDepthList.add(indentedLink);
        });
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sitemap.txt", true))) {
            correctDepthList.forEach(l -> {
                try {
                    writer.write(l + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

}
