import java.math.BigDecimal;

public class Circle {
  // attribute
  private double radius;
  
  // method
  public double getRadius() {
    return radius;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

  public double area() {
    return BigDecimal.valueOf(Math.PI).multiply(BigDecimal.valueOf(radius).pow(2)).doubleValue();
  }

  // main method
  public static void main(String[] args) {
    Circle c1 = new Circle();
    System.out.println(c1.getRadius()); // 0.0

    c1.setRadius(3.5);
    System.out.println(c1.getRadius()); // 3.5
    System.out.println(c1.area()); // 38.48451000647496





  }
}
