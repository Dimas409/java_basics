package Parce_CSV;

import lombok.*;

import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "dTf")
public class Dates_Stations_Opened {
    @NonNull
    private final DateTimeFormatter dTf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private String name_Of_Station;
    private String date_station_opened;
}
