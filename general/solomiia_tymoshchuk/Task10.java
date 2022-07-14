package general.solomiia_tymoshchuk;

import java.util.Random;
import java.util.Scanner;

/**
 * Write a program that simulates the guess a number game.
 * The program should generate a random number between 1 and N (N should be read from the input)
 * and the user needs to guess it. If the user enters a number less than guessed, the program needs to output “Larger”.
 * If the user enters a number greater than guessed - the program should output “Smaller”.
 * If the user guesses the number correctly - the program should output “That’s it!” and finish.
 **/
public class Task10 {

    public String printSentence(String sentence) {
        System.out.println(sentence);
        return sentence;
    }

    public String guessNumber() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int number = sc.nextInt();
        int randomNumber = random.nextInt(number);
        System.out.println(randomNumber);
        if (number == randomNumber) {
            printSentence("That's it");
            System.exit(0);
        }
        String statement = (number > randomNumber) ? printSentence("Smaller") : printSentence("Larger");
        return statement;
    }

    public static void main(String[] args) {
        Task10 task10 = new Task10();
        task10.guessNumber();

    }
}
