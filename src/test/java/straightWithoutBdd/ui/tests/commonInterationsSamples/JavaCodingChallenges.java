package straightWithoutBdd.ui.tests.commonInterationsSamples;

import org.testng.annotations.Test;

public class JavaCodingChallenges {

    @Test
    public void codingChallengesClass4(){
//        String value=maskify("44590781234");
//        String value=maskify("");
//        String value =maskify("1");
//        System.out.println("The result value is: "+value);
//        int mNum=makeNegative(-5);
//        int mNum=makeNegative(5);
        int mNum=makeNegative(0);
        System.out.println("The negative value is: "+mNum);

    }
    private String maskify(String str){
        String result="";
        if (str.length()<=4){
            return str;
        }
        for (int i=0;i<str.length()-5;i++){
            result+="#";
        }
        return result+str.substring(str.length()-4);
    }

    private int makeNegative(final int x){
        if (x<=0){
            return x;
        }

        return -1*x;
    }
}
