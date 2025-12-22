import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class DemoLinkedList {
  public static void main(String[] args) {
    LinkedList<String> names = new LinkedList<>();
    names.add("John");
    names.add("Peter");
    names.add("Tommy");
    names.add("Jenny");
    System.out.print(names);
    System.out.println(" | Size: " + names.size());

    names.remove("John");
    System.out.print(names);
    System.out.println(" | Size: " + names.size());

    // Polymorphism
    List<String> emails = null;
    emails = new ArrayList<>();
    emails = new LinkedList<>();
    emails = new Vector<>();
    emails = new Stack<>();
    System.out.println(emails);

  }
}