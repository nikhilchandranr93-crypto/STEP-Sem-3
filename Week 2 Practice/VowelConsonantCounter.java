import java.util.Scanner;

public class VowelConsonantCounter {

    public static void countVowelsAndConsonants(String text) {
        if (text == null) {
            System.out.println("Vowels: 0 | Consonants: 0");
            return;
        }

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char current = Character.toLowerCase(text.charAt(i));
            if (current == 'a' || current == 'e' || current == 'i'
                    || current == 'o' || current == 'u') {
                vowels++;
            } else if (current >= 'a' && current <= 'z') {
                consonants++;
            }
        }

        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            countVowelsAndConsonants(String.join(" ", args));
            return;
        }

        String input = readText();
        countVowelsAndConsonants(input != null ? input : "Java Programming");
    }

    private static String readText() {
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
