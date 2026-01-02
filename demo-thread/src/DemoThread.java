import java.util.concurrent.atomic.AtomicInteger;

public class DemoThread {
  // private int x;
  private AtomicInteger x = new AtomicInteger(0);

  // public int getX() {
  //   return x;
  // }

  public int getX() {
    return x.get();
  }

  // public synchronized void addOne() {
  //   x++;
  // }

  public void addOne() {
    x.getAndIncrement();
  }





  // main method
  public static void main(String[] args) {
    DemoThread box = new DemoThread();
    System.out.println("Initial value of X: " + box.getX());

    Runnable addOneTask = new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 100_000; i++) {
          box.addOne();
        }
        System.out.println(Thread.currentThread().getName() + ": " + box.getX());
      }
    };

    Thread thread1 = new Thread(addOneTask, "Thread-1");
    Thread thread2 = new Thread(addOneTask, "Thread-2");
    thread1.start();
    thread2.start();

    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Main Thread: " + box.getX());











  }
}
