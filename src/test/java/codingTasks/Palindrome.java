package codingTasks;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }

    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int len = s.length();
        if (len <= 0) {
            return false;
        }
        for (int i = 0; i < len/2; i++) {
            if (s.charAt(i) != s.charAt(len-1 - i)) {
                return false;
            }
        }
        return true;
    }
}
