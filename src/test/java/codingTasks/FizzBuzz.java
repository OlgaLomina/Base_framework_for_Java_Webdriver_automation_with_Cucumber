package codingTasks;

import org.testng.annotations.Test;

public class FizzBuzz {


    @Test
    public void iSolveCodingChallenges() {
        fizzBuzz(20);
    }


    void fizzBuzz(int num) {
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
