import java.math.BigDecimal;
import java.math.RoundingMode;

public class DemoBigDecimal {
  public static void main(String[] args) {
    // 0.2 + 0.1
    System.out.println(0.2 + 0.1);

    BigDecimal bd1 = BigDecimal.valueOf(0.2);
    BigDecimal bd2 = BigDecimal.valueOf(0.1);
    BigDecimal result = bd1.add(bd2);
    System.out.println(result);

    // 0.3 - 0.1
    System.out.println(0.3 - 0.1);
    bd1 = new BigDecimal("0.3");
    bd2 = new BigDecimal("0.1");
    result = bd1.subtract(bd2);
    System.out.println(result);

    // 0.1 * 0.2
    System.out.println(0.1 * 0.2);
    System.out
        .println(BigDecimal.valueOf(0.1).multiply(BigDecimal.valueOf(0.2)));

    // 0.25123 * 0.15 = 0.0376845
    double x = 0.25123;
    double y = 0.15;
    System.out.println(BigDecimal.valueOf(x).multiply(BigDecimal.valueOf(y))
        .setScale(3, RoundingMode.HALF_UP)); // 0.038

    System.out.println(BigDecimal.valueOf(0.5).multiply(BigDecimal.valueOf(0.5))
        .setScale(1, RoundingMode.HALF_DOWN)); // 0.2 (0.25 -> 0.2)
  }
}
