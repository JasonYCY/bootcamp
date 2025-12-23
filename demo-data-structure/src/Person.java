import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Person implements Comparable<Person> {
  // attribute
  private String name;
  private int age;
  private Occupation occupation;

  // constructor
  public Person(String name, int age, Occupation occupation) {
    this.name = name;
    this.age = age;
    this.occupation = occupation;
  }

  // compareTo
  @Override
  public int compareTo(Person otherPerson) {
    return otherPerson.getAge() - this.age;
  }

  // toString
  @Override
  public String toString() {
    return "Person{name=" + name + ", occupation=" + occupation + ", age=" + age + "}";
  }

  // getter
  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public Occupation getOccupation() {
    return occupation;
  }

  // enum
  public static enum Occupation {
    PROGRAMMER,
    POLICE,
    CLERK,
  }







  // main method
  public static void main(String[] args) {
    // sort from oldest to youngest
    ArrayList<Person> list = new ArrayList<>(
      Arrays.asList(
        new Person("Alice", 30, Occupation.PROGRAMMER),
        new Person("Bob", 25, Occupation.CLERK),
        new Person("Charlie", 35, Occupation.POLICE),
        new Person("Diana", 28, Occupation.CLERK),
        new Person("Ethan", 32, Occupation.PROGRAMMER)
      )
    );
    System.out.println(list);
    System.out.println();

    PriorityQueue<Person> peopleQueue = new PriorityQueue<>(new SortByRule1());
    peopleQueue.addAll(list);
    peopleQueue.offer(new Person("John", 89, Occupation.CLERK));
    System.out.println(peopleQueue.poll());
    System.out.println(peopleQueue.poll());
    System.out.println(peopleQueue.poll());
    System.out.println(peopleQueue.poll());
    System.out.println(peopleQueue.poll());
    System.out.println(peopleQueue.poll());
    System.out.println(peopleQueue.poll());






  }
}
