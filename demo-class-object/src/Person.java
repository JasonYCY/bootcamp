import java.math.BigDecimal;
import java.math.RoundingMode;

public class Person {
  // attribute
  private double height;
  private double weight;
  
  // constructor
  public Person() {}

  public Person(double height, double weight) {
    this.height = height;
    this.weight = weight;
  }
  
  // method
  public double getHeight() {
    return height;
  }

  public double getWeight() {
    return weight;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public double getBMI() {
    return BigDecimal.valueOf(weight).divide(BigDecimal.valueOf(height).multiply(BigDecimal.valueOf(height)), 5, RoundingMode.HALF_UP).doubleValue();
  }

  // main method
  public static void main(String[] args) {
    Person p1 = new Person();
    p1.setHeight(1.73);
    p1.setWeight(79);

    Person[] persons = new Person[2];
    persons[0] = new Person();
    persons[1] = p1;

    for (Person person : persons) {
      System.out.println(person.getHeight());
      System.out.println(person.getWeight());
    }

    System.out.println("BMI: " + p1.getBMI());
  }
}
