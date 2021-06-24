package codingTasks;

import org.testng.annotations.Test;
import utils.Loggable;

import java.util.Stack;

public class StackTask implements Loggable {

    @Test
    public void testValid(){
        boolean validOrNot = isValid("([)]");
        getLogger().info("Is it valid? "+validOrNot);
    }

    public boolean isValid(String str){
        Stack<Character> chStack = new Stack<>();
        for (int i=0;i<str.length();i++){
            chStack.push(str.charAt(i));
        }
        for (int i=0;i<chStack.capacity();i++){
            char c = chStack.elementAt(i);
            if (c=='('){
                if (chStack.contains(')')){
                    return true;
                }
            }
            else if (c=='['){
                if (chStack.contains(']')){
                    return true;
                }
            }
            else if (c=='{'){
                if (chStack.contains(']')){
                    return true;
                }
            }
        }

        return false;
    }
}
