package league_of_legends_exercise2;

public abstract class Hero<W extends Weapon> {
  // Static attribute
  private static int nextId = 0;

  // Mutable stats
  protected int Id = nextId++;
  protected int level;
  protected double currentHp;
  protected double currentMp;
  private final Role role;
  protected W weapon;

  // Derived stats
  protected double maxHp;
  protected double maxMp;
  protected double physicalAttack;
  protected double physicalDefense;
  protected double magicalAttack;
  protected double magicalDefense;
  protected double agility;
  protected double criticalChance;

  // Constructor
  public Hero(Role role) {
    this.role = role;
    this.level = 1;
    updateStats();
    this.currentHp = this.maxHp;
    this.currentMp = this.maxMp;
  }

  // Methods
  // Core weapon handling methods
  public void equip(W weapon) {
    this.weapon = weapon;
    // Optional: Trigger any visual or health-related side effects here
  }

  public void removeWeapon() {
    this.weapon = null;
  }

  // Dynamic Stat Getters
  public double getTotalPA() {
    double weaponBonus = (weapon != null) ? weapon.getPA() : 0;
    return this.physicalAttack + weaponBonus;
  }

  public double getTotalMA() {
    double weaponBonus = (weapon != null) ? weapon.getMA() : 0;
    return this.magicalAttack + weaponBonus;
  }

  public double getTotalCC() {
    double weaponBonus = (weapon != null) ? weapon.getCC() : 0;
    return Math.min(1.0, this.criticalChance + weaponBonus); // Cap at 100%
  }

  public double getTotalCD() {
    // CD scales with the TOTAL physical attack (Hero + Weapon)
    RoleConstants constants = RoleConstants.getConstants(this.role);
    return constants.criticalDamageMultiplier() * getTotalPA();
  }

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
  public boolean physicalAttack(Hero<?> opponent, double[] damageDealt) {
    double currentPA = getTotalPA();
    double currentCC = getTotalCC();
    
    // CD is multiplier * Total PA (Requirement: CD is calculated by Role multiplier and PA)
    double currentCD = RoleConstants.getConstants(this.role).criticalDamageMultiplier() * currentPA;
    
    boolean isCritical = Math.random() < currentCC;
    double totalDamage = isCritical ? currentCD : currentPA;
    
    damageDealt[0] = opponent.receivePhysicalDamage(totalDamage);
    return isCritical;
  }

  public void magicalAttack(Hero<?> opponent, double[] damageDealt) {
    // Uses getTotalMA() to include Stave bonuses
    damageDealt[0] = opponent.receiveMagicalDamage(this.getTotalMA());
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
    String weaponName = (weapon != null) ? weapon.getWeaponName() + " (Lvl " + weapon.getLevel() + ")" : "None";
    
    return String.format("""
      Hero{role=%s, level=%d, weapon=%s}
      HP: %.1f/%.1f | MP: %.1f/%.1f
      PA: %.1f | PD: %.1f | MA: %.1f | MD: %.1f
      AG: %.1f | CC: %.1f%% | CD: %.1f
      """,
      role, level, weaponName,
      currentHp, maxHp, currentMp, maxMp,
      getTotalPA(), physicalDefense, getTotalMA(), magicalDefense,
      agility, getTotalCC() * 100, (RoleConstants.getConstants(this.role).criticalDamageMultiplier() * getTotalPA())
    );
  }

  // Getter
  public double getCurrentHp() {
    return currentHp;
  }

  public double getCurrentMp() {
    return currentMp;
  }

  public double getPhysicalAttack() {
    return getTotalPA();
  }

  public double getPhysicalDefense() {
    return physicalDefense;
  }

  public double getMagicalAttack() {
    return getTotalMA();
  }

  public double getMagicalDefense() {
    return magicalDefense;
  }

  public double getAgility() {
    return agility;
  }

  public double getCriticalChance() {
    return getTotalCC();
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

  public int getId() {
    return Id;
  }

  public W getWeapon() {
    return weapon;
  }
  
}
