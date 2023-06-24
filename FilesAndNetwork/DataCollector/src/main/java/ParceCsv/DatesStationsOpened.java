package ParceCsv;

import lombok.*;

import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "dTf")
public class DatesStationsOpened {
    @NonNull
    private final DateTimeFormatter dTf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private String nameOfStation;
    private String dateStationOpened;
}
