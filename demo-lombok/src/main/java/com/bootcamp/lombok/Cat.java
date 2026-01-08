package com.bootcamp.lombok;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Cat {
  // attribute
  private String name;
  private int age;

  /*
   * Lombok auto generates these for you
   */
  // constructor
  // getter, setter
  // toString, equals, hashCode



  // main method
  public static void main(String[] args) {
    Cat cat1 = new Cat();
    System.out.println(cat1.getName() == null);
    System.out.println(cat1.getAge() == 0);

    Cat cat2 = new Cat("John", 3);
    System.out.println(cat2.getName().equals("John"));
    System.out.println(cat2.getAge() == 3);

    cat2.setAge(4);
    System.out.println(cat2.getAge() == 4);
    cat2.setName("Peter");
    System.out.println(cat2.getName().equals("Peter"));

    Cat cat3 = new Cat("Peter", 4);
    System.out.println(cat2.equals(cat3));
    System.out.println(cat2.hashCode() == cat3.hashCode());

    System.out.println(cat1);
    System.out.println(cat2);
    System.out.println(cat3);



  }
}
