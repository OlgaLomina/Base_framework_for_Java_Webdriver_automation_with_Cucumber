package codingTasks;

import org.mozilla.javascript.StackStyle;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
//        Input: s = "()" Output: true
//        Input: s = "()[]{}" Output: true
//        Input: s = "(]" Output: false
//        Input: s = "([)]" Output: false
//        Input: s = "{[]}" Output: true
        System.out.println(isValid("([)]"));
    }

    public static boolean isValid(String str){
        Stack<Character> valueStack = new Stack<Character>();
        Character ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);

            if ("([{".indexOf(ch) != -1) {
                valueStack.push(ch);
            }
            else
            {
                switch (ch){
                    case ')':
                        if (valueStack.pop() != '(') return false;
                        break;
                    case ']':
                        if (valueStack.pop() != '[') return false;
                        break;
                    case '}':
                        if (valueStack.pop() != '{') return false;
                        break;
                    default:
                        return false;
                }
            }

        }

        return true;
    }
}
