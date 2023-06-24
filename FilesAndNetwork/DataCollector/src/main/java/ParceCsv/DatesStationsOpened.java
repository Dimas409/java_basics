package ParceCsv;

import lombok.*;

import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
@ToString
public class DatesStationsOpened {
    @NonNull
    private String nameOfStation;
    private String dateStationOpened;
}
