package codingTasks;

public class Isograms {
    public static void main(String[] args) {
 //       assertEquals(true, isogram.isIsogram("Dermatoglyphics"));
  //      assertEquals(true, isogram.isIsogram("isogram"));
//        assertEquals(false, isogram.isIsogram("moose"));
//        assertEquals(false, isogram.isIsogram("isIsogram"));
//        assertEquals(false, isogram.isIsogram("moOse"));
//        assertEquals(true, isogram.isIsogram("thumbscrewjapingly"));
//        assertEquals(true, isogram.isIsogram(""));

        System.out.println(isIsogram("isIsogram"));
    }
    public static boolean isIsogram(String str) {
        // ...
        int len = str.length();
        if (len == 0) return true;
        int [] array = new int [256];
        str = str.toLowerCase();
        for (int i = 0; i < len; i++) {
            int val = str.charAt(i);
            if (array[val] == 1) {
                return false;
            }
            else {
                array[val] = 1;

            }

        }
        return true;
    }

}
