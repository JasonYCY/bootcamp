// import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DemoThread2 {
  public static void main(String[] args) {
    // List<Integer> integers = new ArrayList<>();
    List<Integer> integers = new Vector<>();

    // Loop i from 0 to 99999, add i into ArrayList
    Runnable addIntegers = new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 100_000; i++) {
          integers.add(i);
        }
      }
    };

    // Thread 1 and 2
    Thread thread1 = new Thread(addIntegers, "Thread 1");
    Thread thread2 = new Thread(addIntegers, "Thread 2");

    long before = System.currentTimeMillis();
    try {
      thread1.start();
      thread2.start();
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      System.out.println("Interrupted Exception!");
    }
    long after = System.currentTimeMillis();


    // < 200_000
    System.out.println("Size of integers: " + integers.size());
    System.out.println("Time used: " + (after - before) + "ms");
  }
}
