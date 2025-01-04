package com.arshadm.aoc2024;

import com.arshadm.aoc2024.util.DataHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem02 {
  record Entry(List<Integer> levels) {
    public boolean isSafePart1() {
      Integer prevDiff = null;

      for (var i = 0; i < levels.size() - 1; i++) {
        var a = (int) levels.get(i);
        var b = (int) levels.get(i + 1);
        var currentDiff = b - a;

        if (Math.abs(currentDiff) < 1 || Math.abs(currentDiff) > 3) {
          return false;
        }

        if (prevDiff != null) {
          if (prevDiff < 0 && currentDiff > 0 || prevDiff > 0 && currentDiff < 0) {
            return false;
          }
        }

        prevDiff = currentDiff;
      }

      return true;
    }

    public boolean isSafePart2() {
      if (isSafePart1()) {
        return true;
      }

      for (var i = 0; i < levels.size(); i++) {
        var newLevels = new ArrayList<>(levels);
        newLevels.remove(i);

        var newEntry = new Entry(newLevels);
        if (newEntry.isSafePart1()) {
          return true;
        }
      }

      return false;
    }

    public static Entry fromString(String line) {
      var levels = Arrays.stream(line.split(" ")).map(Integer::parseInt).toList();
      return new Entry(levels);
    }
  }

  public static long computePart1(String resource) {
    var entries = DataHelper.readLines(resource)
        .map(Entry::fromString);

    return entries.filter(Entry::isSafePart1).count();
  }

  public static long computePart2(String resource) {
    var entries = DataHelper.readLines(resource)
        .map(Entry::fromString);

    return entries.filter(Entry::isSafePart2).count();
  }
}
