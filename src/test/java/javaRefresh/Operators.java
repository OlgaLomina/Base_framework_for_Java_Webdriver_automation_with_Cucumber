package javaRefresh;

public class Operators {


    public static void main(String[] args) {
        // + - * straightforward


        // += Assign Resulted value. Trick to change string which is immutable without StringBuilder, StringBuffer.
        int intVal = 10;
        int intVal2 =20;
        String name = "John";
        String lastName = "Smith";
        String result = name += lastName;
        System.out.println(intVal += intVal2);
        System.out.println(result);

        // Operator || OR
        if (false || false){
            System.out.println("Should Not Print");
        }

        if (false || true){
            System.out.println("Print");
        }

        // And &&
        if (true && false){
            System.out.println("AND Should not print");
        }

        if (true && true){
            System.out.println("Should not print");
        }

        // % Returns the division remainder  Used for even\odd numbers coding challanges.
        System.out.println("Division by module. Should be 0: " +  10 % 2);
        System.out.println("Division by module. Should be 1: " +  10 % 3);

        // Pre-Decrement -- Used in loops a lot when need to go in reverse side. From last to first.
        int val = 10;
        System.out.println(--val);

        // Post-Decrement -- Used in loops a lot when need to go in reverse side. From last to first.
        int postDecrement = 10;
        System.out.println("Post-decrement" + postDecrement--);
        System.out.println(postDecrement);

        // Same with Post\PreIncrement

        // Pre-Increment -- Used in loops a lot when need to go in direct.
        int pre_incr = 10;
        System.out.println(++pre_incr);

        // Post-Decrement -- Used in loops a lot when need to go in reverse side. From last to first.
        int postIncrement = 20;
        System.out.println("Post-decrement" + postIncrement++);
        System.out.println(postIncrement);
    }


}
