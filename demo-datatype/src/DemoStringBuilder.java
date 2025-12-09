public class DemoStringBuilder {
  public static void main(String[] args) {
    // String
    long startTime = System.currentTimeMillis();
    String str = "";
    for (int i = 0; i < 10_000; i++) {
      str += "a";
    }
    long endTime = System.currentTimeMillis();
    System.out.println("(Length = " + str.length() + ")");
    System.out.println("(String) Run Time = " + (endTime - startTime) + " ms");
    System.out.println();

    // String Builder
    StringBuilder builder = new StringBuilder();
    startTime = System.currentTimeMillis();
    for (int i = 0; i < 10_000; i++) {
      builder.append("a");
    }
    endTime = System.currentTimeMillis();
    System.out.println("(Length = " + builder.length() + ")");
    System.out.println("(String Builder) Run Time = " + (endTime - startTime) + " ms");
    System.out.println();

    // Other Methods
    builder = new StringBuilder("Other");
    System.out.println(builder.length());
    System.out.println(builder.charAt(0));
    System.out.println(builder.isEmpty());
    System.out.println(builder.indexOf("a"));
    System.out.println(builder.substring(0, 3));
    System.out.println(builder.reverse());
    System.out.println(builder.deleteCharAt(builder.length() - 1));
    System.out.println(builder.insert(1, "i"));
    System.out.println(builder.reverse());



  }
}
