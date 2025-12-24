package league_of_legends_exercise2;

public class Stave extends Weapon {
  private final StaveType staveType;

  public Stave(StaveType staveType) {
    super(
      INITIAL_LEVEL,
      staveType.name(),
      staveType.getPA(),
      staveType.getMA(),
      staveType.getCC(),
      staveType.getPA_Growth(),
      staveType.getMA_Growth(),
      staveType.getCC_Growth()
    );
    this.staveType = staveType;
  }

  public StaveType getStaveType() {
    return staveType;
  }
}
