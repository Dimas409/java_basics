import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.Map;

public class VoteAnalyzer {
    public static void main(String[] args) throws Exception {

        String fileName = "res/data-18M.xml";
        long start = System.currentTimeMillis();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        SAXVoteHandler handler = new SAXVoteHandler();
        saxParser.parse(new File(fileName), handler);
        System.out.println(System.currentTimeMillis() - start + " ms.");

        Map<Integer, WorkTime> voteStationWorkTimes = handler.getVoteStationWorkTimes();

        System.out.println("Voting station work times: ");
        for (Map.Entry<Integer, WorkTime> entry: voteStationWorkTimes.entrySet()) {
            System.out.println("\t" + entry.getKey() + " - " + entry.getValue());
        }
        long startPrint = System.currentTimeMillis();
        DBConnection.printVoterCounts();
        System.out.println(System.currentTimeMillis() - startPrint + " ms.");



    }
}
