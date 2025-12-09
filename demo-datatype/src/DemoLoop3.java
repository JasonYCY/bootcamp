public class DemoLoop3 {
  public static void main(String[] args) {
    // for loop
    String str1 = "hello";
    for (int i = 0; i < str1.length(); i++) {
      System.out.print(str1.charAt(i) + " ");
    }
    System.out.println();

    // while loop
    String str2 = "goodbye";
    int index = 0;
    while (index < str2.length()) {
      System.out.print(str2.charAt(index) + " ");
      index++;
    }
    System.out.println();

    // for each loop
    String str3 = "world";
    char[] charArr = str3.toCharArray();
    for (char c : charArr) {
      System.out.print(c + " ");
    }
    System.out.println();

    int[] intArr = new int[] {9, 6, 7, 2};
    for (int value : intArr) {
      System.out.print(value + " ");
    }
    System.out.println();

    // do while loop (this loop execute at least once)
    int x = 0;
    do {
      x += 1;
      System.out.print(x + " ");
    } while (x < 10);
    System.out.println();

    // String method split()
    String email = "Dear Sir, I am writing to you";
    String[] words = email.split(" ");
    for (String word : words) {
      System.out.print(word + "_");
    }
    System.out.println();




  }
}
