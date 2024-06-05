import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SAXVoteHandler extends DefaultHandler {
    private SimpleDateFormat visitDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    private Map<Integer, WorkTime> voteStationWorkTimes = new HashMap<>();
    private Map<String, Integer> voterCounts = new HashMap<>();
    private int currentStation;
    private Date currentTime;

    public Map<Integer, WorkTime> getVoteStationWorkTimes() {
        return voteStationWorkTimes;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
        if (qName.equals("voter")) {
            try {
                String key = attributes.getValue("name") + "\t" + attributes.getValue("birthDay");
                voterCounts.put(key, voterCounts.getOrDefault(key, 0) + 1);

                if (voterCounts.size() >= 1000_000) {
                    DBConnection.executeBatchInsert(voterCounts);
                    voterCounts.clear();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (qName.equals("visit")) {
            currentStation = Integer.parseInt(attributes.getValue("station"));
            try {
                currentTime = visitDateFormat.parse(attributes.getValue("time"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            WorkTime workTime = voteStationWorkTimes.getOrDefault(currentStation, new WorkTime());
            workTime.addVisitTime(currentTime.getTime());
            voteStationWorkTimes.put(currentStation, workTime);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        try {
            if (!voterCounts.isEmpty()) {
                DBConnection.executeBatchInsert(voterCounts);
                System.out.println("Final batch insert executed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
