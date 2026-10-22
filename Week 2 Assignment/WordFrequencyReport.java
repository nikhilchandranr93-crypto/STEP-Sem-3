import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class WordFrequencyReport {

    private static final String[] STOP_WORDS = {"the", "was", "and", "a", "is", "of", "in"};

    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            return;
        }

        String cleaned = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "")
                .replace("!", "")
                .replace("?", "")
                .replace(";", "")
                .replace(":", "")
                .replace("\"", "")
                .replace("'", "")
                .replace("(", "")
                .replace(")", "");

        String[] words = cleaned.trim().split("\\s+");
        Set<String> stopWords = new HashSet<>(Arrays.asList(STOP_WORDS));
        Map<String, Integer> frequency = new LinkedHashMap<>();

        for (String word : words) {
            if (word.isEmpty() || stopWords.contains(word)) {
                continue;
            }
            frequency.merge(word, 1, Integer::sum);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequency.entrySet());
        entries.sort((first, second) -> Integer.compare(second.getValue(), first.getValue()));

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            printFilteredWordFrequency(String.join(" ", args));
            return;
        }

        String input = readLine();
        if (input != null) {
            printFilteredWordFrequency(input);
            return;
        }

        printFilteredWordFrequency(
                "The mentor was great, the session was great and clear.");
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
