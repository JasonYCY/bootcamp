public class DemoObject {
  public static void main(String[] args) {
    // toString(), equals(), hashCode()
    Dog d1 = new Dog();

    System.out.println(d1.toString());
    System.out.println(d1.hashCode());
    System.out.println(d1.equals(new Dog()));
  }
}
