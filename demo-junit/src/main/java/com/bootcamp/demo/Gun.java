package com.bootcamp.demo;

import lombok.Getter;

@Getter
public class Gun {
  private static final int INITIAL_BULLET_NUMBER = 6;

  private int bullet;

  public boolean shoot() {
    throw new UnsupportedOperationException();
    // if (bullet <= 0) return false;
    // bullet--;
    // return true;
  }

  public void clearBullet() {
    bullet = 0;
  }

  public void refillBullet() {
    bullet = INITIAL_BULLET_NUMBER;
  }

  public Gun() {
    this(INITIAL_BULLET_NUMBER);
  }

  public Gun(int bullet) {
    this.bullet = bullet;
  }
}
