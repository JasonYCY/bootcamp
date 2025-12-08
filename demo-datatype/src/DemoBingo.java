import java.util.Random;
import java.util.Scanner;

public class DemoBingo {
  public static void main(String[] args) {
    /**
     * A two-player number guessing game (Bingo Game).
     * Players A and B take turns guessing a secret number between 1 and 100.
     * After each guess, the range is narrowed based on feedback until someone guesses correctly.
     * 
     * If a player inputs a number outside the current valid range,
     * they must input again (without switching to the other player).
     */

    // Initialization
    int bingoNumber = new Random().nextInt(100) + 1;
    int lowerBound = 1;
    int upperBound = 100;
    int round = 1;
    char currentUser = 'A';
    Scanner scanner = new Scanner(System.in);
    System.out.println("A random number from 1 to 100 has been generated!\n");
    System.out.println("[Debug] bingo number = " + bingoNumber + " (This is only for debugging, please remove this println after testing!)\n");
    
    // Main loop
    while (true) {
      // Prompt user to input number
      System.out.print("(Round " + round + " - User " + currentUser + ") Please input a number from " + lowerBound + " to " + upperBound + ": ");

      // If the user doesn't input a number, ask the user to input again
      while (!scanner.hasNextInt()) {
        System.out.println("Please enter a valid number!");
        scanner.next(); // Clear invalid input
        System.out.print("(Round " + round + " - User " + currentUser + ") Please input a number from " + lowerBound + " to " + upperBound + ": ");
      }
      int userInput = scanner.nextInt();

      //  If the user's input isn't within the range, ask the user to input again
      if (userInput < lowerBound || userInput > upperBound) {
        System.out.println("Your input number is not within the range! Please enter a valid number!");
        continue;
      }

      // Compare user's input with the bingo number
      if (userInput < bingoNumber) {
        System.out.println("Your input number is smaller than the secret number!\n");
        lowerBound = userInput + 1;
      } else if (userInput > bingoNumber) {
        System.out.println("Your input number is greater than the secret number!\n");
        upperBound = userInput - 1;
      } else {
        System.out.println("BINGO! Game Over! User " + currentUser + " wins!");
        break; // Exit while loop if the game is over
      }
      
      // Update variables for the next round
      round += 1;
      currentUser = (currentUser == 'A') ? 'B' : 'A';
    }

    // Close the Scanner object and release system resources associated with it
    scanner.close();

  }
}
