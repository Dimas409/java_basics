package ParceCsv;

import SearchFilesInFolders.SearchFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ParseCsv {
    private final SearchFiles searchFiles;
    private final DatesStationsOpened dateStat;

    public ParseCsv() {
        this.searchFiles = new SearchFiles();
        this.dateStat = new DatesStationsOpened();
    }

    public List<DatesStationsOpened> getDate_Stations(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        List<File> files = searchFiles.getCSV();
        List<DatesStationsOpened> dateStatList = new ArrayList<>();
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
                    LocalDate localDate = LocalDate.parse(data[1], formatter);
                    String date = localDate.format(formatter).trim();
                    dateStatList.add(new DatesStationsOpened(data[0], date));
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return dateStatList;
    }

}
