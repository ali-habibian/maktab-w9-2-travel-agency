import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Manager {
    private Map<Integer, City> cities = new HashMap<>();
    private Map<Integer, Road> roads = new HashMap<>();

    public void help() {
        System.out.println("Select a number from shown menu and enter. For example 1 is for help.");
    }

    public void addCity(City city) {
        cities.put(city.getId(), city);
    }

    public City removeCityById(int id) {
        return cities.remove(id);
    }

    public City getCityById(int id) {
        return cities.get(id);
    }

    public void addRoad(Road road) {
        roads.put(road.getId(), road);
    }

    public Road removeRoadById(int id) {
        return roads.remove(id);
    }

    public Map<Integer, City> getCities() {
        return cities;
    }

    public Map<Integer, Road> getRoads() {
        return roads;
    }

    // Must add check for source and destination of road
    public Road getPath(City sourceCity, City destinationCity) {
        for (var entry : roads.entrySet()) {
            if (entry.getValue().getCities().contains(sourceCity) &&
                    entry.getValue().getCities().contains(destinationCity))
                return entry.getValue();
        }
        return null;
    }

}
