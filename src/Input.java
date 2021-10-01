import java.util.Scanner;

public class Input {
    private static Scanner input = new Scanner(System.in);

    public static String getStringInputValue(String msg) {
        System.out.print(msg + " ");
        return input.nextLine().trim();
    }

    public static int getIntInputValue(String msg) {
        try {
            return Integer.parseInt(getStringInputValue(msg));
        } catch (Exception e) {
            return 0;
        }
    }
}
