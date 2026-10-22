import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatingChar {

    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }
        Map<Character, Integer> frequency = new LinkedHashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            frequency.merge(current, 1, Integer::sum);
        }
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            if (frequency.get(current) == 1) {
                return current;
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        String[] inputs = args.length > 0 ? args : readInputs();
        for (String text : inputs) {
            char result = findFirstNonRepeatingChar(text);
            if (result == '\0') {
                System.out.println("Input: \"" + text + "\" -> No Non-Repeating Character Found");
            } else {
                System.out.println("Input: \"" + text + "\" -> First Non-Repeating Character: '" + result + "'");
            }
        }
    }

    private static String[] readInputs() {
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    return new String[]{line};
                }
            }
        } catch (Exception ignored) {
        }
        return new String[]{"swiss", "aabbcc", "programming"};
    }
}
