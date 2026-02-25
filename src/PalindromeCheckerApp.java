import java.util.*;

// ===== UC11 SUPPORT: OOP Service =====
class PalindromeChecker {
    public boolean checkPalindrome(String input) {
        if (input == null) return false;
        int left = 0, right = input.length() - 1;
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}

// ===== UC12: Strategy Pattern =====
interface PalindromeStrategy {
    boolean isPalindrome(String text);
}

// Stack-based strategy
class StackStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String text) {
        Stack<Character> stack = new Stack<>();
        for (char c : text.toCharArray()) stack.push(c);

        String reversed = "";
        while (!stack.isEmpty()) reversed += stack.pop();
        return text.equals(reversed);
    }
}

// Deque-based strategy
class DequeStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String text) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : text.toCharArray()) deque.addLast(c);

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}

// Context class
class PalindromeContext {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean execute(String text) {
        return strategy != null && strategy.isPalindrome(text);
    }
}

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
        checkPalindromeUsingRecursion(); // UC9
        checkCaseInsensitivePalindrome(); // UC10
        checkUsingOOPService(); // UC11
        checkUsingStrategyPattern(); // UC12
        comparePerformance(); // UC13
    }

    private static void displayWelcomeMessage() {
        System.out.println("=================================");
        System.out.println(" Welcome to " + APP_NAME);
        System.out.println(" Version: " + VERSION);
        System.out.println("=================================");
    }

    // ===== UC2 =====
    private static void checkHardcodedPalindrome() {
        String text = "madam";
        String reversed = new StringBuilder(text).reverse().toString();
        System.out.println(text + (text.equals(reversed) ? " is" : " is NOT") + " a Palindrome");
    }

    // ===== UC3 =====
    private static void checkPalindromeUsingLoop() {
        String original = "racecar";
        String reversed = "";
        for (int i = original.length() - 1; i >= 0; i--) reversed += original.charAt(i);
        System.out.println(original + (original.equals(reversed) ? " is" : " is NOT") + " a Palindrome (Loop Method)");
    }

    // ===== UC4 =====
    private static void checkPalindromeUsingCharArray() {
        String text = "level";
        char[] chars = text.toCharArray();
        int l = 0, r = chars.length - 1;
        boolean ok = true;
        while (l < r) {
            if (chars[l++] != chars[r--]) { ok = false; break; }
        }
        System.out.println(text + (ok ? " is" : " is NOT") + " a Palindrome (Char Array Method)");
    }

    // ===== UC5 =====
    private static void checkPalindromeUsingStack() {
        String text = "refer";
        Stack<Character> stack = new Stack<>();
        for (char c : text.toCharArray()) stack.push(c);
        String reversed = "";
        while (!stack.isEmpty()) reversed += stack.pop();
        System.out.println(text + (text.equals(reversed) ? " is" : " is NOT") + " a Palindrome (Stack Method)");
    }

    // ===== UC6 =====
    private static void checkPalindromeUsingQueueAndStack() {
        String text = "noon";
        Queue<Character> q = new LinkedList<>();
        Stack<Character> s = new Stack<>();
        for (char c : text.toCharArray()) { q.offer(c); s.push(c); }
        boolean ok = true;
        while (!q.isEmpty()) if (!q.poll().equals(s.pop())) { ok = false; break; }
        System.out.println(text + (ok ? " is" : " is NOT") + " a Palindrome (Queue + Stack Method)");
    }

    // ===== UC7 =====
    private static void checkPalindromeUsingDeque() {
        String text = "radar";
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : text.toCharArray()) dq.addLast(c);
        boolean ok = true;
        while (dq.size() > 1) if (!dq.removeFirst().equals(dq.removeLast())) { ok = false; break; }
        System.out.println(text + (ok ? " is" : " is NOT") + " a Palindrome (Deque Method)");
    }

    // ===== UC8 =====
    static class Node { char data; Node next; Node(char d){data=d;} }

    private static void checkPalindromeUsingLinkedList() {
        String text = "civic";
        Node head=null, tail=null;
        for(char c:text.toCharArray()){ Node n=new Node(c); if(head==null){head=tail=n;} else{tail.next=n; tail=n;} }
        Node slow=head, fast=head;
        while(fast!=null && fast.next!=null){ slow=slow.next; fast=fast.next.next; }
        Node prev=null, curr=slow;
        while(curr!=null){ Node nxt=curr.next; curr.next=prev; prev=curr; curr=nxt; }
        Node p1=head, p2=prev; boolean ok=true;
        while(p2!=null){ if(p1.data!=p2.data){ ok=false; break;} p1=p1.next; p2=p2.next; }
        System.out.println(text + (ok?" is":" is NOT") + " a Palindrome (Linked List Method)");
    }

    // ===== UC9 =====
    private static void checkPalindromeUsingRecursion() {
        String text = "madam";
        boolean res = isPalindromeRecursive(text,0,text.length()-1);
        System.out.println(text + (res?" is":" is NOT") + " a Palindrome (Recursion Method)");
    }
    private static boolean isPalindromeRecursive(String s,int l,int r){
        if(l>=r) return true;
        if(s.charAt(l)!=s.charAt(r)) return false;
        return isPalindromeRecursive(s,l+1,r-1);
    }

    // ===== UC10 =====
    private static void checkCaseInsensitivePalindrome() {
        String input="A man a plan a canal Panama";
        String norm=input.replaceAll("\\s+","").toLowerCase();
        int l=0,r=norm.length()-1; boolean ok=true;
        while(l<r){ if(norm.charAt(l++)!=norm.charAt(r--)){ ok=false; break;} }
        System.out.println(input + (ok?" is":" is NOT") + " a Palindrome (Case-Insensitive Method)");
    }

    // ===== UC11 =====
    private static void checkUsingOOPService() {
        PalindromeChecker svc=new PalindromeChecker();
        String text="rotor";
        boolean res=svc.checkPalindrome(text);
        System.out.println(text + (res?" is":" is NOT") + " a Palindrome (OOP Service)");
    }

    // ===== UC12 =====
    private static void checkUsingStrategyPattern() {
        String text="level";

        PalindromeContext context=new PalindromeContext();

        // choose stack strategy
        context.setStrategy(new StackStrategy());
        boolean stackResult=context.execute(text);
        System.out.println(text + (stackResult?" is":" is NOT") + " a Palindrome (Strategy-Stack)");

        // switch to deque strategy
        context.setStrategy(new DequeStrategy());
        boolean dequeResult=context.execute(text);
        System.out.println(text + (dequeResult?" is":" is NOT") + " a Palindrome (Strategy-Deque)");
    }
    // ===== UC13: Performance Comparison =====
    private static void comparePerformance() {
        String test = "Able was I ere I saw Elba".replaceAll("\\s+", "").toLowerCase();

        // loop method timing
        long startLoop = System.nanoTime();
        isPalindromeRecursive(test, 0, test.length() - 1);
        long endLoop = System.nanoTime();

        // stack method timing
        long startStack = System.nanoTime();
        Stack<Character> stack = new Stack<>();
        for (char c : test.toCharArray()) stack.push(c);
        while (!stack.isEmpty()) stack.pop();
        long endStack = System.nanoTime();

        // deque method timing
        long startDeque = System.nanoTime();
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : test.toCharArray()) dq.addLast(c);
        while (dq.size() > 1) {
            dq.removeFirst();
            dq.removeLast();
        }
        long endDeque = System.nanoTime();

        System.out.println("Performance Comparison (nanoseconds):");
        System.out.println("Recursion Method: " + (endLoop - startLoop));
        System.out.println("Stack Method: " + (endStack - startStack));
        System.out.println("Deque Method: " + (endDeque - startDeque));
    }
}
