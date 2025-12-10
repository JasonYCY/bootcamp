public class Cat {
  // non-static attributes (belongs to object)
  private String name;
  private int age;

  // default constructor (compiler will auto-generate this if not specified)
  public Cat() {}

  // non-static methods (belongs to object)
  public boolean isAdult() {
    return age > 6;
  }

  public String getName() {
    return name;
  }
  
  public int getAge() {
    return age;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }


  // main method (special method, this is the entry point of the program)
  public static void main(String[] args) {
    Cat cat1 = new Cat(); // creates a new Cat object, and cat1 is now pointing to it
    Cat cat2 = new Cat(); // creates a new Cat object, and cat2 is now pointing to it

    cat1.setName("John");
    System.out.println("Cat 1's name: " + cat1.name); // John
    System.out.println("Cat 2's name: " + cat2.name); // null

    Cat cat3 = cat1; // cat3 also points to the Cat object pointed by cat1
    cat3.setName("Peter");
    System.out.println("Cat 3's name: " + cat3.name); // Peter
    System.out.println("Cat 1's name: " + cat1.name); // Peter

    cat1.setAge(7);
    cat2.setAge(6);
    System.out.println("Cat 1 is adult: " + cat1.isAdult());
    System.out.println("Cat 2 is adult: " + cat2.isAdult());




  }
}
