package league_of_legends_exercise2;

public enum BowType {
  RECURVE(
    4,
    2,
    0.05,
    0.04,
    0.02,
    0.01
  ),
  GUINSOO(
    8,
    4,
    0.1,
    0.06,
    0.04,
    0.02
  ),;

  private double PA;
  private double MA;
  private double CC;
  private double PA_Growth;
  private double MA_Growth;
  private double CC_Growth;

  private BowType(double PA, double MA, double CC, double PA_Growth, double MA_Growth, double CC_Growth) {
    this.PA = PA;
    this.MA = MA;
    this.CC = CC;
    this.PA_Growth = PA_Growth;
    this.MA_Growth = MA_Growth;
    this.CC_Growth = CC_Growth;
  }

  public double getPA() {
    return PA;
  }

  public double getMA() {
    return MA;
  }

  public double getCC() {
    return CC;
  }
  
  public double getPA_Growth() {
    return PA_Growth;
  }

  public double getMA_Growth() {
    return MA_Growth;
  }

  public double getCC_Growth() {
    return CC_Growth;
  }
}
