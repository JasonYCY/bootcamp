import java.util.Arrays;

public class DemoArray2 {
  public static void main(String[] args) {
    /*
     * Array - demo the idea of object reference
     */
    // String name1 = "John";
    // String name2 = "Cathy";
    // String name3 = "Jenny";

    // String[] students = new String[3];
    // students[0] = name1;
    // students[1] = name2;
    // students[2] = name3;

    // name1 = "Leo";
    // System.out.println(students[0]);

    /*
     * Algorithm
     */
    // 1) Swap
    // int a = 10;
    // int b = 20;
    // int temp = a;
    // a = b;
    // b = temp;

    // 2) Find the highest score and the lowest score
    // int[] scores = new int[] {23, 8, 97, 56};
    // int highestScore = scores[0];
    // int lowestScore = scores[0];
    // for (int i = 1; i < scores.length; i++) {
    // if (scores[i] > highestScore) {
    // highestScore = scores[i];
    // }
    // if (scores[i] < lowestScore) {
    // lowestScore = scores[i];
    // }
    // }
    // System.out.println("Array: " + Arrays.toString(scores));
    // System.out.println("Highest score: " + highestScore);
    // System.out.println("Lowest score: " + lowestScore);

    // 3) Move the max value to the tail
    // int[] scores = new int[] {23, 100, 8, 97, 56};
    // System.out.println("Before: " + Arrays.toString(scores));
    // for (int i = 0; i < scores.length - 1; i++) {
    // if (scores[i] > scores[i + 1]) {
    // int temp = scores[i + 1];
    // scores[i + 1] = scores[i];
    // scores[i] = temp;
    // }
    // }
    // System.out.println("After: " + Arrays.toString(scores));

    // 4) Bubble sort
    int[] scores = new int[] {23, 100, 8, 97, 56};
    System.out.println("Before: " + Arrays.toString(scores));
    for (int i = 0; i < scores.length - 1; i++) {
      for (int j = 0; j < scores.length - 1 - i; j++) {
        if (scores[j] > scores[j + 1]) {
          int temp = scores[j + 1];
          scores[j + 1] = scores[j];
          scores[j] = temp;
        }
      }
    }
    System.out.println("After: " + Arrays.toString(scores));



  }
}
