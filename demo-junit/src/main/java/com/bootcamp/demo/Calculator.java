package com.bootcamp.demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Calculator {
  private int x;
  private int y;

  public int sum() {
    throw new UnsupportedOperationException();
    // return x + y;
  }
}
