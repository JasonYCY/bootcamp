package league_of_legends_exercise;

import java.util.Scanner;

public class Main {
  // ANSI Escape Codes for coloring the terminal output
  private static final String RESET = "\u001B[0m";
  private static final String RED = "\u001B[31m"; // Invalid input/Error
  private static final String GREEN = "\u001B[32m"; // Used for Player 2 prompts/actions (formerly used for general
                                                    // success)
  private static final String YELLOW = "\u001B[33m"; // Status updates
  private static final String BLUE = "\u001B[34m"; // Used for Player 1 prompts/actions
  private static final String CYAN = "\u001B[36m"; // Welcome message
  private static final String GOLD = "\u001B[38;5;214m"; // Game Over message

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println(
        CYAN + "--- Welcome to League of Legends Exercise Game ---" + RESET);

    // 1. Hero Creation Phase - Use dedicated colors here
    Hero hero1 = createHero(scanner, "Player 1", BLUE);
    Hero hero2 = createHero(scanner, "Player 2", GREEN); // Changed P2 to GREEN

    // 2. Set Level Phase - Use dedicated colors here
    setLevelForHero(scanner, hero1, "Player 1", BLUE);
    setLevelForHero(scanner, hero2, "Player 2", GREEN);

    System.out.println(YELLOW + "\n--- Starting Game! FIGHT! ---" + RESET);
    System.out.println(BLUE + "Player 1's Hero:\n" + hero1 + RESET);
    System.out.println(GREEN + "Player 2's Hero:\n" + hero2 + RESET);

    // 3. Game Loop Phase
    boolean isPlayer1Turn = true;
    while (hero1.getCurrentHp() > 0 && hero2.getCurrentHp() > 0) {
      Hero currentAttacker = isPlayer1Turn ? hero1 : hero2;
      Hero currentOpponent = isPlayer1Turn ? hero2 : hero1;
      String playerName = isPlayer1Turn ? "Player 1" : "Player 2";
      // The main turn loop uses the specific player color for all prompts within the
      // turn
      String playerColor = isPlayer1Turn ? BLUE : GREEN;

      // Display turn start message in player's color
      System.out.println(playerColor + "\n--- " + playerName + "'s Turn"
          + " (Level: " + currentAttacker.getLevel() + ") ---" + RESET);

      // Actions menu will also be colored by the playerColor
      displayActionsMenu(playerColor);

      boolean turnCompleted = false;
      while (!turnCompleted) {
        // Prompt for input uses playerColor
        System.out.print(playerColor + "Enter choice: " + RESET);
        try {
          String input = scanner.nextLine();
          int choice = Integer.parseInt(input);
          // Pass playerColor down to handleAction
          turnCompleted = handleAction(choice, currentAttacker, currentOpponent,
              playerColor);
        } catch (NumberFormatException e) {
          // Invalid input is always RED
          System.out.println(
              RED + "Invalid input. Please enter a number between 1 and 5."
                  + RESET);
          // Reprompt happens automatically because turnCompleted is false
        }
      }

      // Switch turns
      isPlayer1Turn = !isPlayer1Turn;

      // Display current HPs at end of turn in YELLOW
      System.out.printf(
          YELLOW + "\nGame Status: P1 HP: %.1f | P2 HP: %.1f\n" + RESET,
          hero1.getCurrentHp(), hero2.getCurrentHp());
    }

    // 4. Game Over Phase (Cooler Message)
    System.out.println(RED + "\n        --- G A M E   O V E R ---" + RESET);
    String winnerName;
    String winnerRole;
    if (hero1.getCurrentHp() <= 0) {
      winnerName = "Player 2";
      winnerRole = hero2.getRole().toString();
    } else {
      winnerName = "Player 1";
      winnerRole = hero1.getRole().toString();
    }

    System.out.println(GOLD + "╔════════════════════════════════════════╗\n"
        + "║             K O !   K O !              ║\n"
        + "║              Game Over!                ║\n"
        + "║        The winner is " + winnerName + "!         ║\n"
        + "║          Using " + winnerRole + " role!            ║\n"
        + "╚════════════════════════════════════════╝" + RESET);

