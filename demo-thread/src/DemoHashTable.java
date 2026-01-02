import java.util.Map;
// import java.util.HashMap;
import java.util.Hashtable;

public class DemoHashTable {
  public static void main(String[] args) {
    // HashTable vs HashMap
    // Map<Integer, String> map = new HashMap<>();
    Map<Integer, String> map = new Hashtable<>();


    // Task
    Runnable addInteger1 = new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 100_000; i++) {
          map.put(i, String.valueOf(i));
          
        }
      }
    };

    Runnable addInteger2 = new Runnable() {
      @Override
      public void run() {
        for (int i = 100_000; i < 200_000; i++) {
          map.put(i, String.valueOf(i));
          
        }
      }
    };

    Thread thread1 = new Thread(addInteger1);
    Thread thread2 = new Thread(addInteger2);

    try {
      thread1.start();
      thread2.start();
      thread1.join();
      thread2.join();
    } catch (Exception e) {}

    System.out.println("Map Size: " + map.size());





    
  }
}
