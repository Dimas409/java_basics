package Parce_CSV;

import SearchFilesInFolders.SearchFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Parse_CSV {
    private static final SearchFiles searchFiles = new SearchFiles();
    private static final Dates_Stations_Opened dateStat = new Dates_Stations_Opened();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public List<Dates_Stations_Opened> getDate_Stations(){
        List<File> files = searchFiles.getCSV();
        List<Dates_Stations_Opened> dateStatList = new ArrayList<>();
        try {
            for (File file : files) {
                BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
                String line;
                String firstLine = null;
                while ((line = br.readLine()) != null){
                    if(firstLine == null){
                        firstLine = line;
                        continue;
                    }
                    String[] data = line.split(",");
                    LocalDate localDate = LocalDate.parse(data[1], dateStat.getDTf());
                    String date = localDate.format(formatter).trim();
                    dateStatList.add(new Dates_Stations_Opened(data[0], date));
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return dateStatList;
    }

}
