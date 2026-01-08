package com.bootcamp.lombok;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
  // Test Annotation -> one test case
  @Test
  void testSum() {
    Calculator calculator = new Calculator(3, 7);
    Assertions.assertEquals(10, calculator.sum());
  }
}
