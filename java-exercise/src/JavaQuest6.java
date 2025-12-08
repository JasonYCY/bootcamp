public class JavaQuest6 {
  /**
   * Expected output:
   * 0 1 1 2 3 5 8 13 21 ... 
   * 
   */
  public static void main(String[] args) {
    int first = 0, second = 1;
    // for loop to print first 15 numbers in Fibonacci Sequence
    System.out.print(first + " " + second + " ");
    for (int i = 2; i < 15; i++) {
      int nextValue = first + second;
      System.out.print(nextValue + " ");
      int secondBackup = second;
      second = nextValue;
      first = secondBackup;
    }

  }
}