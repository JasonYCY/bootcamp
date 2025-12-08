import java.util.Random;
import java.util.Scanner;

public class DemoBingo {
  public static void main(String[] args) {
    // 1 to 100 (random number)
    // one user
    // 1) compare user input (from scanner) to the random number
    // 2) if same -> end game
    // 3) if not same -> update the range for selection
    //      for example:
    //            round 1: user picks 69 -> new range: 70 to 100
    //            round 2: user picks 90 -> new range: 70 to 89
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