    scanner.close();
  }

  // --- Helper Methods ---

  // Updated creation phase to use specific P1/P2 colors passed in
  private static Hero createHero(Scanner scanner, String playerName,
      String playerColor) {
    System.out.println(
        playerColor + "\n" + playerName + ", choose your hero's role:" + RESET);
    int index = 1;
    for (Role role : Role.values()) {
      System.out.println(playerColor + index++ + ". " + role + RESET); // Color role list
    }

    Role chosenRole = null;
    while (chosenRole == null) {
      System.out.print(playerColor + "Enter number (1-" + Role.values().length
          + "): " + RESET);
      try {
        int roleIndex = Integer.parseInt(scanner.nextLine());
        if (roleIndex >= 1 && roleIndex <= Role.values().length) {
          chosenRole = Role.values()[roleIndex - 1];
        } else {
          System.out.println(
              RED + "Invalid number. Please choose from the list." + RESET);
        }
      } catch (NumberFormatException e) {
        System.out
            .println(RED + "Invalid input. Please enter a number." + RESET);
      }
    }
    System.out.println(
        playerColor + playerName + " selected " + chosenRole + "." + RESET);
    return new Hero(chosenRole);
  }

  // Updated set level to use specific P1/P2 colors passed in
  private static void setLevelForHero(Scanner scanner, Hero hero,
      String playerName, String playerColor) {
    System.out.println(
        playerColor + "\n" + playerName + ", set your hero's starting level (1-"
            + BaseStats.MAX_LEVEL + "):" + RESET);
    while (true) {
      System.out.print(playerColor + "Enter level: " + RESET);
      try {
        int level = Integer.parseInt(scanner.nextLine());
        if (hero.setLevel(level)) {
          System.out.println("\n" + YELLOW + playerName + "'s hero set to Level "
              + level + "." + RESET);
          return;
        } else {
          System.out.println(RED + "Invalid level. Must be between 1 and "
              + BaseStats.MAX_LEVEL + RESET);
        }
      } catch (NumberFormatException e) {
        System.out.println(
            RED + "Invalid input. Please enter a valid integer level." + RESET);
      }
    }
  }

  // Updated the menu prompt to accept the player color
  private static void displayActionsMenu(String playerColor) {
    System.out.println(playerColor + "Choose an action:" + RESET);
    System.out.println(playerColor + "1. Physical Attack (PA)" + RESET);
    System.out.println(playerColor + "2. Magical Attack (MA)" + RESET);
    System.out.println(playerColor + "3. Recover HP (20%)" + RESET);
    System.out.println(playerColor + "4. Level Up (+1 Level)" + RESET);
    System.out.println(playerColor + "5. Do Nothing / End Turn" + RESET);
    // Prompt for choice is moved into the main loop try/catch block
  }

  // Returns true if the turn is completed and can switch players
  private static boolean handleAction(int choice, Hero attacker, Hero opponent,
      String color) {
    System.out.println();
    switch (choice) {
      case 1:
        attacker.physicalAttack(opponent);
        System.out.println(YELLOW + "Used Physical Attack!" + RESET);
        return true;
      case 2:
        attacker.magicalAttack(opponent);
        System.out.println(YELLOW + "Used Magical Attack!" + RESET);
        return true;
      case 3:
        attacker.recoverHp();
        System.out.println(YELLOW + "Recovered 20% HP." + RESET);
        return true;
      case 4:
        if (attacker.getLevel() < BaseStats.MAX_LEVEL) {
          attacker.levelUp();
          System.out.println(
              YELLOW + "Leveled up to " + attacker.getLevel() + "!" + RESET);
          System.out.println(attacker); // Show updated stats
          return true;
        } else {
          System.out.println(RED + "Already at max level ("
              + BaseStats.MAX_LEVEL + ")! Choose another action." + RESET);
          return false; // Turn not complete, must choose again
        }
      case 5:
        System.out.println(YELLOW + "Did nothing." + RESET);
        return true;
      default:
        // This case is actually unreachable now because of the try/catch in main,
        // but good practice to keep.
        System.out
            .println(RED + "Invalid action choice. Please choose 1-5." + RESET);
        return false;
    }
  }
}
