public class Dog {
  private String name;
  private Dog nextDog;

  public Dog(String name) {
    this.name = name;
  }

  public void setNextDog(Dog nextDog) {
    this.nextDog = nextDog;
  }

  public void printDogs() {
    System.out.print(this + " -> ");
    Dog current = nextDog;
    while (current != null) {
      System.out.print(current + " -> ");
      current = current.next();
    }
    System.out.println("null");
  }

  public Dog getLastDog() {
    if (nextDog == null) return null;

    Dog current = nextDog;
    while (current.next() != null) {
      current = current.next();
    }
    return current;
  }

  public void removeLastDog() {
    // assume the object calling this method is the HEAD
    if (nextDog == null) return;

    Dog prev = null;
    Dog current = nextDog;
    while (current.next() != null) {
      prev = current;
      current = current.next();
    }

    if (prev == null) {
      nextDog = null;
    } else {
      prev.setNextDog(null);
    }
  }

  public void removeTargetDog(Dog target) {
    // assume the object calling this method is the HEAD
    if (nextDog == null) return;
    if (nextDog == target) {
      nextDog = nextDog.next();
      return;
    }

    Dog prev = nextDog;
    Dog current = prev.next();

    while (current != null) {
      if (current.equals(target)) {
        prev.setNextDog(current.next());
        return;
      }
      prev = current;
      current = current.next();
    }
  }

  public String getName() {
    return name;
  }

  public Dog next() {
    return nextDog;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof Dog)) return false;

    Dog dog = (Dog) obj;
    return name.equals(dog.getName());
  }


  // main method
  public static void main(String[] args) {
    // test
    Dog head = new Dog("HEAD");
    Dog peter = new Dog("Peter");
    Dog sally = new Dog("Sally");
    Dog tommy = new Dog("Tommy");
    head.setNextDog(peter);
    head.next().setNextDog(sally);
    head.next().next().setNextDog(tommy);
    
    // print all dogs
    System.out.println();
    head.printDogs();
    System.out.println();

    head.removeTargetDog(sally);
    head.printDogs();

    // // remove last dog
    // head.removeLastDog();
    // head.printDogs();

    // // remove last dog
    // head.removeLastDog();
    // head.printDogs();

    // // remove last dog
    // head.removeLastDog();
    // head.printDogs();




  }
}
