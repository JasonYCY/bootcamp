package league_of_legends_exercise;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("--- Welcome to League of Legends Battle Game ---");

    // 1. Hero Creation Phase
    Hero hero1 = createHero(scanner, "Player 1");
    Hero hero2 = createHero(scanner, "Player 2");

    // 2. Set Level Phase
    setLevelForHero(scanner, hero1, "Player 1");
    setLevelForHero(scanner, hero2, "Player 2");

    System.out.println("\n--- Starting Game! ---");
    System.out.println("Player 1's Hero:\n" + hero1);
    System.out.println("Player 2's Hero:\n" + hero2);

    // 3. Game Loop Phase
    // Player 1 starts
    boolean isPlayer1Turn = true;
    while (hero1.getCurrentHp() > 0 && hero2.getCurrentHp() > 0) {
      Hero currentAttacker = isPlayer1Turn ? hero1 : hero2;
      Hero currentOpponent = isPlayer1Turn ? hero2 : hero1;
      String playerName = isPlayer1Turn ? "Player 1" : "Player 2";

      System.out.println("\n--- " + playerName + "'s Turn (Level: "
          + currentAttacker.getLevel() + ") ---");
      displayActionsMenu();

      boolean turnCompleted = false;
      while (!turnCompleted) {
        try {
          int choice = Integer.parseInt(scanner.nextLine());
          turnCompleted =
              handleAction(choice, currentAttacker, currentOpponent, scanner);
        } catch (NumberFormatException e) {
          System.out
              .println("Invalid input. Please enter a number between 1 and 5.");
        }
      }

      // Switch turns
      isPlayer1Turn = !isPlayer1Turn;

      // Display current HPs at end of turn
      System.out.printf("\nGame Status: P1 HP: %.1f | P2 HP: %.1f\n",
          hero1.getCurrentHp(), hero2.getCurrentHp());
    }

    // 4. Game Over Phase
    System.out.println("\n--- GAME OVER ---");
    if (hero1.getCurrentHp() <= 0) {
      System.out.println("Player 2 (" + hero2.getRole() + ") wins!");
    } else {
      System.out.println("Player 1 (" + hero1.getRole() + ") wins!");
    }

    scanner.close();
  }

  // --- Helper Methods ---

  private static Hero createHero(Scanner scanner, String playerName) {
    System.out.println("\n" + playerName + ", choose your hero's role:");
    int index = 1;
    for (Role role : Role.values()) {
      System.out.println(index++ + ". " + role);
    }

    Role chosenRole = null;
    while (chosenRole == null) {
      System.out.print("Enter number (1-" + Role.values().length + "): ");
      try {
        int roleIndex = Integer.parseInt(scanner.nextLine());
        if (roleIndex >= 1 && roleIndex <= Role.values().length) {
          chosenRole = Role.values()[roleIndex - 1];
        } else {
          System.out.println("Invalid number. Please choose from the list.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a number.");
      }
    }
    System.out.println(playerName + " selected " + chosenRole + ".");
    return new Hero(chosenRole);
  }

  private static void setLevelForHero(Scanner scanner, Hero hero,
      String playerName) {
    System.out.println("\n" + playerName
        + ", set your hero's starting level (1-" + BaseStats.MAX_LEVEL + "):");
    while (true) {
      System.out.print("Enter level: ");
      try {
        int level = Integer.parseInt(scanner.nextLine());
        if (hero.setLevel(level)) {
          System.out
              .println(playerName + "'s hero set to Level " + level + ".");
          return;
        } else {
          System.out.println(
              "Invalid level. Must be between 1 and " + BaseStats.MAX_LEVEL);
        }
      } catch (NumberFormatException e) {
        System.out
            .println("Invalid input. Please enter a valid integer level.");
      }
    }
  }

  private static void displayActionsMenu() {
    System.out.println("Choose an action:");
    System.out.println("1. Physical Attack (PA)");
    System.out.println("2. Magical Attack (MA)");
    System.out.println("3. Recover HP (20%)");
    System.out.println("4. Level Up (+1 Level)");
    System.out.println("5. Do Nothing / End Turn");
    System.out.print("Enter choice: ");
  }

  // Returns true if the turn is completed and can switch players
  private static boolean handleAction(int choice, Hero attacker, Hero opponent,
      Scanner scanner) {
    switch (choice) {
      case 1:
        attacker.physicalAttack(opponent);
        System.out.println("Used Physical Attack!");
        return true;
      case 2:
        attacker.magicalAttack(opponent);
        System.out.println("Used Magical Attack!");
        return true;
      case 3:
        attacker.recoverHp();
        System.out.println("Recovered 20% HP.");
        return true;
      case 4:
        // Level up is allowed but ends the turn
        if (attacker.getLevel() < BaseStats.MAX_LEVEL) {
          attacker.levelUp();
          System.out.println("Leveled up to " + attacker.getLevel() + "!");
          System.out.println(attacker); // Show updated stats
          return true;
        } else {
          System.out.println("Already at max level (" + BaseStats.MAX_LEVEL
              + ")! Choose another action.");
          return false; // Turn not complete, must choose again
        }
      case 5:
        System.out.println("Did nothing.");
        return true;
      default:
        System.out.println("Invalid action choice. Please choose 1-5.");
        return false;
    }
  }
}
