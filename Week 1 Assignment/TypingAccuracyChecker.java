import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TypingAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            System.out.println("Both the original and typed text are required.");
            return;
        }

        int total = Math.max(original.length(), typed.length());
        if (total == 0) {
            System.out.println("Matched: 0/0 | Accuracy: 100.00% | No Mismatches");
            return;
        }

        int matched = 0;
        int firstMismatch = -1;

        for (int i = 0; i < total; i++) {
            boolean originalHasChar = i < original.length();
            boolean typedHasChar = i < typed.length();

            if (originalHasChar && typedHasChar && original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy = (matched * 100.0) / total;
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%", matched, total, accuracy);

        if (firstMismatch == -1) {
            System.out.println(" | No Mismatches");
        } else {
            String expected = firstMismatch < original.length()
                    ? String.valueOf(original.charAt(firstMismatch))
                    : "(missing)";
            String actual = firstMismatch < typed.length()
                    ? String.valueOf(typed.charAt(firstMismatch))
                    : "(missing)";
            System.out.printf(" | First Mismatch at position %d ('%s' vs '%s')%n",
                    firstMismatch + 1, expected, actual);
        }
    }

    public static void main(String[] args) {
        if (args.length >= 2) {
            checkTypingAccuracy(args[0], args[1]);
            return;
        }

        List<String> lines = readLines(2);
        if (lines.size() == 2) {
            checkTypingAccuracy(lines.get(0), lines.get(1));
            return;
        }

        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }

    private static List<String> readLines(int maxLines) {
        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            while (lines.size() < maxLines && scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.isEmpty()) {
                    lines.add(line);
                }
            }
        } catch (Exception ignored) {
        }
        return lines;
    }
}
