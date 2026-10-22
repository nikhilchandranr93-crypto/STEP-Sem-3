import java.util.Scanner;

public class IsbnNormalizerValidator {

    public static String normalizeCode(String raw) {
        if (raw == null) {
            return null;
        }

        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed;
        }

        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code == null || code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must be 10 digits";
            }
        }

        String publisherCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder display = new StringBuilder();
        display.append("[").append(publisherCode).append("] YEAR: ")
                .append(year)
                .append(" | CATALOG: ").append(catalog);
        return display.toString();
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println(validateAndFormat(normalizeCode(args[0])));
            return;
        }

        String input = readLine();
        if (input != null) {
            System.out.println(validateAndFormat(normalizeCode(input)));
            return;
        }

        System.out.println(validateAndFormat(normalizeCode("  pen2026004251  ")));
        System.out.println(validateAndFormat(normalizeCode("12N2026004251")));
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
