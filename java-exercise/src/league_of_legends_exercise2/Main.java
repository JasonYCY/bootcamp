package league_of_legends_exercise2;

import java.util.Scanner;

public class Main {
  // ANSI Escape Codes for coloring the terminal output
  private static final String RESET = "\u001B[0m";
  private static final String RED = "\u001B[31m"; // Invalid input/Error
  private static final String GREEN = "\u001B[32m"; // Used for Player 2 prompts/actions (formerly used for general
                                                    // success)
  private static final String BLUE = "\u001B[34m"; // Used for Player 1 prompts/actions
  private static final String CYAN = "\u001B[36m"; // Welcome message
  private static final String PINK = "\u001B[38;5;217m"; // Light Pink
  private static final String GOLD = "\u001B[38;5;214m"; // Game Over message
  private static final String YELLOW = "\u001B[38;5;214m"; // Status updates

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println(
        CYAN + "--- Welcome to League of Legends Exercise Game ---" + RESET);

    // 1. Hero Creation Phase - Use dedicated colors here
    Hero<?> hero1 = createHero(scanner, "Player 1", BLUE);
    Hero<?> hero2 = createHero(scanner, "Player 2", GREEN); // Changed P2 to GREEN

    // NEW: Weapon Selection Phase
    equipWeaponPhase(scanner, hero1, "Player 1", BLUE);
    equipWeaponPhase(scanner, hero2, "Player 2", GREEN);

    // 2. Set Level Phase - Use dedicated colors here
    setLevelForHero(scanner, hero1, "Player 1", BLUE);
    setLevelForHero(scanner, hero2, "Player 2", GREEN);

    System.out.println(YELLOW + "\n--- Starting Game! FIGHT! ---" + RESET);
    System.out.println(BLUE + "Player 1's Hero:\n" + hero1 + RESET);
    System.out.println(GREEN + "Player 2's Hero:\n" + hero2 + RESET);

