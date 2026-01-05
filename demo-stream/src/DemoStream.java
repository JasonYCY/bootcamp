import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DemoStream {
  public static void main(String[] args) {
    // 66, 40, 30, 20
    List<Person> persons = new ArrayList<>(
      Arrays.asList(
        new Person(66),
        new Person(40),
        new Person(30),
        new Person(20)
      )
    );

    // Find a list of Elderly (return a new list)
    List<Person> elderly = new ArrayList<>();
    for (Person person : persons) {
      if (person.isElderly()) {
        elderly.add(person);
      }
    }
    System.out.println(elderly);

    // Stream
    List<Person> elderlyList = persons.stream()
      .filter(Person::isElderly)
      .toList();
    System.out.println(elderlyList);

    // John 10, Sally 3, Leo 8, Steven 5
    List<Cat> cats = new ArrayList<>(
      List.of(
        Cat.builder().name("John").age(10).build(),
        Cat.builder().name("Sally").age(3).build(),
        Cat.builder().name("Leo").age(8).build(),
        Cat.builder().name("Steven").age(5).build()
      )
    );

    // Find a new list of cat, whose age > 4 and the name has char 'n'
    List<Cat> catList = cats.stream()
      .filter(cat -> cat.getAge() > 4 && cat.getName().indexOf("n") != -1)
      .collect(Collectors.toList());
    System.out.println(catList);

    // Ball
    // RED 10, BLUE 3, RED 12, YELLOW 8, BLUE 4
    List<Ball> balls = new ArrayList<>(
      List.of(
        new Ball(Ball.Color.RED, 10),
        new Ball(Ball.Color.BLUE, 3),
        new Ball(Ball.Color.RED, 12),
        new Ball(Ball.Color.YELLOW, 8),
        new Ball(Ball.Color.BLUE, 4)
      )
    );
    
    // Find all blue and yellow balls
    List<Ball> targetBalls = balls.stream()
      .filter(ball -> ball.getColor() == Ball.Color.BLUE || ball.getColor() == Ball.Color.YELLOW)
      .collect(Collectors.toList());
    System.out.println(targetBalls);

    // Find all blue and yellow balls, then return the numbers of the balls
    List<Integer> targetIntegers = balls.stream()
      .filter(ball -> ball.getColor() == Ball.Color.BLUE || ball.getColor() == Ball.Color.YELLOW)
      .map(Ball::getNum)
      .collect(Collectors.toList());
    System.out.println(targetIntegers);






  }
}