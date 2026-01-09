package com.bootcamp.demo;

import java.util.Optional;
import lombok.Getter;
import lombok.Setter;

public class Cat {
  @Setter
  private Gun gun;
  @Getter
  private boolean isAlive;

  public Cat() {
    isAlive = true;
  }

  public Optional<Integer> checkBullet() {
    return Optional.ofNullable(gun.getBullet());
  }
  
  public void clearBullet() {
    if (gun == null) return;
    gun.clearBullet();
  }

  public void refillBullet() {
    if (gun == null) return;
    gun.refillBullet();
  }

  public void beingKilled() {
    isAlive = false;
  }

  public void attack(Cat targetCat) {
    if (gun == null || !isAlive) return;
    boolean shootSuccess = gun.shoot();
    if (shootSuccess) {
      targetCat.beingKilled();
    }
  }



  public static void main(String[] args) {
    // test
    System.out.println("Test");
  }
}
