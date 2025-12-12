import java.util.Arrays;

public class Teacher {
  private String name;
  private Candy[] candies;

  public Teacher(String name) {
    this.name = name;
    candies = new Candy[0];
  }

  public void buy(Candy candy) {
    System.out.println("Teacher " + name + " is buying a candy of color " + candy.getColor());
    Candy[] newCandies = new Candy[candies.length + 1];
    for (int i = 0; i < candies.length; i++) {
      newCandies[i] = candies[i];
    }
    newCandies[newCandies.length - 1] = candy;
    candies = newCandies;
  }

  public boolean distributeCandyTo(Student student) {
    if (candies.length <= 0) {
      System.out.println("Teacher " + name + " has no candy left! Can't distribute more candies!");
      return false;
    }
    System.out.println("Teacher " + name + " is distributing a candy to Student " + student.getName());
    Candy[] newCandies = new Candy[candies.length - 1];
    for (int i = 0; i < newCandies.length; i++) {
      newCandies[i] = candies[i];
    }
    student.receiveCandy(candies[candies.length - 1]);
    candies = newCandies;
    return true;
  }

  public void remainingCandies() {
    System.out.println("Teacher " + name + " has " + candies.length + " candies left");
  }

  public void showCandies() {
    System.out.println("Teacher " + name + "'s candies list: " + Arrays.toString(candies));
  }

  public Candy[] getCandies() {
    return candies;
  }

  public String getName() {
    return name;
  }

  // A Teacher has 22 candies
  // 5 students
  // main: distribute all candies to all students
  // finally, teacher has no candies
  // show all candies for each student
  public static void main(String[] args) {
    // Create Teacher
    Teacher john = new Teacher("John");
    
    // Create 5 Student
    String[] names = {"Peter", "Sarah", "Michael", "Emily", "David"};
    Student[] students = new Student[5];
    for (int i = 0; i < 5; i++) {
      students[i] = new Student(names[i]);
    }

    // Teacher buy 22 candies
    String[] colors = {"RED", "YELLOW", "BLUE"};
    for (int i = 0; i < 22; i++) {
      System.out.print(((i + 1 < 10) ? " " : "") + (i + 1) + ") ");
      String color = colors[i % colors.length];  // Cycles: RED, YELLOW, BLUE, RED...
      john.buy(Candy.ofColor(color));
    }
    System.out.println();
    john.showCandies();
    john.remainingCandies();
    System.out.println();

    // Teacher distributing candies to all students until he ran out of candies
    int studentID = 0;
    int count = 1;
    System.out.println("(Round " + count++ + ")");
    boolean teacherHasCandies = john.distributeCandyTo(students[studentID]);
    System.out.println();
    while (teacherHasCandies) {
      System.out.println("(Round " + count++ + ")");
      studentID = (studentID + 1) % students.length; // move on to the next student
      teacherHasCandies = john.distributeCandyTo(students[studentID]);
      System.out.println();
    }
    System.out.println();
    john.remainingCandies();
    john.showCandies();
    System.out.println();

    // Display candies for each students
    for (Student student : students) {
      student.remainingCandies();
      student.showCandies();
      System.out.println();
    }




  }
}
