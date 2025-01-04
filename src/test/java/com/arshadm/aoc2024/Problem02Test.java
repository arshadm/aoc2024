package com.arshadm.aoc2024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem02Test {
  @Test
  public void Task1aTest() {
    var value = Problem02.computePart1("/problem02/taska_data.txt");
    assertEquals(2, value);
  }

  @Test
  public void Task1bTest() {
    var value = Problem02.computePart1("/problem02/taskb_data.txt");
    assertEquals(559, value);
  }

  @Test
  public void Task2aTest() {
    var value = Problem02.computePart2("/problem02/taska_data.txt");
    assertEquals(4, value);
  }

  @Test
  public void Task2bTest() {
    var value = Problem02.computePart2("/problem02/taskb_data.txt");
    assertEquals(4, value);
  }

}
