import java.util.Optional;

public class DemoOptional {
  // Optional is just for method return type
  public static Optional<Integer> searchIndex(int[] numberList, int target) {
    if (numberList == null) throw new IllegalArgumentException("numberList should not be null");

    for (int i = 0; i < numberList.length; i++) {
      if (numberList[i] == target) return Optional.of(i);
    }
    return Optional.empty();
  }


  // Incorrect way to use Optional
  public static Optional<Integer> incorrectMethod(Optional<int[]> numberList, int target) {
    if (numberList == null || !numberList.isPresent()) {
      throw new IllegalArgumentException("numberList should not be null");
    } else {
      int[] numbers = numberList.get();
      for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] == target) return Optional.of(i);
      }
    }
    return Optional.empty();
  }



  // main method
  public static void main(String[] args) {
    // Optional is like a wrapper
    Optional<Integer> integerBox1 = Optional.of(10);
    if (integerBox1.isPresent()) {
      System.out.println("integerBox1 is " + integerBox1.get());
    }

    Optional<Integer> integerBox2 = Optional.ofNullable(null);
    if (!integerBox2.isPresent()) {
      System.out.println("integerBox2 is null");
    }

    // The only correct way to use Optional
    Optional<Integer> index = searchIndex(new int[]{10, 9, 4, 3, 5}, 7);
    if (index.isPresent()) {
      System.out.println("Method call: index found: " + index.get());
    } else {
      System.out.println("Method call: index not found");
    }
    
    // ifPresent() Lambda
    integerBox1.ifPresent(e -> System.out.println("Print with lambda: " + e));

    // orElse()
    int result = integerBox1.orElse(-1);
    System.out.println("orElse: " + result);
    
    // orElseGet() <- takes in Supplier
    result = integerBox1.orElseGet(() -> -1);
    System.out.println("orElseGet: " + result);

    // orElseThrow() <- no input (default exception)
    result = integerBox1.orElseThrow();
    System.out.println("orElseThrow: " + result);

    // orElseThrow() <- takes in Supplier (throw custom exception)
    result = integerBox1.orElseThrow(() -> new RuntimeException("NOT FOUND!!!"));
    System.out.println("orElseThrow: " + result);
    
    // Incorrect way to use Optional
    Optional<Integer> index2 = incorrectMethod(Optional.ofNullable(new int[]{10, 9, 4, 3, 5}), 9);
    System.out.println("Test: " + index2);





  }
}
