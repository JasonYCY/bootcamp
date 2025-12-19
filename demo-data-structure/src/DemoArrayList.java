import java.util.ArrayList;

public class DemoArrayList {
  public static void main(String[] args) {
    // Disadvantage of array: fixed length
    // int[] arr = new int[3];

    // ArrayList (array size changes dynamically)
    ArrayList<String> names = new ArrayList<>();
    names.add("John");
    names.add("Steve");
    names.add("Mary");
    System.out.println(names);

    // remove() -> call your overridden equals() if it exists
    // remove() -> break the for loop when it found the element
    names.remove(new String("Mary"));
    System.out.println(names);
  }
}
