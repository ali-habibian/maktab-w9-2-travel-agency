public class Printer {
    public static void printMainMenu() {
        System.out.println("Main Menu - Select an action:");
        System.out.println("1. Help");
        System.out.println("2. Add");
        System.out.println("3. Delete");
        System.out.println("4. Path");
        System.out.println("5. Exit");
    }

    public static void printSelectModel() {
        System.out.println("Select model:\n" +
                "1. City\n" +
                "2. Road");
    }

    public static void printAnotherModel(String model) {
        System.out.println("Select your next action\n" +
                "1. Add another " + model + "\n" +
                "2. Main Menu");
    }

    public static void printErrorMessage(String msg) {
        System.out.println(msg);
    }

    public static void printInfoMessage(String msg) {
        System.out.println(msg);
    }
}
