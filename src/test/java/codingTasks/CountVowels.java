package codingTasks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountVowels {
    public static void main(String[] args) {
//        Test.assert_equals(count_vowels("abcdefg"),2)
//        Test.assert_equals(count_vowels("asdfdsafdsafds"), 3)
//        Test.assert_equals(count_vowels(""), 0)
        System.out.println(countVowels("asdfdsAfdsaEefds"));
    }

    public static String countVowels (String str) {
        int len = str.length();
        if (len == 0) return "0";

        String regex = "[0-9]+";
        Pattern p = Pattern.compile(regex); // Compile the ReGex
        // Find match between given string and regular expression using Pattern.matcher()
        Matcher m = p.matcher(str);
        if (m.matches()) return "nil";

        int counter = 0;
        for (int i = 0; i < len; i++){
            if (isVowel(str.charAt(i)))
                counter ++;
        }
        return Integer.toString(counter);
    }

    public static boolean isVowel(Character chr){
        if ("aeiouAEIOU".indexOf(chr) != -1)
            return true;
        return false;
    }
}
