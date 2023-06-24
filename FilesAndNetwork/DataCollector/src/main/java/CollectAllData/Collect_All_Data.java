package CollectAllData;

import Parce_CSV.Dates_Stations_Opened;
import Parce_CSV.Parse_CSV;
import ParseHTML.ParseHTML;
import Parse_Json.Depth_Station;
import Parse_Json.Parse_JSON_Files;
import ParseHTML.Line;
import ParseHTML.Connections;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.json.JSONObject;


import java.io.File;
import java.io.IOException;
import java.util.*;

public class Collect_All_Data {

    private static final Parse_CSV parseCsv = new Parse_CSV();
    private static final Parse_JSON_Files parseJsonFiles = new Parse_JSON_Files();
    private static final ParseHTML parseHTML = new ParseHTML();


   public List<Stations> collectStations(){
    LinkedHashMap<String , ArrayList<String>> station = parseHTML.parseStation();
    List<ArrayList<String>> stat = new ArrayList<>();
    station.forEach((s, strings) -> stat.add(strings));
    List<Connections> connections = parseHTML.parseConnection();
    List<Line> lines = parseHTML.parseLine();
    List<Dates_Stations_Opened> datesStat = parseCsv.getDate_Stations();
    List<Depth_Station> depth_stations = parseJsonFiles.getDepthStations();
    List<Stations> stations = new ArrayList<>();
    int i = 0;
    for (ArrayList<String> strings : stat) {
       for (String string : strings) {
           stations.add(new Stations(string, lines.get(i).getName(), null, null, false));
       }
       i++;
    }
       for (Dates_Stations_Opened datesStationsOpened : datesStat) {
           for (Stations value : stations) {
               if (datesStationsOpened.getName_Of_Station().equals(value.getName())) {
                   value.setDate(datesStationsOpened.getDate_station_opened());
               }
           }
       }
       for (Depth_Station depthStation : depth_stations) {
           for (Stations station1 : stations) {
               if(depthStation.getStation_name().equals(station1.getName())
                       && !depthStation.getDepth().equals("0") && !depthStation.getDepth().equals("?")){
                   station1.setDepth(depthStation.getDepth());
               }
           }
       }
       for (Connections connection : connections) {
           for (Stations station1 : stations) {
               if(connection.getStation().equals(station1.getName())){
                   station1.setHasConnection(true);
               }
           }
       }

    return stations;
   }

   public void writeJson(){
       try {
           List<Stations> stations = collectStations();
           Map<String, Object> map = new HashMap<>();
           map.put("stations", stations);
           JSONObject object = new JSONObject();
           object.put("stations", map);
           ObjectMapper mapper = new ObjectMapper();
           mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
           ObjectWriter objectWriter = mapper.writer(new DefaultPrettyPrinter());
           objectWriter.writeValue(new File("Json_Finished_Files/JSON_Result_Stations.json"), map);
       } catch (IOException e){
           e.printStackTrace();
       }
       try {
           LinkedHashMap<String, ArrayList<String>> station = parseHTML.parseStation();
           List<Line> lines = parseHTML.parseLine();
           Map<String, Object> mapMetro = new HashMap<>();
           mapMetro.put("stations", station);
           mapMetro.put("lines", lines);
           JSONObject object = new JSONObject();
           object.put("metroData", mapMetro);
           ObjectMapper mapper = new ObjectMapper();
           ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
           writer.writeValue(new File("Json_Finished_Files/JSON_Result_MetroData.json"), mapMetro);
       } catch (IOException e){
           e.printStackTrace();
       }

   }

}
