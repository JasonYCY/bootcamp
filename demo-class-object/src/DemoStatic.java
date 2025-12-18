import java.util.Objects;

public class DemoStatic {
  // 1. static variable
  private static int nextID = 0;

  // 2. static final variable
  private static final int SECONDS_IN_MINUTE = 60;

  // 3. instance variable
  private int age;

  // 4. final variable
  private final String name;


  public DemoStatic() {
    // call database to return the String "John" and assign to final variable
    this.name = "John";
    this.age = 18;

    System.out.println("Hash value: " + Objects.hash(nextID, SECONDS_IN_MINUTE, age, name));
  }

  public String getName() {
    return name;
  }




  // main method
  public static void main(String[] args) {
    // test
    new DemoStatic();














  }
}
