import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    private static final String APP_NAME = "Palindrome Checker App";
    private static final String VERSION = "v1.0";

    public static void main(String[] args) {
        displayWelcomeMessage();
        checkHardcodedPalindrome(); // UC2
        checkPalindromeUsingLoop(); // UC3
        checkPalindromeUsingCharArray(); // UC4
        checkPalindromeUsingStack(); // UC5
        checkPalindromeUsingQueueAndStack(); // UC6
        checkPalindromeUsingDeque(); // UC7
        checkPalindromeUsingLinkedList(); // UC8
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

        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
        }

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

    // UC6 Method: Queue + Stack comparison
    private static void checkPalindromeUsingQueueAndStack() {
        String text = "noon";
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            queue.offer(ch);
            stack.push(ch);
        }

        boolean isPalindrome = true;

        while (!queue.isEmpty()) {
            char fromQueue = queue.poll();
            char fromStack = stack.pop();

            if (fromQueue != fromStack) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(text + " is a Palindrome (Queue + Stack Method)");
        } else {
            System.out.println(text + " is NOT a Palindrome (Queue + Stack Method)");
        }
    }

    // UC7 Method: Deque optimized palindrome
    private static void checkPalindromeUsingDeque() {
        String text = "radar";
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < text.length(); i++) {
            deque.addLast(text.charAt(i));
        }

        boolean isPalindrome = true;

        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(text + " is a Palindrome (Deque Method)");
        } else {
            System.out.println(text + " is NOT a Palindrome (Deque Method)");
        }
    }

    // ===== UC8: Linked List Based Palindrome =====

    // Node class for singly linked list
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    private static void checkPalindromeUsingLinkedList() {
        String text = "civic";

        // convert string to linked list
        Node head = null, tail = null;
        for (char c : text.toCharArray()) {
            Node newNode = new Node(c);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // find middle using fast & slow pointers
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        Node prev = null, curr = slow;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // compare halves
        Node firstHalf = head;
        Node secondHalf = prev;
        boolean isPalindrome = true;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        if (isPalindrome) {
            System.out.println(text + " is a Palindrome (Linked List Method)");
        } else {
            System.out.println(text + " is NOT a Palindrome (Linked List Method)");
        }
    }
}
