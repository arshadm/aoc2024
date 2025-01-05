package com.arshadm.aoc2024;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem06Test {
  @Test
  public void Task1aTest() throws IOException {
    var value = Problem06.computePart1("/problem06/task1a_data.txt");
    assertEquals(41, value);
  }

  @Test
  public void Task1bTest() throws IOException {
    var value = Problem06.computePart1("/problem06/task1b_data.txt");
    assertEquals(5239, value);
  }

  @Test
  public void Task2aTest() throws IOException {
    var value = Problem06.computePart2("/problem06/task2a_data.txt");
    assertEquals(6, value);
  }

  @Test
  public void Task2bTest() throws IOException {
    var value = Problem06.computePart2("/problem06/task1b_data.txt");
    assertEquals(4407, value);
  }
}
