import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class DemoMethodReference {
  public static class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
      this.id = id;
      this.name = name;
    }

    public int getId() {
      return id;
    }

    public String getName() {
      return name;
    }

    @Override
    public String toString() {
      return "Student{id=" + id + ", name=" + name + "}";
    }
  }


  public static int addOne(int x) {
    return x + 1;
  }
  
  public static double addOne(double x) {
    return x + 1;
  }



  // main method
  public static void main(String[] args) {
    List<String> names = new ArrayList<>(List.of("Kelly", "Jenny", "Oscar"));

    // Lambda
    names.forEach(name -> System.out.println(name));
    
    // Method Reference
    names.forEach(System.out::println);

    String name = "John";
    Supplier<Integer> lengthSupplier1 = () -> name.length();
    Supplier<Integer> lengthSupplier2 = name::length;
    System.out.println(lengthSupplier1.get());
    System.out.println(lengthSupplier2.get());

    Comparator<String> compareToIgnoreCase1 = (s1, s2) -> s1.compareToIgnoreCase(s2);
    Comparator<String> compareToIgnoreCase2 = String::compareToIgnoreCase;
    System.out.println(compareToIgnoreCase1.compare("AAA", "BBB"));
    System.out.println(compareToIgnoreCase2.compare("AAA", "BBB"));

    Function<String, Integer> stringToInteger1 = str -> Integer.valueOf(str);
    Function<String, Integer> stringToInteger2 = Integer::valueOf;
    System.out.println(stringToInteger1.apply("9"));
    System.out.println(stringToInteger2.apply("9"));

    BiFunction<Integer, String, Student> createStudentFunction1 = (sid, studentName) -> new Student(sid, studentName);
    BiFunction<Integer, String, Student> createStudentFunction2 = Student::new;
    System.out.println(createStudentFunction1.apply(1, "John"));
    System.out.println(createStudentFunction2.apply(1, "John"));


    // Integer
    List<Integer> integers = new ArrayList<>(
      List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    );
    System.out.println("\n" + integers);

    List<Integer> processedIntegers = integers.stream()
      .map(DemoMethodReference::addOne)
      .toList();
    System.out.println(processedIntegers);


    // Double
    List<Double> doubles = new ArrayList<>(
      List.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)
    );
    System.out.println("\n" + doubles);

    List<Double> processedDoubles = doubles.stream()
      .map(DemoMethodReference::addOne)
      .toList();
    System.out.println(processedDoubles);







  }
}
