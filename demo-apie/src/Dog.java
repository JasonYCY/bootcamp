public class Dog extends Animal {
  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Dog)) return false;

    Dog dog = (Dog) obj;
    return dog.getName().equals(super.getName())
        && dog.getAge() == super.getAge();
  }
}
