import java.util.List;
import java.util.Optional;

public class DemoOptional2 {
  private static List<String> fruitDatabase = List.of("apple", "banana", "kiwi", "watermelon", "orange");

  public static List<String> getFruitDatabase() {
    return fruitDatabase;
  }

  // searchFruit -> return Optional
  public static Optional<Integer> searchFruitIndex(List<String> fruits, String target) {
    if (fruits == null) throw new IllegalArgumentException("fruits cannot be null");
    if (target == null) throw new IllegalArgumentException("target cannot be null");
    
    int index = fruits.indexOf(target);
    return (index != -1) ? Optional.of(index) : Optional.empty();
  }

  public static Optional<String> findFirstFruit(char targetChar) {
    return fruitDatabase.stream()
      .filter(fruit -> fruit.contains(String.valueOf(targetChar)))
      .findFirst();
  }



  // main method
  public static void main(String[] args) {
    // Usage
    List<String> fruits = getFruitDatabase();
    System.out.println(fruits);
    findFirstFruit('n').ifPresent(System.out::println);






  }
}
