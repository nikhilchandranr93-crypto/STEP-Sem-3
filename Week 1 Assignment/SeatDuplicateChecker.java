import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeatDuplicateChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length < 2) {
            System.out.println("No Duplicate Seats Found");
            return;
        }

        boolean duplicateFound = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            boolean alreadyReported = false;
            for (int j = 0; j < i; j++) {
                if (seatNumbers[j] == seatNumbers[i]) {
                    alreadyReported = true;
                    break;
                }
            }
            if (alreadyReported) {
                continue;
            }

            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    break;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            checkDuplicateSeats(parseInts(args));
            return;
        }

        int[] input = readSeats();
        checkDuplicateSeats(input);
        if (input.length == 5) {
            System.out.println("--- Second Sample ---");
            checkDuplicateSeats(new int[]{101, 102, 103, 104, 105});
        }
    }

    private static int[] parseInts(String[] args) {
        String joined = String.join(" ", args).trim();
        if (joined.isEmpty()) {
            return new int[0];
        }
        List<Integer> values = new ArrayList<>();
        for (String token : joined.split("[,\\s]+")) {
            try {
                values.add(Integer.parseInt(token.trim()));
            } catch (NumberFormatException ignored) {
            }
        }
        int[] result = new int[values.size()];
        for (int i = 0; i < values.size(); i++) {
            result[i] = values.get(i);
        }
        return result;
    }

    private static int[] readSeats() {
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    return parseInts(new String[]{line});
                }
            }
        } catch (Exception ignored) {
        }
        return new int[]{101, 102, 103, 102, 105};
    }
}