    // 3. Game Loop Phase
    boolean isPlayer1Turn = true;
    while (hero1.getCurrentHp() > 0 && hero2.getCurrentHp() > 0) {
      Hero<?> currentAttacker = isPlayer1Turn ? hero1 : hero2;
      Hero<?> currentOpponent = isPlayer1Turn ? hero2 : hero1;
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
          turnCompleted = handleAction(scanner, choice, currentAttacker, currentOpponent,
              playerColor);
        } catch (NumberFormatException e) {
          // Invalid input is always RED
          System.out.println(
              RED + "Invalid input. Please enter a number between 1 and 7."
                  + RESET);
          // Prompt happens automatically because turnCompleted is false
        }
      }

      // Switch turns
      isPlayer1Turn = !isPlayer1Turn;
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

  private static int getValidInput(Scanner scanner, int min, int max, String color) {
    while (true) {
      System.out.print(color + "Enter choice (" + min + "-" + max + "): " + RESET);
      try {
        int input = Integer.parseInt(scanner.nextLine());
        if (input >= min && input <= max) return input;
        System.out.println(RED + "Invalid range. Try again." + RESET);
      } catch (NumberFormatException e) {
        System.out.println(RED + "Invalid input. Please enter a number." + RESET);
      }
    }
  }

  private static void equipWeaponPhase(Scanner scanner, Hero<?> hero, String playerName, String playerColor) {
    System.out.println(playerColor + "\n" + playerName + ", choose your starting weapon:" + RESET);
    System.out.println(playerColor + "0. None (Don't equip now)" + RESET);
    
    if (hero instanceof Archer archer) {
      System.out.println(playerColor + "1. Recurve (Bow)\n2. Guinsoo (Bow)" + RESET);
      int choice = getValidInput(scanner, 0, 2, playerColor);
      if (choice == 1) archer.equip(new Bow(BowType.RECURVE));
      else if (choice == 2) archer.equip(new Bow(BowType.GUINSOO));
    } else if (hero instanceof Warrior warrior) {
      System.out.println(playerColor + "1. Doran (Sword)\n2. Hexdrinker (Sword)" + RESET);
      int choice = getValidInput(scanner, 0, 2, playerColor);
      if (choice == 1) warrior.equip(new Sword(SwordType.DORAN));
      else if (choice == 2) warrior.equip(new Sword(SwordType.HEXDRINKER));
    } else if (hero instanceof Mage mage) {
      System.out.println(playerColor + "1. Archangel (Stave)\n2. Liandry (Stave)"+ RESET);
      int choice = getValidInput(scanner, 0, 2, playerColor);
      if (choice == 1) mage.equip(new Stave(StaveType.ARCHANGEL));
      else if (choice == 2) mage.equip(new Stave(StaveType.LIANDRY));
    }
  }


  // Updated creation phase to use specific P1/P2 colors passed in
  private static Hero<?> createHero(Scanner scanner, String playerName,
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

    return switch (chosenRole) {
      case ARCHER -> new Archer();
      case MAGE -> new Mage();
      case WARRIOR -> new Warrior();
    };
  }

  // Updated set level to use specific P1/P2 colors passed in
  private static void setLevelForHero(Scanner scanner, Hero<?> hero,
      String playerName, String playerColor) {
    System.out.println(
        playerColor + "\n" + playerName + ", set your hero's starting level (1-"
            + BaseStats.MAX_LEVEL + "):" + RESET);
    while (true) {
      System.out.print(playerColor + "Enter level: " + RESET);
      try {
        int level = Integer.parseInt(scanner.nextLine());
        if (hero.setLevel(level)) {
          System.out.println("\n" + YELLOW + playerName
              + "'s hero set to Level " + level + "." + RESET);
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
    System.out.println(playerColor + "4. Level Up Hero" + RESET);
    System.out.println(playerColor + "5. Level Up Weapon" + RESET);
    System.out.println(playerColor + "6. Manage Weapon" + RESET);
    System.out.println(playerColor + "7. Do Nothing / End Turn" + RESET);
    // Prompt for choice is moved into the main loop try/catch block
  }

  // Returns true if the turn is completed and can switch players
  private static boolean handleAction(Scanner scanner, int choice, Hero<?> attacker, Hero<?> opponent,
      String color) {
    System.out.println();
    double[] damageDealt = new double[1]; // Array used to pass-by-reference damage value
    double oldOpponentHp = opponent.getCurrentHp();
    double oldAttackerHp = attacker.getCurrentHp();

    switch (choice) {
      case 1:
        boolean isCrit = attacker.physicalAttack(opponent, damageDealt);
        System.out.println(YELLOW + "Player " + (attacker.getId() + 1)
            + " used Physical Attack!\n" + RESET);
        System.out.println(YELLOW + "Player " + (opponent.getId() + 1)
            + " took " + String.format("%.1f", damageDealt[0]) + " damage"
            + (isCrit ? " (Critical Damage!)" : ""));
        System.out.println("HP: " + String.format("%.1f/%.1f -> %.1f/%.1f",
            oldOpponentHp, opponent.getMaxHp(), opponent.getCurrentHp(),
            opponent.getMaxHp()) + RESET);
        showStatus(attacker, opponent);
        return true;

      case 2:
        attacker.magicalAttack(opponent, damageDealt);
        System.out.println(YELLOW + "Player " + (attacker.getId() + 1)
            + " used Magical Attack!\n" + RESET);
        System.out.println(YELLOW + "Player " + (opponent.getId() + 1)
            + " took " + String.format("%.1f", damageDealt[0]) + " damage");
        System.out.println("HP: " + String.format("%.1f/%.1f -> %.1f/%.1f",
            oldOpponentHp, opponent.getMaxHp(), opponent.getCurrentHp(),
            opponent.getMaxHp()) + RESET);
        showStatus(attacker, opponent);
        return true;

      case 3:
        attacker.recoverHp();
        System.out.println(
            YELLOW + "Player " + (attacker.getId() + 1) + " recovered 20% HP!");
        System.out.println("HP: " + String.format("%.1f/%.1f -> %.1f/%.1f",
            oldAttackerHp, attacker.getMaxHp(), attacker.getCurrentHp(),
            attacker.getMaxHp()) + RESET);
        showStatus(attacker, opponent);
        return true;

      case 4:
        if (attacker.getLevel() < BaseStats.MAX_LEVEL) {
          attacker.levelUp();
          System.out.println(
              YELLOW + "Leveled up to " + attacker.getLevel() + "!" + RESET);
          showStatus(attacker, opponent);
          return true;
        } else {
          System.out.println(RED + "Already at max level ("
              + BaseStats.MAX_LEVEL + ")! Choose another action." + RESET);
          return false;
        }

      // Inside the switch(choice) block of handleAction:
      case 5: // Level Up Weapon
        if (attacker.getWeapon() != null && attacker.getWeapon().getLevel() < 3) {
          attacker.getWeapon().levelUp();
          System.out.println(YELLOW + "Weapon leveled up to " + attacker.getWeapon().getLevel() + "!" + RESET);
          return true;
        } else {
          System.out.println(RED + "Cannot level up weapon (None equipped or Max level)!" + RESET);
          return false;
        }

      case 6: // Manage Weapon (Unequip/Equip)
        System.out.println(color + "1. Unequip Weapon | 2. Equip New Weapon | 3. Cancel" + RESET);
        int subChoice = getValidInput(scanner, 1, 3, color);

        if (subChoice == 1) {
          attacker.removeWeapon();
          System.out.println(YELLOW + "Weapon unequipped. Stats reset." + RESET);
          return true; // Ending turn after unequipping (optional, can be false)
        } else if (subChoice == 2) {
          equipWeaponPhase(scanner, attacker, "Current Player", color);
          return true; // Ending turn after equipping (optional, can be false)
        } else {
          // Choice 3: Cancel
          System.out.println(YELLOW + "Weapon management cancelled." + RESET);
          return false; // CRITICAL: This keeps turnCompleted as false, loop repeats
        }

      case 7:
        System.out.println(YELLOW + "Did nothing." + RESET);
        showStatus(attacker, opponent);
        return true;

      default:
        System.out
            .println(RED + "Invalid action choice. Please choose 1-7." + RESET);
        return false;
    }
  }

  // Helper to show both players status in yellow
  private static void showStatus(Hero<?> a, Hero<?> b) {
    Hero<?> p1 = (a.getId() == 0) ? a : b;
    Hero<?> p2 = (a.getId() == 1) ? a : b;
    System.out.println(PINK + "\nPlayer 1 - " + p1.getRole() + " (Lv. "
        + p1.getLevel() + ")");
    System.out.printf("HP: %.1f/%.1f | MP: %.1f/%.1f\n", p1.getCurrentHp(),
        p1.getMaxHp(), p1.getCurrentMp(), p1.getMaxMp());
    System.out.println(
        "\nPlayer 2 - " + p2.getRole() + " (Lv. " + p2.getLevel() + ")");
    System.out.printf("HP: %.1f/%.1f | MP: %.1f/%.1f\n" + RESET,
        p2.getCurrentHp(), p2.getMaxHp(), p2.getCurrentMp(), p2.getMaxMp());
  }
}
