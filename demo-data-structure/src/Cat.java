import java.util.ArrayList;
import java.util.List;
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

  public void setName(String name) {
    this.name = name;
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
    Cat catToRemove = Cat.ofName("Mary");
    System.out.println("Cat to remove: " + catToRemove + "\n");
    arr.add(Cat.ofName("John"));
    arr.add(Cat.ofName("Steve"));
    arr.add(Cat.ofName("Mary"));
    arr.add(Cat.ofName("Peter"));
    arr.add(Cat.ofName("Tom"));
    arr.addFirst(null);
    arr.add(null);
    arr.add(null);
    System.out.println(arr + "\n");

    arr.remove(null);
    System.out.println(arr);
    arr.contains(catToRemove);
    arr.isEmpty();

    // polymorphism
    List<Cat> catList = new ArrayList<>();
    System.out.println(catList);





  }
}
