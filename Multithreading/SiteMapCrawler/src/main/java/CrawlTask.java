import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.RecursiveAction;

public class CrawlTask extends RecursiveAction {
    private final String url;
    private int depth;
    private final Set<String> visitedUrls;

    public CrawlTask(String url, int depth, Set<String> visitedUrls) {
        this.url = url;
        this.depth = depth;
        this.visitedUrls = visitedUrls;
    }

    @Override
    protected void compute() {
        if (depth <= SiteMapCrawler.MAX_DEPTH && visitedUrls.add(url)) {
            try {
                Document doc = Jsoup.connect(url).get();
                Thread.sleep(SiteMapCrawler.PAUSE_TIME_MS);
                if(depth < SiteMapCrawler.MAX_DEPTH) {
                    Elements links = doc.select("a[href]");
                    for (Element link : links) {
                        String childUrl = link.absUrl("href");
                        if (isValidUrl(childUrl) && !visitedUrls.contains(childUrl)) {
                            CrawlTask task = new CrawlTask(childUrl, depth++ , visitedUrls);
                            visitedUrls.add(childUrl);
                            task.fork();
                        }
                    }
                }
                saveUrlToFile(visitedUrls);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private boolean isValidUrl(String url) {
        return url.startsWith(SiteMapCrawler.BASE_URL) &&
                !url.contains("#") &&
                !url.endsWith(".pdf") &&
                !url.endsWith(".jpg") &&
                !url.endsWith(".png");
    }

    private void saveUrlToFile(Set<String> set) {
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
