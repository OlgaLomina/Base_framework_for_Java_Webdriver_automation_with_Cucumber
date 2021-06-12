package codingTasks;

public class CreditCardMask {
    public static void main(String[] args) {
        creditCardMask("4556364607935616");
        System.out.println(isogram("Dermatoglyphics"));
        System.out.println(isogram("aba"));
        System.out.println(isogram("abk"));
        System.out.println(isogram(""));
        highAndLow("1 2 3 4 5");
        System.out.println(isItEven(5));
        System.out.println(isItEven(6));
        System.out.println(convertBooleanToString(true));
        System.out.println(convertBooleanToString(false));

    }
    static void creditCardMask(String str){
        for (int i=0; i<str.length(); i++){
            if(i>=0 && i<str.length()-4){
                System.out.print("#");
            }else {
                System.out.print(str.charAt(i));
            }
        }
    }

    static boolean isogram(String str) {
        if (str.length() != 0) {

            for (int i = 0; i < str.length() ; i++) {
                for (int j = i+1; j < str.length(); j++) {
                    if (str.charAt(i)== str.charAt(j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static void highAndLow (String str){
        String [] a=str.split(" ");
        int [] num=new int [a.length];

        for( int i=0; i<a.length; i++){
            num[i]=Integer.parseInt(a[i]);
        }
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for( int i=0; i<num.length; i++){
            if(num[i]<min){
                min=num[i];
            } //must be easy solution, but my mind doesn't work
        }
        for( int i=0; i<num.length; i++){
            if(num[i]>max){
                max=num[i];
            }
        }
        System.out.println(max+" "+min);
    }
    static boolean isItEven (int num){
        if (num%2==0){
            return true;
        }
        return false;
    }
    static String convertBooleanToString (boolean a){
         String b=Boolean.toString(a);
         return b;
    }

    static void printArrInt(int [] arr){
        for (int i : arr){
            System.out.print(i+ ", ");
        }
    }
    static void printArrString(String [] arr){
        for (String i : arr){
            System.out.print(i+ ", ");
        }
    }
}
