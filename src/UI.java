import java.util.ArrayList;

public class UI {
    private boolean isRunning;
    private Manager manager;

    public UI() {
        this.manager = new Manager();
        this.isRunning = false;
    }

    public void run() {

        isRunning = true;
        while (isRunning) {
            Printer.printMainMenu();
            switch (Input.getIntInputValue("")) {
                case 1:
                    manager.help();
                    break;
                case 2: {
                    Printer.printSelectModel();
                    int selectedModel = Input.getIntInputValue("");
                    if (selectedModel == 1) {
                        while (true) {
                            int id = Input.getIntInputValue("id=");
                            String name = Input.getStringInputValue("name=");
                            City city = new City(id, name);
                            manager.addCity(city);
                            Printer.printInfoMessage("city with id=" + id + " added!");
                            Printer.printAnotherModel("City");
                            if (Input.getIntInputValue("") != 1)
                                break;
                        }
                    } else {
                        while (true) {
                            int id = Input.getIntInputValue("id=");
                            String name = Input.getStringInputValue("name=");
                            int from = Input.getIntInputValue("from=");
                            int to = Input.getIntInputValue("to=");
                            String through = Input.getStringInputValue("through=");

                            ArrayList<City> throughCities = new ArrayList<>();
                            for (String str : through.split(","))
                                throughCities.add(manager.getCityById(Integer.parseInt(str)));

                            int speed_limit = Input.getIntInputValue("speed_limit=");
                            int length = Input.getIntInputValue("length=");
                            int bi_directional = Input.getIntInputValue("bi_directional=");
                            Road road = new Road(id, name, from, to, throughCities, speed_limit, length, bi_directional);
                            manager.addRoad(road);
                            Printer.printInfoMessage("road with id=" + id + " added!");
                            Printer.printAnotherModel("Road");
                            if (Input.getIntInputValue("") != 1)
                                break;
                        }
                    }
                    break;
                }
                case 3:
                    Printer.printSelectModel();
                    if (Input.getIntInputValue("") == 1) {
                        int id = Input.getIntInputValue("id=");
                        if (manager.removeCityById(id) != null)
                            Printer.printInfoMessage("City:" + id + " deleted!");
                        else
                            Printer.printErrorMessage("City with id:" + id + " not found!");
                    } else {
                        int id = Input.getIntInputValue("id=");
                        if (manager.removeRoadById(id) != null)
                            Printer.printInfoMessage("Road:" + id + " deleted!");
                        else
                            Printer.printErrorMessage("Road with id:" + id + " not found!");
                    }
                    break;
                case 4:
                    String path = Input.getStringInputValue("<SourceCityId>:<DestinationCityId>=");
                    City sourceCity = manager.getCityById(Integer.parseInt(path.split(":")[0]));
                    City destinationCity = manager.getCityById(Integer.parseInt(path.split(":")[1]));
                    Road road = manager.getPath(sourceCity, destinationCity);
                    if (road != null)
                        Printer.printInfoMessage(road.toString());
                    break;

                case 5:
                    isRunning = false;
                    break;
                default:
                    Printer.printErrorMessage("Invalid input. Please enter 1 for more info.");
            }
        }

    }
}
