import java.util.ArrayList;
import java.util.Objects;

public class Cat {
  private String name;

  public Cat(String name) {
    this.name = name;
  }

  public static Cat ofName(String name) {
    return new Cat(name);
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof Cat)) return false;
    Cat cat = (Cat) obj;
    return Objects.equals(name, cat.getName());
  }

  @Override
  public String toString() {
    return "Cat{name='" + name + "'}";
  }


  // main method
  public static void main(String[] args) {
    // test
    ArrayList<Cat> arr = new ArrayList<>();
    Cat catToRemove;
    arr.add(Cat.ofName("John"));
    arr.add(Cat.ofName("Steve"));
    arr.add(catToRemove = Cat.ofName("Mary"));
    arr.add(Cat.ofName("Peter"));
    arr.add(Cat.ofName("Tom"));
    System.out.println(arr);

    arr.remove(catToRemove);
    System.out.println(arr);





  }
}
