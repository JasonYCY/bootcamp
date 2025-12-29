import java.util.LinkedList;
import java.util.List;

public class Zoo2 {
  private List<Animal> animals;
  private List<Worker> workers;

  public Zoo2() {
    this(new LinkedList<>(), new LinkedList<>());
  }

  public Zoo2(List<Animal> animals, List<Worker> workers) {
    this.animals = animals;
    this.workers = workers;
  }

  public boolean add(Animal animal) {
    return animals.add(animal);
  }

  public boolean add(Worker worker) {
    return workers.add(worker);
  }

  public int numberOfAnimal() {
    return animals.size();
  }


  // main method
  public static void main(String[] args) {
    Zoo2 zoo2 = new Zoo2();
    zoo2.add(new Keeper());
    zoo2.add(new Cleaner());
    zoo2.add(new Tiger());
    zoo2.add(new Panda());
    System.out.println("Number of animal: " + zoo2.numberOfAnimal());
  }
}
