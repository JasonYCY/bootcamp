public class DemoNestedClass {
  // static attribute
  private static int staticValue = 100;

  // object attribute
  private int value = 50;

  // static inner class
  public static class Fruit2 {
    public int staticValue() {
      return staticValue;
    }

    // !!! Cannot make a static reference to the non-static field value !!!
    // public int objectValue() {
    //   return value;
    // }

    @Override
    public String toString() {
      return "Fruit2 []";
    }
  }

  // object inner class
  public class Fruit {
    public int staticValue() {
      return staticValue;
    }

    public int objectValue() {
      return value;
    }

    @Override
    public String toString() {
      return "Fruit []";
    }
  }





  // main method
  public static void main(String[] args) {
    // static inner class new object
    DemoNestedClass.Fruit2 staticInner = new DemoNestedClass.Fruit2();
    System.out.println(staticInner);

    // object inner class new object
    DemoNestedClass outer = new DemoNestedClass();
    DemoNestedClass.Fruit objectInner = outer.new Fruit();
    System.out.println(objectInner);

    





  }
}
