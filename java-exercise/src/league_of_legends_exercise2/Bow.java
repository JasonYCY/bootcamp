package league_of_legends_exercise2;

public class Bow extends Weapon {
  private BowType bowType;

  public Bow(BowType bowType) {
    super(
      INITIAL_LEVEL,
      bowType.name(),
      bowType.getPA(),
      bowType.getMA(),
      bowType.getCC(),
      bowType.getPA_Growth(),
      bowType.getMA_Growth(),
      bowType.getCC_Growth()
    );
    this.bowType = bowType;
  }
  
  public BowType getBowType() {
    return bowType;
  }
}
