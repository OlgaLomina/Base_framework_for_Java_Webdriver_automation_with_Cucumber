package codingTasks;

public class ReverseWordsInString {
    public static void main(String[] args) {
//        Input: s = "the sky is blue" Output: "blue is sky the"
//        Input: s = "  hello world  " Output: "world hello"
//        Input: s = "a good   example"    Output: "example good a"
//        Input: s = "  Bob    Loves  Alice   "   Output: "Alice Loves Bob"
//        Input: s = "Alice does not even like bob" Output: "bob like even not does Alice"

        System.out.println(reverseWords("a good   example"));
    }


    public static String reverseWords (String str) {
        str = str.trim();
        String [] arrWords = str.split(" ");
        StringBuilder returnStr = new StringBuilder("");
        String prefix = "";
        for (int i = arrWords.length-1; i >= 0; i--) {
            if(arrWords[i].length() != 0) {
                returnStr.append(prefix);
                returnStr.append(arrWords[i]);
                prefix = " ";
            }
        }
        return returnStr.toString();
    }
}
