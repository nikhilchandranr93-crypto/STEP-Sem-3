import java.util.Scanner;

public class FileExtensionValidator {

    public static String validateFileExtension(String filename) {
        if (filename == null) {
            return rejectMessage();
        }

        int lastDot = filename.lastIndexOf('.');
        if (lastDot < 0 || lastDot == filename.length() - 1) {
            return rejectMessage();
        }

        String extension = filename.substring(lastDot + 1);
        if (extension.equalsIgnoreCase("pdf")
                || extension.equalsIgnoreCase("docx")
                || extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        }

        return rejectMessage();
    }

    private static String rejectMessage() {
        return "Rejected \u2014 invalid file type";
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println(validateFileExtension(args[0]));
            return;
        }

        String input = readLine();
        if (input != null) {
            System.out.println(validateFileExtension(input));
            return;
        }

        System.out.println(validateFileExtension("Assignment1.PDF"));
        System.out.println(validateFileExtension("notes.txt"));
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
