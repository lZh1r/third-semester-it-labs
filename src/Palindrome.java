import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (isPalindrome(input)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
    }
    static boolean isPalindrome(String input) {
        return input.equals(reverseString(input));
    }
    static String reverseString(String input) {
        String result = "";
        for (char c : input.toCharArray()) {
            result = c + result;
        }
        return result;
    }
}
