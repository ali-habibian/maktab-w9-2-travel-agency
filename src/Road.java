import java.util.ArrayList;

public class Road {
    private int id;
    private String name;
    private int from;
    private int to;
    private ArrayList<City> cities;
    private int speed_limit;
    private int length;
    private int bi_directional;

    public Road(int id, String name, int from, int to, ArrayList<City> cities, int speed_limit, int length, int bi_directional) {
        this.id = id;
        this.name = name;
        this.from = from;
        this.to = to;
        this.cities = cities;
        this.speed_limit = speed_limit;
        this.length = length;
        this.bi_directional = bi_directional;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    public int getSpeed_limit() {
        return speed_limit;
    }

    public void setSpeed_limit(int speed_limit) {
        this.speed_limit = speed_limit;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBi_directional() {
        return bi_directional;
    }

    public void setBi_directional(int bi_directional) {
        this.bi_directional = bi_directional;
    }

    private String getTimeFormat() {
        double time = length * 1.0 / speed_limit;

        double day = time % 24;

        time = time - time % 24;
        double hour = time % 60;

        time = time - time % 60;
        double minute = (time % 60);

        return day + ":" + hour + ":" + minute;
    }

    @Override
    public String toString() {
        return cities.get(0).getName() + ":" + cities.get(1).getName() + " via Road "
                + this.getName() + ":" + getTimeFormat();
    }
}
