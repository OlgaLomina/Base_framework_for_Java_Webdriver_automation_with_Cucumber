package codingTasks;

import io.cucumber.java.lu.a;

import java.util.Arrays;

public class FizzBuzz {


    public static void main(String[] args) {
        //fizzBuzz(20);
        int[] a = new int[]{-3,0,3,90};
        int b = 0;
        System.out.println(Arrays.toString(new FinSum().twoSum(a, b)));
    }


    static void fizzBuzz(int num) {
        System.out.println("FizzBuzz for " + num);
        for (int i = 1; i <= num; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("FizzBuzz ");
            } else if (i % 3 == 0) {
                System.out.print("Fizz ");
            } else if (i % 5 == 0) {
                System.out.print("Buzz ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();

    }



}
