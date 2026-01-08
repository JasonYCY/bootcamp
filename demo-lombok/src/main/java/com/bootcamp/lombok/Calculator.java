package com.bootcamp.lombok;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Calculator {
  private int x;
  private int y;

  public int sum() {
    return x + y;
  }


  // Maven commands:
  // 0) mvn clean (delete target folder)

  // Execution order: 1 -> 2 -> 3 -> 4
  // 1) mvn compile (compile main code)
  // 2) mvn test (step 1 + compile and run all test cases)
  // 3) mvn package (step 2 + create jar file in target folder)
  // 4) mvn install (step 3 + save jar file to local .m2 folder)
}
