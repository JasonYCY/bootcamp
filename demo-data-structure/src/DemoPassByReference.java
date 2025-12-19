import java.util.ArrayList;

public class DemoPassByReference {
  // Demo pass by value vs pass by reference
  public static int sum(int x, int y) {
    x = 100;
    return x + y;
  }

  public static void addOne(int[] arr) {
    if (arr == null) return;

    for (int i = 0; i < arr.length; i++) {
      arr[i] += 1;
    }
  }

  public static void doubleTheCat(ArrayList<Cat> cats) {
    ArrayList<Cat> doubleCats = new ArrayList<>();
    for (Cat cat : cats) {
      doubleCats.add(cat);
    }
    cats = doubleCats;
  }



  // main method
  public static void main(String[] args) {
    // Pass by value (Primitive, String, All Wrapper Class)
    // int x = 15;
    // System.out.println(sum(10, 3)); // 103
    // System.out.println(sum(x, 6)); // 106
    // System.out.println(x); // 15

    // Pass by reference
    // int[] arr = new int[] {-9, -100, 73};
    // addOne(arr);
    // System.out.println(Arrays.toString(arr));

    ArrayList<Cat> cats = new ArrayList<>();
    cats.add(new Cat("Sue"));
    System.out.println(cats);
    doubleTheCat(cats);
    System.out.println(cats);
  }
}
