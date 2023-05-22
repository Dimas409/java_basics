import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    List<Station> route = new ArrayList<>();
    List<Station> route2 = new ArrayList<>();
    RouteCalculator routeCalculator;
    StationIndex stationIndex = new StationIndex();
    @Override
    protected void setUp() throws Exception {
        routeCalculator = new RouteCalculator(stationIndex);

        List<Station> connection1 = new ArrayList<>();
        List<Station> connection2 = new ArrayList<>();
        List<Station> connection3 = new ArrayList<>();

        Line line1 = new Line( 1, "Первая");
        Line line2 = new Line(2, "Вторая");
        Line line3 = new Line(3, "Третья");

        Station station1 = new Station("Петровская", line1);
        Station station2 = new Station("Арбузная", line1);
        Station station3 = new Station("Виноградная", line1);
        Station station4 = new Station("Морковная", line2);
        Station station5 = new Station("Яблочная", line2);
        Station station6 = new Station("Абрикосовая", line2);
        Station station7 = new Station("Вишневая", line3);
        Station station8 = new Station("Огуречная", line3);
        Station station9 = new Station("Грушевая", line3);
        route.add(station9);
        route.add(station8);
        route.add(station7);
        route.add(station5);
        route.add(station6);
        route.add(station1);


        route2.add(station3);
        route2.add(station2);
        route2.add(station8);
        route2.add(station7);
        route2.add(station5);
        route2.add(station4);

        line1.addStation(station1);
        line1.addStation(station2);
        line1.addStation(station3);
        line2.addStation(station4);
        line2.addStation(station5);
        line2.addStation(station6);
        line3.addStation(station7);
        line3.addStation(station8);
        line3.addStation(station9);

        connection1.add(station1);
        connection1.add(station6);
        connection2.add(station5);
        connection2.add(station7);
        connection3.add(station8);
        connection3.add(station2);


        stationIndex.addLine(line1);
        stationIndex.addStation(station1);
        stationIndex.addStation(station2);
        stationIndex.addStation(station3);

        stationIndex.addLine(line2);
        stationIndex.addStation(station4);
        stationIndex.addStation(station5);
        stationIndex.addStation(station6);

        stationIndex.addLine(line3);
        stationIndex.addStation(station7);
        stationIndex.addStation(station8);
        stationIndex.addStation(station9);

        stationIndex.addConnection(connection1);
        stationIndex.addConnection(connection2);
        stationIndex.addConnection(connection3);

    }
    public void testCalculateDuration(){
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 14.5;
        assertEquals(expected, actual);
    }
    public void testGetRouteOnTheLine(){
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Грушевая"),
                stationIndex.getStation("Вишневая"));
        List<Station> expected = route.subList(0, 3);
        assertEquals(expected, actual);
    }
    public void testGetRouteWithOneConnection(){
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Грушевая"),
                stationIndex.getStation("Петровская"));

        List<Station> expected = route;
        assertEquals(expected, actual);
    }

    public void testGetRouteWithTwoConnection(){
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Виноградная"),
                stationIndex.getStation("Морковная"));
        List<Station> expected = route2;
        assertEquals(expected, actual);
    }



    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
