import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);
    public static double readNumber(String prompt, double min, double max) {
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println(" Please Enter a value greater " + min + "  and less than " + max);
        }
        return value;
    }
}
