package codingTasks;

import java.util.Stack;

public class StackTask {
    public static void main(String[] args) {
        System.out.println(isValid("(){}}{"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() == 0 || s.charAt(0) == '}' || s.charAt(0) == ']' || s.charAt(0) == ')') {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                boolean a = false;
                if (!stack.empty()) {
                    if (s.charAt(i) == '}' && stack.peek() == '{') {
                        stack.pop();
                        a = true;
                    }
                    if (s.charAt(i) == ']' && stack.peek() == '[') {
                        stack.pop();
                        a = true;
                    }
                    if (s.charAt(i) == ')' && stack.peek() == '(') {
                        stack.pop();
                        a = true;
                    }
                }
                if (!a) {
                    return false;
                }
            }
        }
        return stack.empty();

    }
}
