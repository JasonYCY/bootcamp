package league_of_legends_exercise;

public record RoleConstants(
  double hpMultiplier,            // Warrior: 1.5, Mage: 1.0, Archer: 1.2
  double mpMultiplier,            // Warrior: 0.7, Mage: 1.5, Archer: 1.2
  double paMultiplier,            // Warrior: 1.3, Mage: 0.8, Archer: 1.1
  double pdMultiplier,            // Warrior: 1.4, Mage: 0.9, Archer: 1.0
  double maMultiplier,            // Warrior: 0.6, Mage: 1.4, Archer: 1.0
  double mdMultiplier,            // Warrior: 0.7, Mage: 1.3, Archer: 1.0
  double agilityMultiplier,       // Warrior: 0.8, Mage: 0.6, Archer: 1.5
  double criticalChance,          // Warrior: 0.05, Mage: 0.15, Archer: 0.20
  double criticalDamageMultiplier // Warrior: 2.5, Mage: 1.8, Archer: 1.5
) {
  public static final RoleConstants warrior = new RoleConstants(1.5, 0.7, 1.3, 1.4, 0.6, 0.7, 0.8, 0.05, 2.50);
  public static final RoleConstants mage = new RoleConstants(1.0, 1.5, 0.8, 0.9, 1.4, 1.3, 0.6, 0.15, 1.8);
  public static final RoleConstants archer = new RoleConstants(1.2, 1.2, 1.1, 1.0, 1.0, 1.0, 1.5, 0.20, 1.5);

  public static RoleConstants getConstants(Role role) {
    if (role == Role.WARRIOR)
      return warrior;
    else if (role == Role.MAGE)
      return mage;
    else
      return archer;
  }
}