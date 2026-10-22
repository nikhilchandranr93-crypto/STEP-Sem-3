import java.util.Scanner;

public class AtmPinValidator {

    public static void checkPinLength(String pin) {
        if (pin == null || pin.length() != 4) {
            System.out.println("Invalid PIN \u2014 must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            checkPinLength(args[0]);
            return;
        }

        String input = readLine();
        if (input != null) {
            checkPinLength(input);
            return;
        }

        checkPinLength("482");
        checkPinLength("4820");
    }

    private static String readLine() {
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    return line;
                }
            }
        } catch (Exception ignored) {
        }
        return null;
    }
}
