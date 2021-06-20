package codingTasks;

public class BooleanToString {
    public static void main(String[] args) {
//        assertEquals(BooleanToString.convert(true), "true");
//        assertEquals(BooleanToString.convert(false), "false");
        System.out.println(BooleanToString.convert(false));
    }
    public static String convert(boolean b){
        if(b) {
            return "true";
        } else {
            return "false";
        }
    }
}
