package bdd.definitions;

import io.cucumber.java.en.Given;

public class JavaStepDefs {
    @Given("I solve coding challenges")
    public void iSolveCodingChallenges() {
        fizzBuzz(20);
    }


// Write a function, accepts integer argument
// It should print all the numbers up to the argument
// BUT:
// if number is multiple of 3, it should print Fizz instead of number
// if number is multiple of 5, it should print Buzz instead of number
// If it is multiple of both 3 and 5, it should print FizzBuzz instead of number
// Result for 20:
// 1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz

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
