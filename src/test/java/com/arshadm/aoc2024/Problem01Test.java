package com.arshadm.aoc2024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem01Test {
  @Test
  public void Task1aTest() {
    var distance = Problem01.computePartA("/problem01/taska_data.txt");
    assertEquals(11, distance);
  }

  @Test
  public void Task1bTest() {
    var distance = Problem01.computePartA("/problem01/taskb_data.txt");
    assertEquals(3246517, distance);
  }

  @Test
  public void Task2aTest() {
    var distance = Problem01.computePartB("/problem01/taska_data.txt");
    assertEquals(31, distance);
  }

  @Test
  public void Task2bTest() {
    var distance = Problem01.computePartB("/problem01/taskb_data.txt");
    assertEquals(29379307, distance);
  }
}
