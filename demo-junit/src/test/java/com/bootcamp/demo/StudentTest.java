package com.bootcamp.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StudentTest {
  @Mock
  private Calculator calculator;

  @InjectMocks
  private Student student;

  @Test
  void testOperate() {
    when(calculator.sum()).thenReturn(100);
    assertEquals(150, student.operate(40, 60));
    verify(calculator, times(1)).sum();
  }
}
