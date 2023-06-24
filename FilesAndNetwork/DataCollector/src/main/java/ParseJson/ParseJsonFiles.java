package ParseJson;

import SearchFilesInFolders.SearchFiles;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ParseJsonFiles {
    private static final SearchFiles searchFiles = new SearchFiles();

    public List<Depth_Station> getDepthStations() {
        List<Depth_Station> dep_stat = new ArrayList<>();
        try {
            List<File> jsons = searchFiles.getJson();
            for (File json : jsons) {
                String jsonStr = Files.readString(Paths.get(json.getPath()));
                JSONArray array = new JSONArray(jsonStr);
                for (int i = 0; i < array.length(); i++) {
                    JSONObject object = array.getJSONObject(i);
                    dep_stat.add(new Depth_Station(object.getString("station_name"), object.getString("depth")));
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return dep_stat;
    }
}
