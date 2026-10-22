import java.util.Scanner;

public class PhoneNumberMasker {

    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            char current = phone.charAt(i);
            if (current < '0' || current > '9') {
                return "Invalid phone number";
            }
        }

        StringBuilder masked = new StringBuilder("XXXXXX");
        masked.append(phone.substring(6));
        masked.insert(6, '-');
        return masked.toString();
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println(maskPhoneNumber(args[0].trim()));
            return;
        }

        String input = readLine();
        if (input != null) {
            System.out.println(maskPhoneNumber(input));
            return;
        }

        System.out.println(maskPhoneNumber("9876543210"));
        System.out.println(maskPhoneNumber("98765"));
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
