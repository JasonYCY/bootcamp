public class DemoRecursion {
  // iterative
  public static int iterativeSum(int n) {
    int sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += i;
    }
    return sum;
  }

  // recursion
  public static int recursiveSum(int n) {
    if (n <= 1) return 1;
    return n + recursiveSum(n - 1);
  }

  // 100 + 98 + 96 + 94 + ... + 2
  public static int evenSum(int n) {
    if (n < 2) return 0;
    return n + evenSum(n - 2);
  }

  // 3 * 6 * 9 * 12 * ... * n (given n is divisible by 3)
  public static int product(int n) {
    if (n < 3) return 1;
    return n * product(n - 3);
  }

  public static void main(String[] args) {
    // 5 + 4 + 3 + 2 + 1
    // iterative
    System.out.println("For loop sum: " + iterativeSum(5));

    // recursion
    System.out.println("Recursion sum: " + recursiveSum(5));

    // evenSum
    System.out.println("Even sum: " + evenSum(100));

    // product
    System.out.println("Product: " + product(9));




  }
}