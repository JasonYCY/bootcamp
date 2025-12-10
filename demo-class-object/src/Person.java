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
  public double getBMI() {
    return BigDecimal.valueOf(weight).divide(BigDecimal.valueOf(height).multiply(BigDecimal.valueOf(height)), 1, RoundingMode.HALF_UP).doubleValue();
  }

  public String getBMIString() {
    double BMI = getBMI();
    if (BMI < 18.5) {
      return "Under weight";
    } else if (BMI < 25) {
      return "Normal weight";
    } else if (BMI < 30) {
      return "Over weight";
    } else if (BMI < 35) {
      return "Obese Type I";
    } else if (BMI < 40) {
      return "Obese Type II";
    } else {
      return "Obese Type III";
    }
  }

  // getter and setter
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
    System.out.println(p1.getBMIString());
  }
}
