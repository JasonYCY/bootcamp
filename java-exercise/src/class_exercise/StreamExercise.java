package class_exercise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamExercise {
  // Student Declaration (For question 7)
  public static class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
      this.name = name;
      this.score = score;
    }

    public String getName() {
      return name;
    }

    public int getScore() {
      return score;
    }
  }


  // Employee Declaration (For question 8)
  public static class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
      this.name = name;
      this.salary = salary;
    }

    public String getName() {
      return name;
    }

    public int getSalary() {
      return salary;
    }
  }


  // Person Declaration (For question 9)
  public static class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
      this.name = name;
      this.age = age;
    }

    public String getName() {
      return name;
    }

    public int getAge() {
      return age;
    }

    @Override
    public String toString() {
      return "Person(name=" + name + ", age=" + age + ")";
    }
  }


  // Gender Declaration (For question 10)
  public enum Gender {
    Male,
    Female
  }
  // Staff Declaration (For question 10)
  public static class Staff {
    private String name;
    private Gender gender;
    
    public Staff(String name, Gender gender) {
      this.name = name;
      this.gender = gender;
    }

    public String getName() {
      return name;
    }

    public Gender getGender() {
      return gender;
    }
  }


  // Product Declaration (For question 15)
  public static class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
      this.name = name;
      this.price = price;
    }

    public String getName() {
      return name;
    }

    public int getPrice() {
      return price;
    }
  }


  // Worker Declaration (For question 16)
  public static class Worker {
    private String name;
    private String department;
    
    public Worker(String name, String department) {
      this.name = name;
      this.department = department;
    }

    public String getName() {
      return name;
    }

    public String getDepartment() {
      return department;
    }
  }


  // Children Declaration (For question 20)
  public static class Children {
    private String name;
    private int score;
    
    public Children(String name, int score) {
      this.name = name;
      this.score = score;
    }

    public String getName() {
      return name;
    }

    public int getScore() {
      return score;
    }
  }



  // main method
  public static void main(String[] args) {
    // 1. Basic Stream Operations
    // Task: Given a list of integers, use a stream to find all the even numbers, square them, and then
    // sort the result in descending order.
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    // Output: [100, 64, 36, 16, 4]
    System.out.println("=".repeat(100));
    System.out.println("1. Basic Stream Operations");
    List<Integer> basicStreamOperation = numbers.stream()
      .filter(number -> number % 2 == 0)
      .map(number -> number * number)
      .sorted(Comparator.reverseOrder())
      .toList();
    System.out.println(basicStreamOperation);


    // 2. Filtering and Collecting
    // Task: Given a list of names, filter the names that start with "A" and collect them into a list.
    List<String> names =
        Arrays.asList("Alice", "Bob", "Annie", "David", "Alex");
    // Output: [Alice, Annie, Alex]
    System.out.println("=".repeat(100));
    System.out.println("2. Filtering and Collecting");
    List<String> filteringAndCollecting = names.stream()
      .filter(name -> name.startsWith("A"))
      .toList();
    System.out.println(filteringAndCollecting);


    // 3. Finding Maximum and Minimum
    // Task: Given a list of integers, find the maximum and minimum values using Streams.
    List<Integer> numbers2 = Arrays.asList(10, 20, 5, 30, 15);
    // Output: Max: 30
    // Output: Min: 5
    System.out.println("=".repeat(100));
    System.out.println("3. Finding Maximum and Minimum");
    Optional<Integer> max = numbers2.stream().max(Comparator.naturalOrder());
    Optional<Integer> min = numbers2.stream().min(Comparator.naturalOrder());
    if (max.isPresent()) {
      System.out.println("Max: " + max.get());
    } else {
      System.out.println("Max not found!");
    }
    if (min.isPresent()) {
      System.out.println("Min: " + min.get());
    } else {
      System.out.println("Min not found!");
    }
    

    // 4. Mapping to a List of Lengths
    // Task: Given a list of strings, map each string to its length and collect the lengths into a
    // List<Integer>
    List<String> words = Arrays.asList("apple", "banana", "pear");
    // Output: [5, 6, 4] (List)
    System.out.println("=".repeat(100));
    System.out.println("4. Mapping to a List of Lengths");
    List<Integer> listOfLength = words.stream()
      .map(String::length)
      .toList();
    System.out.println(listOfLength);


    // 5. Counting Elements
    // Task: Given a list of strings, count how many strings have a length greater than 3.
    List<String> words2 = Arrays.asList("hi", "hello", "world", "java", "stream");
    // Output: 4
    System.out.println("=".repeat(100));
    System.out.println("5. Counting Elements");
    long countGreaterThanThree = words2.stream()
      .filter(word -> word.length() > 3)
      .count();
    System.out.println(countGreaterThanThree);


    // 6. Filtering and Collecting to a Set
    // Task: Given a list of numbers, filter out all numbers greater than 10 and collect them into a Set.
    //                                     ^ this should be keep instead of filter out
    List<Integer> numbers3 = Arrays.asList(5, 10, 15, 20, 10, 5);
    // Output: [15, 20]
    System.out.println("=".repeat(100));
    System.out.println("6. Filtering and Collecting to a Set");
    Set<Integer> setGreaterThanThree = numbers3.stream()
      .filter(number -> number > 10)
      .collect(Collectors.toSet());
    System.out.println(setGreaterThanThree);


    // 7. Mapping to a Map (Key-Value Pairs)
    // Task: Given a list of students with their names and scores, map them to a Map<String, Integer>,
    // where the key is the student's name and the value is their score.

    // Create Student Class
    // new Student("Alice", 85)
    // new Student("Bob", 75)

    // Output: {Alice=85, Bob=75}
    System.out.println("=".repeat(100));
    System.out.println("7. Mapping to a Map (Key-Value Pairs)");
    List<Student> students = new ArrayList<>(
      List.of(
        new Student("Alice", 85),
        new Student("Bob", 75)
      )
    );
    Map<String, Integer> studentNameAndScoreMap = students.stream()
      .collect(Collectors.toMap(Student::getName, Student::getScore));
    System.out.println(studentNameAndScoreMap);


    // 8. Filtering and Mapping to a List of Objects
    // Task: Given a list of Employee objects, filter out employees with a salary less than 50,000 and
    // map them to a list of their names.

    // Create Employee Class
    // new Employee("John", 65000)
    // new Employee("Jane", 55000)
    // new Employee("Doe", 40000)

    // Output: [John, Jane]
    System.out.println("=".repeat(100));
    System.out.println("8. Filtering and Mapping to a List of Objects");
    List<Employee> employees = new ArrayList<>(
      List.of(
        new Employee("John", 65000),
        new Employee("Jane", 55000),
        new Employee("Doe", 40000)
      )
    );
    List<String> employeeNames = employees.stream()
      .filter(employee -> employee.getSalary() > 50000)
      .map(Employee::getName)
      .toList();
    System.out.println(employeeNames);


    // 9. Grouping and Collecting to a Map (Group by Age)
    // Task: Given a list of people with their names and ages, group them by age and collect the result
    // into a Map<Integer, List<String>> where the key is the age and the value is a list of names.

    // Create Person Class
    // new Person("Alice", 30),
    // new Person("Bob", 25),
    // new Person("Charlie", 30)

    // Output: {30=[Alice, Charlie], 25=[Bob]} (Map)
    System.out.println("=".repeat(100));
    System.out.println("9. Grouping and Collecting to a Map (Group by Age)");
    List<Person> people = new ArrayList<>(
      List.of(
        new Person("Alice", 30),
        new Person("Bob", 25),
        new Person("Charlie", 30)
      )
    );
    Map<Integer, List<String>> groupByAgeMap = people.stream()
      .collect(Collectors.groupingBy(
        Person::getAge,
        Collectors.mapping(
          Person::getName,
          Collectors.toList()
        )
      ));
    System.out.println(groupByAgeMap);


    // 10. Partitioning and Collecting to a Map (Partition by Gender)
    // Task: Given a list of Staff with their names and genders, partition them into two groups: male
    // and female, and collect the result into a Map<Boolean, List<Person>>.
    //                                             ^ this should be: Map<Boolean, List<String>>

    // Create Staff Class
    // new Staff("Alice", Gender.Female)
    // new Staff("Bob", Gender.Male)
    // new Staff("Charlie", Gender.Male)

    // Output: {false=[Alice], true=[Bob, Charlie]} (Map)
    System.out.println("=".repeat(100));
    System.out.println("10. Partitioning and Collecting to a Map (Partition by Gender)");
    List<Staff> staffs = new ArrayList<>(
      List.of(
        new Staff("Alice", Gender.Female),
        new Staff("Bob", Gender.Male),
        new Staff("Charlie", Gender.Male)
      )
    );
    Map<Boolean, List<String>> isMaleToPersonListMap = staffs.stream()
      .collect(Collectors.groupingBy(
        staff -> staff.getGender() == Gender.Male,
        Collectors.mapping(
          Staff::getName,
          Collectors.toList()
        )
      ));
    System.out.println(isMaleToPersonListMap);


    // 11. Filtering, Mapping, and Collecting to a List
    // Task: Given a list of integers, filter out numbers less than 10, multiply the remaining numbers
    // by 2, and collect the result into a List.

    List<Integer> numbers4 = Arrays.asList(5, 15, 20, 7, 30);
    // Output: [30, 40, 60]
    System.out.println("=".repeat(100));
    System.out.println("11. Filtering, Mapping, and Collecting to a List");
    List<Integer> filterLessThan10ThenMultiplyBy2 = numbers4.stream()
      .filter(number -> number >= 10)
      .map(number -> number * 2)
      .toList();
    System.out.println(filterLessThan10ThenMultiplyBy2);


    // 12. Mapping to a Custom Object and Collecting to a List
    // Task: Given a list of names and a constant default value, map each name to a Person object (name
    // and default value for age) and collect the result into a list.

    List<String> names2 = Arrays.asList("Alice", "Bob", "Charlie");
    int defaultAge = 30;
    // Output: [Person(name=Alice, age=30), Person(name=Bob, age=30), Person(name=Charlie, age=30)]
    System.out.println("=".repeat(100));
    System.out.println("12. Mapping to a Custom Object and Collecting to a List");
    List<Person> personList = names2.stream()
      .map(name -> new Person(name, defaultAge))
      .toList();
    System.out.println(personList);


    // 13. Mapping and Collecting to a Deque
    // Task: Given a list of words, map each word to its uppercase form and collect the result into a
    // Deque.

    List<String> words3 = Arrays.asList("hello", "world", "java");
    // Output: [HELLO, WORLD, JAVA] (Deque)
    System.out.println("=".repeat(100));
    System.out.println("13. Mapping and Collecting to a Deque");
    Deque<String> wordDeque = words3.stream()
      .map(String::toUpperCase)
      .collect(Collectors.toCollection(ArrayDeque::new));
    System.out.println(wordDeque);


    // 14. Transforming and Collecting to an Array
    // Task: Given a list of integers, square each number and collect the result into an array.

    List<Integer> numbers5 = Arrays.asList(1, 2, 3, 4);
    // Output: [1, 4, 9, 16]
    System.out.println("=".repeat(100));
    System.out.println("14. Transforming and Collecting to an Array");
    int[] arr = numbers5.stream()
      .mapToInt(number -> number * number)
      .toArray();
    System.out.println(Arrays.toString(arr));


    // 15. Map and Reduce
    // Task: Given a list of products with their prices, use the map and reduce methods to calculate the
    // total price of all products.

    // Create Product Class
    // new Product("Book", 10)
    // new Product("Pen", 5)
    // new Product("Notebook", 7)

    // Output: 22
    System.out.println("=".repeat(100));
    System.out.println("15. Map and Reduce");
    List<Product> products = new ArrayList<>(
      List.of(
        new Product("Book", 10),
        new Product("Pen", 5),
        new Product("Notebook", 7)
      )
    );
    int totalPrice = products.stream()
      .map(Product::getPrice)
      .reduce(0, (acc, cur) -> (acc + cur));
    System.out.println(totalPrice);


    // 16. Grouping
    // Task: Given a list of employees with their department names, use groupingBy method to group the
    // employees by department.

    // Create Worker Class
    // new Worker("Alice", "HR")
    // new Worker("Bob", "IT")
    // new Worker("Charlie", "HR")
    // new Worker("David", "IT")

    // Output: {HR=[Alice, Charlie], IT=[Bob, David]}
    System.out.println("=".repeat(100));
    System.out.println("16. Grouping");
    List<Worker> workers = new ArrayList<>(
      List.of(
        new Worker("Alice", "HR"),
        new Worker("Bob", "IT"),
        new Worker("Charlie", "HR"),
        new Worker("David", "IT")
      )
    );
    Map<String, List<String>> groupByDepartment = workers.stream()
      .collect(Collectors.groupingBy(
        Worker::getDepartment,
        Collectors.mapping(
          Worker::getName,
          Collectors.toList()
        )
      ));
    System.out.println(groupByDepartment);


    // 17. Parallel Streams
    // Task: Given a list of numbers, use a parallel stream to calculate the sum of all elements.
    List<Integer> numbers6 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    // Output: 55
    System.out.println("=".repeat(100));
    System.out.println("17. Parallel Streams");
    int sum = numbers6.parallelStream()
      .mapToInt(Integer::intValue)
      .sum();
    System.out.println(sum);


    // 18. FlatMap
    // Task: Given a list of lists of numbers, flatten them into a single list and filter only the
    // numbers greater than 5.

    List<List<Integer>> listOfIntegers = Arrays.asList( //
        Arrays.asList(1, 2, 3), //
        Arrays.asList(4, 5, 6), //
        Arrays.asList(7, 8, 9) //
    );
    // Output: [6, 7, 8, 9]
    System.out.println("=".repeat(100));
    System.out.println("18. FlatMap");
    List<Integer> flattenList = listOfIntegers.stream()
      .flatMap(List::stream)
      .filter(number -> number > 5)
      .toList();
    System.out.println(flattenList);


    // 19. Distinct and Sorting
    // Task: Given a list of strings with some duplicates, remove the duplicates and return the result
    // in alphabetical order.

    List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape");
    // Output: [apple, banana, grape, orange]
    System.out.println("=".repeat(100));
    System.out.println("19. Distinct and Sorting");
    List<String> distinctSortedFruits = fruits.stream()
      .distinct()
      .sorted()
      .toList();
    System.out.println(distinctSortedFruits);
    

    // 20. Partitioning By
    // Task: Given a list of Children with their scores, partition the Children into passing and failing
    // groups (pass if score >= 50).
    // Create Children first.
    
    // Create Children Class
    // new Children("Alice", 45)
    // new Children("Bob", 55)
    // new Children("Charlie", 40)
    // new Children("David", 70)
    
    // Output: {false=[Alice, Charlie], true=[Bob, David]}
    System.out.println("=".repeat(100));
    System.out.println("20. Partitioning By");
    List<Children> children = new ArrayList<>(
      List.of(
        new Children("Alice", 45),
        new Children("Bob", 55),
        new Children("Charlie", 40),
        new Children("David", 70)
      )
    );
    Map<Boolean, List<String>> partitioningByPassFailMap = children.stream()
      .collect(Collectors.partitioningBy(
        child -> child.getScore() >= 50,
        Collectors.mapping(
          Children::getName,
          Collectors.toList()
        )
      ));
    System.out.println(partitioningByPassFailMap);


    // 21. Joining Strings
    // Task: Given a list of words, join them into a single string separated by commas.
    
    List<String> languages = Arrays.asList("Java", "Python", "Rust", "R", "Go");
    // Output: "Java, Python, Rust, R, Go"
    System.out.println("=".repeat(100));
    System.out.println("21. Joining Strings");
    String concatenatedString = languages.stream()
      .collect(Collectors.joining(", "));
    System.out.println(concatenatedString);


    // 22. Find First and Any
    // Task: Given a list of integers, find the first number that is divisible by 3.
    List<Integer> ages = Arrays.asList(4, 7, 9, 12, 16, 21);
    
    // Output: 9
    System.out.println("=".repeat(100));
    System.out.println("22. Find First and Any");
    Optional<Integer> firstNumberDivisibleBy3 = ages.stream()
      .filter(age -> age % 3 == 0)
      .findFirst();
    System.out.println(firstNumberDivisibleBy3.orElse(-1));


    // 23. Limit and Skip
    // Task: Given a list of numbers, skip the first 3 elements and return the next 5 elements.
    
    List<Integer> elements = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    // Output: [4, 5, 6, 7, 8]
    System.out.println("=".repeat(100));
    System.out.println("23. Limit and Skip");
    List<Integer> limitAndSkip = elements.stream()
      .skip(3)
      .limit(5)
      .toList();
    System.out.println(limitAndSkip);
    

    // 24. Peek
    // Task: Given a list of integers, double each element and use the peek method to log the
    // intermediate results to the console.
    
    List<Integer> amounts = Arrays.asList(1, 2, 3, 4);
    // Intermediate output: 2, 4, 6, 8
    // Final Output: [2, 4, 6, 8]
    System.out.println("=".repeat(100));
    System.out.println("24. Peek");
    List<Integer> doubleAmounts = amounts.stream()
      .map(amount -> amount * 2)
      .peek(amount -> System.out.println("Intermediate amount: " + amount))
      .toList();
    System.out.println(doubleAmounts);


    // 25. Optional and Streams
    // Task: Given a list of strings, use Streams to find the first string longer than 4 characters.
    // Handle the case where no such string exists using Optional.
    
    List<String> animals = Arrays.asList("cat", "tiger", "panda", "dog");
    // Output: Optional[tiger]
    System.out.println("=".repeat(100));
    System.out.println("25. Optional and Streams");
    Optional<String> firstStringLongerThanFourChar = animals.stream()
      .filter(str -> str.length() > 4)
      .findFirst();
    System.out.println(firstStringLongerThanFourChar);
    
    List<String> animals2 = Arrays.asList("cat", "dog", "bird");
    // Output: Optional.empty
    firstStringLongerThanFourChar = animals2.stream()
      .filter(str -> str.length() > 4)
      .findFirst();
    System.out.println(firstStringLongerThanFourChar);


    // 26. Custom Collector
    // Task: Create a custom collector that collects the elements of a stream and remove all duplicates
    
    List<Integer> duplicates = Arrays.asList(2, 1, 2, 3, 4, 3, 5, 5, 6);
    // Output: [1, 2, 3, 4, 5, 6] (Set)
    System.out.println("=".repeat(100));
    System.out.println("26. Custom Collector");
    Set<Integer> uniqueSet = duplicates.stream()
      .collect(Collector.of(
        TreeSet::new,
        Set::add,
        (set1, set2) -> {
          set1.addAll(set2);
          return set1;
        },
        Collector.Characteristics.UNORDERED,
        Collector.Characteristics.IDENTITY_FINISH
      ));
    System.out.println(uniqueSet);


    // 27. String Length Calculation
    // Task: Given a list of strings, calculate the total number of characters in all the strings
    // combined.
    
    List<String> keywords = Arrays.asList("stream", "filter", "map", "sorted", "collect");
    // Output: 28
    System.out.println("=".repeat(100));
    System.out.println("27. String Length Calculation");
    int test = keywords.stream()
      .mapToInt(String::length)
      .sum();
    System.out.println(test);
  }
}
