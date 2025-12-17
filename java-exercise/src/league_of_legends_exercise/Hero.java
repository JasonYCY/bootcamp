package league_of_legends_exercise;

public class Hero {
  // Static attributes
  private static int nextId = 0;

  // Immutable stats
  private final int id;
  private final Role role;

  // Mutable stats
  private int level;
  private double currentHp;
  private double currentMp;

  // Derived stats
  private double maxHp;
  private double maxMp;
  private double physicalAttack;
  private double physicalDefense;
  private double magicalAttack;
  private double magicalDefense;
  private double agility;
  private double criticalChance;
  private double criticalDamage;

  // Constructor
  public Hero(Role role) {
    this.id = nextId++;
    this.role = role;
    this.level = 1;
    updateStats();
    this.currentHp = this.maxHp;
    this.currentMp = this.maxMp;
  }

  // Methods
  private void updateStats() {
    // Obtain multiplier constants based on roles
    RoleConstants constants = RoleConstants.getConstants(this.role);

    // Calculate common stats
    this.maxHp = calculateStat(BaseStats.BASE_HP, constants.hpMultiplier(), this.level, StatsGrowth.HP);
    this.maxMp = calculateStat(BaseStats.BASE_MP, constants.mpMultiplier(), this.level, StatsGrowth.MP);
    this.physicalAttack = calculateStat(BaseStats.BASE_PA, constants.paMultiplier(), this.level, StatsGrowth.PA);
    this.physicalDefense = calculateStat(BaseStats.BASE_PD, constants.pdMultiplier(), this.level, StatsGrowth.PD);
    this.magicalAttack = calculateStat(BaseStats.BASE_MA, constants.maMultiplier(), this.level, StatsGrowth.MA);
    this.magicalDefense = calculateStat(BaseStats.BASE_MD, constants.mdMultiplier(), this.level, StatsGrowth.MD);
    this.agility = calculateStat(BaseStats.BASE_AG, constants.agilityMultiplier(), this.level, StatsGrowth.AG);

    // Calculate critical chance and critical damage
    this.criticalChance = constants.criticalChance() * (1 + StatsGrowth.CC * (level - 1));
    this.criticalDamage = constants.criticalDamageMultiplier() * this.physicalAttack;
  }

  private static double calculateStat(double base, double roleMultiplier, int level, double growthRate) {
      return base * roleMultiplier * (1 + growthRate * (level - 1));
  }

  public void levelUp() {
    if (level >= BaseStats.MAX_LEVEL) return;

    this.level++;
    updateStats();
    this.currentHp = this.maxHp;
    this.currentMp = this.maxMp;
  }

  public boolean setLevel(int updatedLevel) {
    if (updatedLevel > BaseStats.MAX_LEVEL || updatedLevel < 1) {
      return false;
    }
    this.level = updatedLevel;

    updateStats();
    this.currentHp = this.maxHp;
    this.currentMp = this.maxMp;
    return true;
  }

  public double receivePhysicalDamage(double damage) {
    double effectiveDamage = Math.max(1, damage - this.physicalDefense);
    double previousHp = this.currentHp;
    this.currentHp = Math.max(0, this.currentHp - effectiveDamage);
    return previousHp - this.currentHp; // Returns actual damage dealt
  }

  public double receiveMagicalDamage(double damage) {
    double effectiveDamage = Math.max(1, damage - this.magicalDefense);
    double previousHp = this.currentHp;
    this.currentHp = Math.max(0, this.currentHp - effectiveDamage);
    return previousHp - this.currentHp; // Returns actual damage dealt
  }

  // Modified to return a boolean: true if critical hit
  public boolean physicalAttack(Hero opponent, double[] damageDealt) {
    double baseDamage = this.physicalAttack;
    boolean isCritical = Math.random() < this.criticalChance;
    double totalDamage = isCritical ? this.criticalDamage : baseDamage;
    
    // damageDealt[0] will store the result from receiveDamage
    damageDealt[0] = opponent.receivePhysicalDamage(totalDamage);
    return isCritical;
  }

  public void magicalAttack(Hero opponent, double[] damageDealt) {
    damageDealt[0] = opponent.receiveMagicalDamage(this.magicalAttack);
  }

  public void recoverHp() {
    this.currentHp = Math.min(this.maxHp, this.currentHp + this.maxHp * 0.2);
  }

  public void recoverAllHp() {
    this.currentHp = this.maxHp;
  }

  public void recoverMp() {
    this.currentMp = Math.min(this.maxMp, this.currentMp + this.maxMp * 0.2);
  }

  public void recoverAllMp() {
    this.currentMp = this.maxMp;
  }

  @Override
  public String toString() {
    return String.format("""
      Hero{id='%s', role=%s, level=%d}
      HP: %.1f/%.1f | MP: %.1f/%.1f
      PA: %.1f | PD: %.1f | MA: %.1f | MD: %.1f
      AG: %.1f | CC: %.1f%% | CD: %.1f
      """,
      id, role, level,
      currentHp, maxHp, currentMp, maxMp,
      physicalAttack, physicalDefense, magicalAttack, magicalDefense,
      agility, criticalChance * 100, criticalDamage
    );
  }

  // Getter
  public int getId() {
    return id;
  }

  public double getCurrentHp() {
    return currentHp;
  }

  public double getCurrentMp() {
    return currentMp;
  }

  public double getPhysicalAttack() {
    return physicalAttack;
  }

  public double getPhysicalDefense() {
    return physicalDefense;
  }

  public double getMagicalAttack() {
    return magicalAttack;
  }

  public double getMagicalDefense() {
    return magicalDefense;
  }

  public double getAgility() {
    return agility;
  }

  public double getCriticalChance() {
    return criticalChance;
  }

  public double getCriticalDamage() {
    return criticalDamage;
  }

  public int getLevel() {
    return level;
  }

  public Role getRole() {
    return role;
  }

  public double getMaxHp() {
    return maxHp;
  }

  public double getMaxMp() {
    return maxMp;
  }






}
