// import java.util.Deque;
// import java.util.LinkedList;
import java.util.Stack;

public class DemoStack {
  public static void main(String[] args) {
    // Stack
    Stack<String> names = new Stack<>();
    names.push("John");
    names.push("Leo");
    names.push("Sally");
    
    // Last In First Out (LIFO)
    System.out.println(names.pop()); // Sally
    System.out.println(names.pop()); // Leo
    System.out.println(names.pop()); // John

    // Declaration
    // Deque<Integer> queue = new LinkedList<>();
    Stack<Integer> queue = new Stack<>();

    // Runnable
    Runnable addIntegers = new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 100_000; i++) {
          queue.add(i);
        }
      }
    };

    // Thread 1 & Thread 2
    Thread thread1 = new Thread(addIntegers, "Thread-1");
    Thread thread2 = new Thread(addIntegers, "Thread-2");

    // Start Thread 1 & Thread 2
    try {
      thread1.start();
      thread2.start();
      thread1.join();
      thread2.join();
    } catch (Exception e) {
      System.out.println("Exception!");
    }

    // Print final size
    System.out.println(queue.size());
    








  }
}
