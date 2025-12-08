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
    Scanner scanner = new Scanner(System.in);
    int bingoNumber = new Random().nextInt(100) + 1;
    int lowerBound = 1;
    int upperBound = 100;
    int round = 1;
    char currentUser = 'A';
    System.out.println("A random number from 1 to 100 has been generated!\n");
    System.out.println("[Debug] bingo number = " + bingoNumber + " (This is only for debugging, please remove this println during actual game!)\n");
    
    while (true) {
      System.out.print("(Round " + round + " - User " + currentUser + ") Please input a number from " + lowerBound + " to " + upperBound + ": ");
      int userInput = scanner.nextInt();

      if (userInput < lowerBound || userInput > upperBound) {
        System.out.println("Your input number is not within the range! Please enter a valid input!\n");
        continue;
      }

      if (userInput < bingoNumber) {
        System.out.println("Your input number is smaller than the secret number!\n");
        lowerBound = userInput + 1;
      } else if (userInput > bingoNumber) {
        System.out.println("Your input number is larger than the secret number!\n");
        upperBound = userInput - 1;
      } else {
        System.out.println("Bingo! Game Ended!");
        System.out.println("The winner is User " + currentUser + "!");
        break;
      }
      
      round += 1;
      currentUser = (currentUser == 'A') ? 'B' : 'A';
    }

    scanner.close();

  }
}
