import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create Scanner object
        Random random = new Random(); // For generating random number

        int numberToGuess = random.nextInt(10) + 1; // Random number between 1 and 10
        int guess;
        int attempts = 0;

        System.out.println("🎲 I'm thinking of a number between 1 and 10. Can you guess it?");

        while (true) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt(); // Read user input
            attempts++;

            if (guess == numberToGuess) {
                System.out.println("🎉 Correct! You guessed it in " + attempts + " tries.");
                break;
            } else if (guess < numberToGuess) {
                System.out.println("🔼 Too low. Try again!");
            } else {
                System.out.println("🔽 Too high. Try again!");
            }
        }

        scanner.close(); // Close the Scanner
    }
}
