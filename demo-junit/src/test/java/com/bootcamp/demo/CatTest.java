package com.bootcamp.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CatTest {
  @Mock
  private Gun gun;

  @InjectMocks
  private Cat cat1;

  @Mock
  private Cat cat2;

  @Test
  void unitTestAttack() {
    when(this.gun.shoot()).thenReturn(true);
    when(cat2.isAlive()).thenReturn(true).thenReturn(false);

    assertEquals(true, cat2.isAlive());
    cat1.attack(cat2);
    assertEquals(false, cat2.isAlive());

    verify(gun, times(1)).shoot();  // ⭐ Verify gun was used
    verify(cat2, times(2)).isAlive();  // ⭐ Verify cat2 was killed
  }

  // @Test  (This is not unit testing, but integrated testing)
  // void testAttack() {
  //   Cat cat1 = new Cat();
  //   cat1.setGun(new Gun());
  //   assertTrue(cat1.isAlive());

  //   Cat cat2 = new Cat();
  //   assertTrue(cat2.isAlive());

  //   cat1.attack(cat2);
  //   assertFalse(cat2.isAlive());
  // }
}
