package league_of_legends_exercise2;

public class Sword extends Weapon {
  private final SwordType swordType;

  public Sword(SwordType swordType) {
    super(
      INITIAL_LEVEL,
      swordType.name(),
      swordType.getPA(),
      swordType.getMA(), 
      swordType.getCC(),
      swordType.getPA_Growth(),
      swordType.getMA_Growth(),
      swordType.getCC_Growth()
    );
    this.swordType = swordType;
  }
  
  public SwordType getSwordType() {
    return swordType;
  }
}
