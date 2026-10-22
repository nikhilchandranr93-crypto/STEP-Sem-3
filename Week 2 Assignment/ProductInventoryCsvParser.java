import java.util.Scanner;

public class ProductInventoryCsvParser {

    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",", -1);
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println("Product: " + fields[0].trim()
                + " | SKU: " + fields[1].trim()
                + " | Qty: " + fields[2].trim());
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            parseInventoryRecord(String.join(",", args));
            return;
        }

        String input = readLine();
        if (input != null) {
            parseInventoryRecord(input);
            return;
        }

        System.out.println("--- Sample 1 ---");
        parseInventoryRecord("Wireless Mouse,WM-2201,150");
        System.out.println("--- Sample 2 ---");
        parseInventoryRecord("Wireless Mouse,150");
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
