package com.arshadm.aoc2024;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem05Test {
  @Test
  public void Task1aTest() throws IOException {
    var value = Problem05.computePart1("/problem05/task1a_data.txt");
    assertEquals(143, value);
  }

  @Test
  public void Task1bTest() throws IOException {
    var value = Problem05.computePart1("/problem05/task1b_data.txt");
    assertEquals(5509, value);
  }

  @Test
  public void Task2aTest() throws IOException {
    var value = Problem05.computePart2("/problem05/task2a_data.txt");
    assertEquals(123, value);
  }

  @Test
  public void Task2bTest() throws IOException {
    var value = Problem05.computePart2("/problem05/task1b_data.txt");
    assertEquals(0, value);
  }
}
