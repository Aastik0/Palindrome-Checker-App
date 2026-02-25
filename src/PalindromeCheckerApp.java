public class PalindromeCheckerApp {

    private static final String APP_NAME = "Palindrome Checker App";
    private static final String VERSION = "v1.0";

    public static void main(String[] args) {
        displayWelcomeMessage();
        checkHardcodedPalindrome(); // UC2
    }

    private static void displayWelcomeMessage() {
        System.out.println("=================================");
        System.out.println(" Welcome to " + APP_NAME);
        System.out.println(" Version: " + VERSION);
        System.out.println("=================================");
    }

    // UC2 Method
    private static void checkHardcodedPalindrome() {
        String text = "madam"; // hardcoded string
        String reversed = new StringBuilder(text).reverse().toString();

        if (text.equals(reversed)) {
            System.out.println(text + " is a Palindrome");
        } else {
            System.out.println(text + " is NOT a Palindrome");
        }
    }
}