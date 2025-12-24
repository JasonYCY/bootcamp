package league_of_legends_exercise2;

public abstract class Weapon {
  protected final static int INITIAL_LEVEL = 1;
  protected final static int MAX_LEVEL = 3;

  protected int level;
  protected String weaponName;
  protected double PA;
  protected double MA;
  protected double CC;
  protected double PA_Growth;
  protected double MA_Growth;
  protected double CC_Growth;

  protected Weapon(int level, String weaponName, double PA, double MA, double CC, double PA_Growth, double MA_Growth, double CC_Growth) {
    this.level = level;
    this.weaponName = weaponName;
    this.PA = PA;
    this.MA = MA;
    this.CC = CC;
    this.PA_Growth = PA_Growth;
    this.MA_Growth = MA_Growth;
    this.CC_Growth = CC_Growth;
  }

  public void levelUp() {
    level = Math.min(MAX_LEVEL, level + 1);
  }

  public int getLevel() {
    return level;
  }

  public double getPA() {
    return PA * (1 + PA_Growth * (level - 1));
  }

  public double getMA() {
    return MA * (1 + MA_Growth * (level - 1));
  }

  public double getCC() {
    return CC * (1 + CC_Growth * (level - 1));
  }

  public String getWeaponName() {
    return weaponName;
  }
}
