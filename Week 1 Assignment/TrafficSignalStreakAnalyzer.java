import java.util.Scanner;

public class TrafficSignalStreakAnalyzer {

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No signal data available.");
            return;
        }

        char bestColor = signalLog.charAt(0);
        int bestLength = 1;
        char currentColor = signalLog.charAt(0);
        int currentLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char current = signalLog.charAt(i);
            if (current == currentColor) {
                currentLength++;
            } else {
                currentColor = current;
                currentLength = 1;
            }

            if (currentLength > bestLength) {
                bestLength = currentLength;
                bestColor = currentColor;
            }
        }

        System.out.println("Longest Streak: '" + bestColor + "' repeated " + bestLength + " times");
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            findLongestStreak(args[0].trim());
            return;
        }

        String input = readLog();
        if (input != null) {
            findLongestStreak(input);
            return;
        }

        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }

    private static String readLog() {
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
