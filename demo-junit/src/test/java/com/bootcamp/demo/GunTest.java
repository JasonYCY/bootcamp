package com.bootcamp.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GunTest {
  @Test
  void testShoot() {
    Gun gun = new Gun();
    assertEquals(6, gun.getBullet(), "Initial bullet should be 6");

    assertEquals(true, gun.shoot());
    assertEquals(5, gun.getBullet());

    assertEquals(true, gun.shoot());
    assertEquals(4, gun.getBullet());

    assertEquals(true, gun.shoot());
    assertEquals(3, gun.getBullet());

    assertEquals(true, gun.shoot());
    assertEquals(2, gun.getBullet());

    assertEquals(true, gun.shoot());
    assertEquals(1, gun.getBullet());

    assertEquals(true, gun.shoot());
    assertEquals(0, gun.getBullet());

    assertEquals(false, gun.shoot());
    assertEquals(0, gun.getBullet());
  }
}
