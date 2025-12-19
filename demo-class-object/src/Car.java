public class Car {
  private static final Car car = new Car("Volkswagen", "White");

  private final String model;
  private final String color;

  private Car(String model, String color) {
    this.model = model;
    this.color = color;
  }

  public static Car getCar() {
    return car;
  }

  public String getModel() {
    return model;
  }

  public String getColor() {
    return color;
  }

  @Override
  public String toString() {
    return "Car{" +
          "model='" + model + '\'' +
          ", color='" + color + '\'' +
          '}';
  }

  // main method
  public static void main(String[] args) {
    Car car1 = Car.getCar();
    Car car2 = Car.getCar();

    System.out.println(car1 == car2);
  }
}
