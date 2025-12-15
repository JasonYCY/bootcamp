public abstract class Shape {
  private String color;

  public Shape(String color) {
    this.color = color;
  }

  public String getColor() {
    return color;
  }

  // abstract method (without implementation)
  // child class MUST implement all abstract methods
  abstract double area();
}
