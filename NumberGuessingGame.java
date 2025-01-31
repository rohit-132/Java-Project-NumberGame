import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static int playRound() {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;  // Random number between 1 and 100
        int attempts = 0;
        int maxAttempts = 10;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts to guess the number.");
        
        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;
            
            if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (guess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                return attempts;
            }
        }
        
        System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The number was " + numberToGuess + ".");
        return maxAttempts;
    }

    public static void playGame() {
        int totalRounds = 0;
        int totalScore = 0;
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            int attemptsTaken = playRound();
            totalRounds++;
            totalScore += attemptsTaken;
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().trim().toLowerCase();
            
            if (!playAgain.equals("yes")) {
                break;
            }
        }
        
        // Calculate the average score (average attempts per round)
        double averageScore = totalRounds > 0 ? (double) totalScore / totalRounds : 0;
        System.out.println("Thanks for playing! You played " + totalRounds + " rounds.");
        System.out.println("Your average score (attempts per round) is: " + String.format("%.2f", averageScore));
    }

    public static void main(String[] args) {
        playGame();
    }
}
