import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WarehouseInventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null) {
            System.out.println("Both sections are required for analysis.");
            return;
        }

        long totalA = 0;
        long totalB = 0;
        for (int quantity : sectionA) {
            totalA += quantity;
        }
        for (int quantity : sectionB) {
            totalB += quantity;
        }

        String status = totalA == totalB ? "Balanced" : "Not Balanced";
        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s",
                totalA, totalB, status);

        int highest = Integer.MIN_VALUE;
        String highestSection = "";
        int highestIndex = -1;
        boolean found = false;

        for (int i = 0; i < sectionA.length; i++) {
            if (!found || sectionA[i] > highest) {
                highest = sectionA[i];
                highestSection = "Section A";
                highestIndex = i;
                found = true;
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            if (!found || sectionB[i] > highest) {
                highest = sectionB[i];
                highestSection = "Section B";
                highestIndex = i;
                found = true;
            }
        }

        if (found) {
            System.out.printf(" | Highest Quantity: %d (%s, Item %d)%n",
                    highest, highestSection, highestIndex + 1);
        } else {
            System.out.println(" | No Items Available");
        }
    }

    public static void main(String[] args) {
        if (args.length >= 2) {
            analyzeInventory(parseInts(args[0]), parseInts(args[1]));
            return;
        }

        int[][] input = readSections();
        if (input != null) {
            analyzeInventory(input[0], input[1]);
            return;
        }

        analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30});
    }

    private static int[] parseInts(String text) {
        List<Integer> values = new ArrayList<>();
        if (text != null) {
            for (String token : text.trim().split("[,\\s]+")) {
                try {
                    values.add(Integer.parseInt(token.trim()));
                } catch (NumberFormatException ignored) {
                }
            }
        }
        int[] result = new int[values.size()];
        for (int i = 0; i < values.size(); i++) {
            result[i] = values.get(i);
        }
        return result;
    }

    private static int[][] readSections() {
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextLine()) {
                String lineA = scanner.nextLine().trim();
                if (!lineA.isEmpty() && scanner.hasNextLine()) {
                    String lineB = scanner.nextLine().trim();
                    if (!lineB.isEmpty()) {
                        return new int[][]{parseInts(lineA), parseInts(lineB)};
                    }
                }
            }
        } catch (Exception ignored) {
        }
        return null;
    }
}
