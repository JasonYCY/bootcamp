import java.util.Scanner;

public class DemoScanner {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Please input an integer: ");
    int nextInt = scanner.nextInt();

    if (nextInt % 2 == 0) {
      System.out.println("This is an even number!");
    } else {
      System.out.println("This is an odd number!");
    }
    scanner.close();
  }
}
