public class DemoOperator {
  public static void main(String[] args) {
    // Operator
    int x = 3;

    // four ways to add 1
    x = x + 1;
    x += 1;
    x++;
    ++x;
    System.out.println(x); // x = 7

    // four ways to minus 1
    x = x - 1;
    x -= 1;
    x--;
    --x;
    System.out.println(x); // x = 3

    // two ways to add 2
    x = x + 2;
    x += 2;
    System.out.println(x); // x = 7

    // difference between x++ and ++x
    int temp = 1;
    System.out.println("temp = 1");
    System.out.println("System.out temp++: " + temp++);
    temp = 1;
    System.out.println("temp = 1");
    System.out.println("System.out ++temp: " + ++temp);

    // question: h++ * 2 * ++h
    int h;
    System.out.println("h: " + (h = 14));
    System.out.println("h++ * 2 * ++h = " + (h++ * 2 * ++h));
    System.out.println("14 * 2 * 16 = " + (14 * 2 * 16));

    // operator !
    int age = 66;
    boolean isElderly = age > 65;
    if (!isElderly) {
      System.out.println("not an elderly");
    } else {
      System.out.println("is an elderly");
    }

    // true && false
    int e = 5;
    System.out.println(e > 3 && e < 10);
    System.out.println(e > 3 || e > 20);
    System.out.println(false || true);
    System.out.println(true && false);
    System.out.println(true && false || true);
    System.out.println(false || true && true);
  }
}
