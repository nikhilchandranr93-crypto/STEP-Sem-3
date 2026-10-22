import java.util.Scanner;

public class WordReversalEncoder {

    public static String reverseEachWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder reversedWord = new StringBuilder();
            for (int j = words[i].length() - 1; j >= 0; j--) {
                reversedWord.append(words[i].charAt(j));
            }
            if (i > 0) {
                result.append(' ');
            }
            result.append(reversedWord);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println(reverseEachWord(String.join(" ", args)));
            return;
        }

        String input = readLine();
        if (input != null) {
            System.out.println(reverseEachWord(input));
            return;
        }

        System.out.println(reverseEachWord("hello club"));
        System.out.println(reverseEachWord("Java Programming"));
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
