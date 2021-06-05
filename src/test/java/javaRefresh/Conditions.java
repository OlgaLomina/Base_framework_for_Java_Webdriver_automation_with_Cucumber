package javaRefresh;

public class Conditions {

    public static void main(String[] args) {
        // ordinary
        if (20 > 18) {
            System.out.println("20 is greater than 18");
        }

        // if else - simple
        int timeInEST = 20;
        if (timeInEST < 18) {
            System.out.println("Good day.");
        } else {
            System.out.println("Good evening.");
        }
        // Outputs "Good evening."

        // if else - up to 3. If more, use switch
        int time = 22;
        if (time < 10) {
            System.out.println("Good morning.");
        } else if (time < 20) {
            System.out.println("Good day.");
        } else {
            System.out.println("Good evening.");
        }
        // Outputs "Good evening."


        // Ternary operator
        int exp1 = 0, exp2 = 0;
        int result = 12 > 10 ? ++exp1 : ++exp2;
        System.out.println("Ternary result " + result);

        // Switch
        int day = 4;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
        }
    }



}
