import java.util.Objects;

public class Dog extends Animal {
  public Dog() {}

  public Dog(String name, int age) {
    super(name, age);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Dog)) return false;

    Dog dog = (Dog) obj;
    return dog.getName().equals(super.getName())
        && dog.getAge() == super.getAge();
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.getName(), super.getAge());
  }

  @Override
  public String toString() {
    return "Dog(" + super.toString() + ")";
  }
}
