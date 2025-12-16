public class Human implements Eatable, Sleepable {
  private static final int MAX_HP = 100;
  private String name;
  private int HP = MAX_HP;

  public Human(String name) {
    this.name = name;
  }

  public void eat() {
    HP = Math.min(MAX_HP, HP + 10);
  }

  public void sleep() {
    HP = MAX_HP;
  }

  public void receiveDamage(int damage) {
    HP = Math.max(0, HP - damage);
  }

  public String getName() {
    return name;
  }

  public int getHP() {
    return HP;
  }

  

  // main method
  public static void main(String[] args) {
    // test
    Human human = new Human("John");
    human.eat();
    human.sleep();

    Superman superman = new Superman("Clark");
    superman.eat();
    superman.sleep();
    superman.fly();

    System.out.println("HP: " +  superman.getHP());
    System.out.println("-50 HP");
    superman.receiveDamage(50);
    System.out.println("HP: " + superman.getHP());
    System.out.println("eating");
    superman.eat();
    System.out.println("HP: " + superman.getHP());
    System.out.println("sleeping");
    superman.sleep();
    System.out.println("HP: " + superman.getHP());





  }
}
