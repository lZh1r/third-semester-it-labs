public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String input = args[i];
            System.out.println("Input: " + input);
            if (isPalindrome(input)) {
                System.out.println("Palindrome");
            } else {
                System.out.println("Not a palindrome");
            }
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
