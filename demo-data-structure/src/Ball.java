import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Ball implements Comparable<Ball> {
  private Color color;

  public Ball(Color color) {
    this.color = color;
  }

  public Color getColor() {
    return color;
  }

  @Override
  public int compareTo(Ball ball) {
    return this.color.ordinal() - ball.color.ordinal();
  }

  @Override
  public String toString() {
    return "Ball{color=" + color + "}";
  }

  public enum Color {
    RED,
    BLUE,
    YELLOW,
  }










  // main method
  public static void main(String[] args) {
    // Arrays.sort()
    int[] arr = new int[]{3, -9, 10, 8, 5, 1, 7, 13, 2, -21};
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));

    // Collections.sort()
    ArrayList<Ball> balls = new ArrayList<>(Arrays.asList(new Ball(Color.YELLOW), new Ball(Color.RED), new Ball(Color.BLUE)));
    System.out.println(balls);
    Collections.sort(balls); // compiler knows this class has compareTo() because of the Comparable interface
    System.out.println(balls);
    









  }
}
