import java.util.Scanner;

public class CsvStudentRecordParser {

    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",", -1);
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println("Name: " + fields[0].trim()
                + " | Roll No: " + fields[1].trim()
                + " | Dept: " + fields[2].trim());
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            parseStudentRecord(String.join(",", args));
            return;
        }

        String input = readLine();
        if (input != null) {
            parseStudentRecord(input);
            return;
        }

        System.out.println("--- Sample 1 ---");
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
        System.out.println("--- Sample 2 ---");
        parseStudentRecord("Ananya Verma,CSE");
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
