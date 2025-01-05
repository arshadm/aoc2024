package com.arshadm.aoc2024;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem03Test {
  @Test
  public void Task1aTest() throws IOException {
    var value = Problem03.computePart1("/problem03/task1a_data.txt");
    assertEquals(161, value);
  }

  @Test
  public void Task1bTest() throws IOException {
    var value = Problem03.computePart1("/problem03/task1b_data.txt");
    assertEquals(187194524, value);
  }

  @Test
  public void Task2aTest() throws IOException {
    var value = Problem03.computePart2("/problem03/task2a_data.txt");
    assertEquals(48, value);
  }

  @Test
  public void Task2bTest() throws IOException {
    var value = Problem03.computePart2("/problem03/task1b_data.txt");
    assertEquals(127092535, value);
  }

}
