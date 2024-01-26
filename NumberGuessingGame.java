import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numberToGuess = random.nextInt(100) + 1;
        int numberOfTries = 0;
        int attempt;
        boolean hasGuessedCorrectly = false;
        final int maxAttempts = 10;

        System.out.println("Guess the number between 1 and 100. You have " + maxAttempts + " attempts.");

        while (!hasGuessedCorrectly && numberOfTries < maxAttempts) {
            System.out.print("Enter your guess: ");
            attempt = scanner.nextInt();
            numberOfTries++;

            if (attempt < 1 || attempt > 100) {
                System.out.println("Invalid guess. Please guess a number between 1 and 100.");
            } else if (attempt < numberToGuess) {
                System.out.println("Too low!");
            } else if (attempt > numberToGuess) {
                System.out.println("Too high!");
            } else {
                hasGuessedCorrectly = true;
                System.out.println("Correct! You've guessed the number in " + numberOfTries + " attempts.");
            }
        }

        if (!hasGuessedCorrectly) {
            System.out.println("Game Over! The number was " + numberToGuess);
        }

        scanner.close();
    }
}
