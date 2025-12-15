import java.math.BigDecimal;

public class Circle extends Shape {
  private double radius;

  public Circle(String color, double radius) {
    super(color);
    this.radius = radius;
  }

  public double area() {
    return BigDecimal.valueOf(Math.PI) //
        .multiply(BigDecimal.valueOf(radius)) //
        .multiply(BigDecimal.valueOf(radius)) //
        .doubleValue();
  }

  public double getRadius() {
    return radius;
  }



  // main method
  public static void main(String[] args) {
    // test
    Circle circle = new Circle("Red", 3.5);
    System.out.println(circle.area());



  }
}
