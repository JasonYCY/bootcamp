import java.util.List;

public class Zoo<T extends Animal, U extends Worker> {
  private List<T> animals;
  private List<U> workers;

  public List<T> getAnimals() {
    return animals;
  }

  public List<U> getWorkers() {
    return workers;
  }

  // main method
  public static void main(String[] args) {
    // This example overuses generics !!!
    Zoo<Animal, Worker> zoo = new Zoo<>();
    zoo.getAnimals().add(new Tiger());
    zoo.getAnimals().add(new Panda());
    zoo.getWorkers().add(new Cleaner());
    zoo.getWorkers().add(new Keeper());
  }
}
