package com.arshadm.aoc2024;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem04Test {
  @Test
  public void Task1aTest() throws IOException {
    var value = Problem04.computePart1("/problem04/task1a_data.txt");
    assertEquals(18, value);
  }

  @Test
  public void Task1bTest() throws IOException {
    var value = Problem04.computePart1("/problem04/task1b_data.txt");
    assertEquals(2500, value);
  }

  @Test
  public void Task2aTest() throws IOException {
    var value = Problem04.computePart2("/problem04/task2a_data.txt");
    assertEquals(9, value);
  }

  @Test
  public void Task2bTest() throws IOException {
    var value = Problem04.computePart2("/problem04/task1b_data.txt");
    assertEquals(1933, value);
  }
}
