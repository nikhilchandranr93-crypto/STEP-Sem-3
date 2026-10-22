import java.util.Scanner;

public class ReverseCustomerName {

    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }
        char[] characters = customerName.toCharArray();
        int left = 0;
        int right = characters.length - 1;
        while (left < right) {
            char temporary = characters[left];
            characters[left] = characters[right];
            characters[right] = temporary;
            left++;
            right--;
        }
        return new String(characters);
    }

    public static void main(String[] args) {
        String[] names = args.length > 0 ? args : readNames();
        for (String name : names) {
            String original = name;
            String reversed = reverseCustomerName(original);
            System.out.println("Original Name: " + original);
            System.out.println("Reversed Name: " + reversed);
            System.out.println();
        }
    }

    private static String[] readNames() {
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    return new String[]{line};
                }
            }
        } catch (Exception ignored) {
        }
        return new String[]{"Sunil"};
    }
}
