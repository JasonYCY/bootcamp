public class DemoObject {
  public static void main(String[] args) {
    // toString(), equals(), hashCode()
    Dog d1 = new Dog("John", 1);
    Dog d2 = new Dog("John", 1);

    System.out.println(d1.equals(d2));
    System.out.println(d1.hashCode() == d2.hashCode());
    System.out.println(d1);
    System.out.println(d2);
  }
}
