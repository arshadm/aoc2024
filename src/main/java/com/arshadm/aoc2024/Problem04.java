package com.arshadm.aoc2024;

import com.arshadm.aoc2024.util.DataHelper;

import java.io.IOException;
import java.util.List;

public class Problem04 {
  record Entry(List<char[]> lines) {
    public long computePart1() {
      var total = 0;

      // iterate through the whole board and assume we are at position (i,j)
      // if we are on a character 'X' then check how many xmas's it's a part of
      // add them all up
      for (var i = 0; i < lines.size(); i++) {
        var line = lines.get(i);

        for (var j = 0; j < line.length; j++) {
          if (getChar(i, j) == 'X') {
            var x1 = List.of(getChar(i, j), getChar(i + 1, j), getChar(i + 2, j), getChar(i + 3, j)); // XMAS
            var x2 = List.of(getChar(i, j), getChar(i - 1, j), getChar(i - 2, j), getChar(i - 3, j)); // SAMX
            var x3 = List.of(getChar(i, j), getChar(i, j + 1), getChar(i, j + 2), getChar(i, j + 3)); // vertical down
            var x4 = List.of(getChar(i, j), getChar(i, j - 1), getChar(i, j - 2), getChar(i, j - 3)); // vertical up

            var x5 = List.of(getChar(i, j), getChar(i + 1, j + 1), getChar(i + 2, j + 2), getChar(i + 3, j + 3)); // diagonal 1
            var x6 = List.of(getChar(i, j), getChar(i - 1, j + 1), getChar(i - 2, j + 2), getChar(i - 3, j + 3)); // diagonal 1
            var x7 = List.of(getChar(i, j), getChar(i - 1, j - 1), getChar(i - 2, j - 2), getChar(i - 3, j - 3)); // diagonal 1
            var x8 = List.of(getChar(i, j), getChar(i + 1, j - 1), getChar(i + 2, j - 2), getChar(i + 3, j - 3)); // diagonal 1

            var candidates = List.of(x1, x2, x3, x4, x5, x6, x7, x8);
            var count = candidates.stream().filter(l -> l.equals(List.of('X', 'M', 'A', 'S'))).count();
            total += count;
//            System.out.println("Count=" + count + ", " + candidates);
          }
        }
      }

      return total;
    }

    public long computePart2() {
      var total = 0;

      // iterate through the whole board and assume we are at position (i,j)
      // if we are on a character 'X' then check how many xmas's it's a part of
      // add them all up
      for (var i = 0; i < lines.size(); i++) {
        var line = lines.get(i);

        for (var j = 0; j < line.length; j++) {
          if (getChar(i, j) == 'A') {
            var x1 = List.of(getChar(i - 1, j - 1), getChar(i, j), getChar(i + 1, j + 1));
            var x2 = List.of(getChar(i - 1, j + 1), getChar(i, j), getChar(i + 1, j - 1));

            var candidates = List.of(x1, x2);
            var count = candidates.stream().filter(l -> l.equals(List.of('M', 'A', 'S')) || l.equals(List.of('S', 'A', 'M'))).count();
            if (count == 2) {
              total += 1;
            }
//            System.out.println("Count=" + count + ", " + candidates);
          }
        }
      }

      return total;
    }

    private char getChar(int i, int j) {
      if ((i >= 0) && (i < lines.size())) {
        var line = lines.get(i);
        if ((j >= 0) && (j < line.length)) {
          return line[j];
        }
      }

      return '.';
    }
  }

  public static long computePart1(String resource) throws IOException {
    var entry = new Entry(DataHelper.readLines(resource).map(String::toCharArray).toList());
    return entry.computePart1();
  }

  public static long computePart2(String resource) throws IOException {
    var entry = new Entry(DataHelper.readLines(resource).map(String::toCharArray).toList());
    return entry.computePart2();
  }
}
