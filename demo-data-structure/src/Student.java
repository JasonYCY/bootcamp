import java.util.Objects;

public class Student {
  private String name;
  private int score;

  public Student(String name, int score) {
    this.name = name;
    this.score = score;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setScore(int score) {
    this.score = score;
  }

  @Override
  public String toString() {
    return "{name=" + name + ", score=" + score + "}";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof Student)) return false;

    Student student = (Student) obj;
    return name.equals(student.getName()) && score == student.getScore();
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, score);
  }
}
