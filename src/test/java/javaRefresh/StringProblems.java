package javaRefresh;

public class StringProblems {

    public static void main (String[] args) {
        //String (charAt, toCharArray, length
        // Basic datastructures: Array (fixed size), HasMap (key value), ArrayList (flexible list)
        //Additional UI Interactions:  Dropdown, Radio button, Checkboxes,
        //Dataprovider in BDD and non bdd tests
        String ss = "############5862";
        System.out.println(maskify(ss));
    }

    public static String maskify(String str) {
        //throw new UnsupportedOperationException("Unimplemented");
        int len = str.length();
        if (len <= 4) {
            return str;
        } else {
            String s = "#";
            int a = (len - 4);
            System.out.println(a);

            String b = str.substring((len - 4), len);
            System.out.println(b);
            return  s.repeat(len - 4) + str.substring((len - 4), len);
        }


    }

}
