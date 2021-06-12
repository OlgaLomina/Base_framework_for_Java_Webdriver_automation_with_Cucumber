package javaRefresh;

import java.util.Arrays;

public class Strings {

    public static void main(String[] args) {
        String s = "sample text";
        s.length();
        s.toLowerCase();
        s.toUpperCase();
        String[] arr = s.split(" ");
        System.out.println(Arrays.toString(arr));

        // when you loop through elements
        for (int i =0; i< s.length(); i++){
            System.out.println();
        }



        //

    }

}
