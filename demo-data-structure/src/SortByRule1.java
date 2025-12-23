import java.util.Comparator;

public class SortByRule1 implements Comparator<Person> {
  @Override
  public int compare(Person p1, Person p2) {
    int occupationDiff = p1.getOccupation().ordinal() - p2.getOccupation().ordinal();
    return occupationDiff != 0 ? occupationDiff : p2.getAge() - p1.getAge();
  }

}
