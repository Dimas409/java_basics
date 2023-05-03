import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.plusHours(3);

        return airport.getTerminals().stream()
                .map(Terminal::getFlights)
                .flatMap(Collection::stream)
                .filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE))
                .filter(flight -> flight.getDate().getHours() > localDateTime.getHour())
                .filter(flight -> flight.getDate().getHours() < localDateTime1.getHour())
                .collect(Collectors.toList());
    }

}