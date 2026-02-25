import java.util.Stack;

public class PalindromeCheckerApp {

    private static final String APP_NAME = "Palindrome Checker App";
    private static final String VERSION = "v1.0";

    public static void main(String[] args) {
        displayWelcomeMessage();
        checkHardcodedPalindrome(); // UC2
        checkPalindromeUsingLoop(); // UC3
        checkPalindromeUsingCharArray(); // UC4
        checkPalindromeUsingStack(); // UC5
    }

    private static void displayWelcomeMessage() {
        System.out.println("=================================");
        System.out.println(" Welcome to " + APP_NAME);
        System.out.println(" Version: " + VERSION);
        System.out.println("=================================");
    }

    // UC2 Method
    private static void checkHardcodedPalindrome() {
        String text = "madam";
        String reversed = new StringBuilder(text).reverse().toString();

        if (text.equals(reversed)) {
            System.out.println(text + " is a Palindrome");
        } else {
            System.out.println(text + " is NOT a Palindrome");
        }
    }

    // UC3 Method: Reverse using loop
    private static void checkPalindromeUsingLoop() {
        String original = "racecar";
        String reversed = "";

        for (int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }

        if (original.equals(reversed)) {
            System.out.println(original + " is a Palindrome (Loop Method)");
        } else {
            System.out.println(original + " is NOT a Palindrome (Loop Method)");
        }
    }

    // UC4 Method: Character array + two pointer
    private static void checkPalindromeUsingCharArray() {
        String text = "level";
        char[] chars = text.toCharArray();

        int left = 0;
        int right = chars.length - 1;
        boolean isPalindrome = true;

        while (left < right) {
            if (chars[left] != chars[right]) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        if (isPalindrome) {
            System.out.println(text + " is a Palindrome (Char Array Method)");
        } else {
            System.out.println(text + " is NOT a Palindrome (Char Array Method)");
        }
    }

    // UC5 Method: Stack based palindrome
    private static void checkPalindromeUsingStack() {
        String text = "refer";
        Stack<Character> stack = new Stack<>();

        // push all characters
        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
        }

        // pop to build reversed string
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed = reversed + stack.pop();
        }

        if (text.equals(reversed)) {
            System.out.println(text + " is a Palindrome (Stack Method)");
        } else {
            System.out.println(text + " is NOT a Palindrome (Stack Method)");
        }
    }
}
