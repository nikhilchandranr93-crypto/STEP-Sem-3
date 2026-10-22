import java.util.Scanner;

public class BankReferenceValidator {

    public static String normalizeReference(String raw) {
        if (raw == null) {
            return null;
        }

        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed;
        }

        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference == null || reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must be 11 digits";
            }
        }

        String bankCode = reference.substring(0, 3);
        String date = reference.substring(3, 9);
        String sequence = reference.substring(9, 14);

        StringBuilder display = new StringBuilder();
        display.append("[").append(bankCode).append("] DATE: ")
                .append(date.substring(0, 2)).append("/")
                .append(date.substring(2, 4)).append("/")
                .append(date.substring(4, 6))
                .append(" | SEQ: ").append(sequence);
        return display.toString();
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println(validateAndFormat(normalizeReference(args[0])));
            return;
        }

        String input = readLine();
        if (input != null) {
            System.out.println(validateAndFormat(normalizeReference(input)));
            return;
        }

        System.out.println(validateAndFormat(normalizeReference("  hdf03022600042  ")));
        System.out.println(validateAndFormat(normalizeReference("12F03022600042")));
    }

    private static String readLine() {
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.trim().isEmpty()) {
                    return line;
                }
            }
        } catch (Exception ignored) {
        }
        return null;
    }
}
