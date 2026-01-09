package com.bootcamp.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {
  private Calculator calculator;

  public int operate(int x, int y) {
    calculator.setX(x);
    calculator.setY(y);
    return calculator.sum() + 50;
  }

}
