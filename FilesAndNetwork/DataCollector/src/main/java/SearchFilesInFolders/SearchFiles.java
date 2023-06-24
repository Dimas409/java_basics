package SearchFilesInFolders;

import lombok.NoArgsConstructor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
public class SearchFiles {
    private static final String path = "data";
    private static final File directory = new File(path);

    private List<File> getFileList(File directory){
        List<File> fileList = new ArrayList<>();
        File[] files = directory.listFiles();
        if(files != null){
            for (File file : files) {
                if(file.isDirectory()){
                    fileList.addAll(getFileList(file));
                }else {
                    fileList.add(file);
                }
            }
        }

        return fileList;
    }
    public List<File> getJson(){
        List<File> allFiles = getFileList(directory);
        List<File> jSons = new ArrayList<>();
        for (File file : allFiles) {
            if(file.getName().toLowerCase().endsWith(".json")){
                jSons.add(file);
            }
        }
        return jSons;
    }
    public List<File> getCSV(){
        List<File> allFiles = getFileList(directory);
        List<File> csv = new ArrayList<>();
        for (File file : allFiles) {
            if(file.getName().toLowerCase().endsWith(".csv")){
                csv.add(file);
            }
        }
        return csv;
    }
}
