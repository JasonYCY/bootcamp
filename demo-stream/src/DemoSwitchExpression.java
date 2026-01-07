public class DemoSwitchExpression {
  public enum Weekday {
    MON,
    TUE,
    WED,
    THU,
    FRI,
    SAT,
    SUN;
  }



  // main method
  public static void main(String[] args) {
    // Traditional switch case
    // 1) need to write break repeatedly
    // 2) no range checking


    // Switch expression (Java 14)
    Weekday today = Weekday.WED;

    switch(today) {
      case MON -> System.out.println("Today is Monday");
      case TUE -> System.out.println("Today is Tuesday");
      case WED -> System.out.println("Today is Wednesday");
      case THU -> System.out.println("Today is Thursday");
      case FRI -> System.out.println("Today is Friday");
      case SAT -> System.out.println("Today is Saturday");
      case SUN -> System.out.println("Today is Sunday");
    }

    String dayType = switch (today) {
      case MON, TUE, WED, THU, FRI -> "Weekday";
      case SAT, SUN -> "Weekend";
      default -> {
        System.out.println("Processing unknown day...");
        yield "Invalid"; // Using yield for multi-line logic
      }
    };
    System.out.println(dayType);



    // Modern Enhancements (Java 21+)
    Object obj = "String";

    // Pattern Matching for Types
    switch (obj) {
      case String s  -> System.out.println("It's a String of length: " + s.length());
      case Integer i -> System.out.println("It's an Integer: " + i);
      case Double d  -> System.out.println("It's a Double: " + d);
      default        -> System.out.println("Unknown type");
    }

    // The 'when' Clause (Guarded Patterns)
    String status = switch (obj) {
      case String s when s.equalsIgnoreCase("YES") -> "User agreed";
      case String s when s.length() > 100          -> "This is a very long text";
      case String s                                -> "Just a normal string";
      default                                      -> "Not a string";
    };
    System.out.println("Status: " + status);
    
    // Direct Null Handling
    String input = null;
    switch (input) {
      case null     -> System.out.println("Received nothing!");
      case "Hello"  -> System.out.println("Hi there!");
      default       -> System.out.println("Something else");
    }

    // Record Patterns (Deconstruction)
    record Point(int x, int y) {}
    Point point = new Point(10, 10);
    switch (point) {
      // It "unpacks" the Point record automatically
      case Point(int x, int y) when x == y -> 
        System.out.println("Point is on a diagonal at " + x);
        
      case Point(int x, int y) -> 
        System.out.println("Just a point at " + x + ", " + y);
        
      default -> System.out.println("Not a point");
    }
    








  }
}
