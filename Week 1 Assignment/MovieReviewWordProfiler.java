import java.util.Scanner;

public class MovieReviewWordProfiler {

    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        String[] words = review.trim().split("\\s+");
        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;

        for (String word : words) {
            int letters = 0;
            for (int i = 0; i < word.length(); i++) {
                if (Character.isLetter(word.charAt(i))) {
                    letters++;
                }
            }
            if (letters == 0) {
                continue;
            }
            if (letters <= 4) {
                shortWords++;
            } else if (letters <= 8) {
                mediumWords++;
            } else {
                longWords++;
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d%n",
                shortWords, mediumWords, longWords);
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            classifyWordLengths(String.join(" ", args));
            return;
        }

        String input = readReview();
        if (input != null) {
            classifyWordLengths(input);
            return;
        }

        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }

    private static String readReview() {
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
