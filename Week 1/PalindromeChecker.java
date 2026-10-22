import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isPalindromeIterative(String text) {
        if (text == null) {
            return false;
        }
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text == null) {
            return false;
        }
        return isPalindromeRecursive(text, 0, text.length() - 1);
    }

    private static boolean isPalindromeRecursive(String text, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }
        return isPalindromeRecursive(text, left + 1, right - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) {
            return false;
        }
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] inputs = args.length > 0 ? args : readInputs();
        for (String text : inputs) {
            boolean iterative = isPalindromeIterative(text);
            boolean recursive = isPalindromeRecursive(text);
            boolean arrayReversal = isPalindromeArrayReversal(text);

            System.out.println("Input: \"" + text + "\"");
            System.out.printf("Iterative: %s | Recursive: %s | Array Reversal: %s%n",
                    label(iterative), label(recursive), label(arrayReversal));
            System.out.println("All three approaches agree: "
                    + (iterative == recursive && recursive == arrayReversal));
            System.out.println();
        }
    }

    private static String label(boolean palindrome) {
        return palindrome ? "Palindrome" : "Not Palindrome";
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
        return new String[]{"madam", "hello", "racecar"};
    }
}
