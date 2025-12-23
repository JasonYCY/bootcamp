import java.util.Deque;
import java.util.LinkedList;

public class DemoDeque {
  public static void main(String[] args) {
    // Deque Demo
    Deque<Student> studentQueue = new LinkedList<>(); // 90% scenario use LinkedList for Queue
    studentQueue.offer(new Student("Leo", 50));
    studentQueue.offer(new Student("Sally", 10));
    studentQueue.offer(new Student("Peter", 99));
    System.out.println("Student Queue: " + studentQueue + "\n");
    
    studentQueue.offerLast(new Student("Steve", 55));
    studentQueue.offerFirst(new Student("Oscar", 93));
    System.out.println("Student Queue: " + studentQueue + "\n");



  }
}
