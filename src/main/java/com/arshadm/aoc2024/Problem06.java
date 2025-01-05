package com.arshadm.aoc2024;

import com.arshadm.aoc2024.util.DataHelper;

import java.io.IOException;
import java.util.List;

public class Problem06 {
  record GuardPos(int x, int y, int i, int j) {
    public GuardPos walk() {
      return new GuardPos(x + i, y + j, i, j);
    }

    public GuardPos turn() {
      if (j == 1) {
        return new GuardPos(x, y, -1, 0);
      } else if (j == -1) {
        return new GuardPos(x, y, 1, 0);
      }

      if (i == 1) {
        return new GuardPos(x, y, 0, 1);
      } else if (i == -1) {
        return new GuardPos(x, y, 0, -1);
      }

      throw new IllegalStateException("Guard has incorrect direction: " + this);
    }
  }

  record Data(List<char[]> map, GuardPos guard) {
    public long computePart1() {
      var currentPos = guard;
      var steps = 1;
      setChar(currentPos.x, currentPos.y, 'X');

      while (true) {
        var newPos = currentPos.walk();
        var ch = getChar(newPos.x, newPos.y);
        if (ch == null) {
          break;
        }

        if (ch == '#') {
          currentPos = currentPos.turn();
        } else {
          currentPos = newPos;

          // annotate map with how the guard is moving
        }
      }

      return steps;
    }

    public long computePart2() {
      var currentPos = guard;
      var steps = 1;
      setChar(currentPos.x, currentPos.y, 'X');

      while (true) {
        var newPos = currentPos.walk();
        var ch = getChar(newPos.x, newPos.y);
        if (ch == null) {
          break;
        }

        if (ch == '#') {
          currentPos = currentPos.turn();
        } else {
          currentPos = newPos;
          setChar(newPos.x, newPos.y, 'X');
        }
      }

      return 0;
    }

    private Character getChar(int x, int y) {
      if ((y >= 0) && (y < map.size())) {
        var row = map.get(y);
        if ((x >= 0) && (x < row.length)) {
          return row[x];
        }
      }

      return null;
    }

    private void setChar(int x, int y, char ch) {
      if ((y >= 0) && (y < map.size())) {
        var row = map.get(y);
        if ((x >= 0) && (x < row.length)) {
          row[x] = ch;
        }
      }
    }
  }

  public static long computePart1(String resource) {
    var data = parseData(DataHelper.readLines(resource).toList());
    return data.computePart1();
  }

  public static long computePart2(String resource) {
    var data = parseData(DataHelper.readLines(resource).toList());
    return data.computePart2();
  }

  private static Data parseData(List<String> lines) {
    var map = lines.stream().map(String::toCharArray).toList();
    GuardPos guardPos = null;

    LOOP:
    for (var i = 0; i < map.size(); i++) {
      var row = map.get(i);
      for (var j = 0; j < row.length; j++) {
        var ch = row[j];

        switch (ch) {
          case '>':
            guardPos = new GuardPos(j, i, 1, 0);
            break LOOP;

          case '^':
            guardPos = new GuardPos(j, i, 0, -1);
            break LOOP;

          case '<':
            guardPos = new GuardPos(j, i, -1, 0);
            break LOOP;

          case 'v':
            guardPos = new GuardPos(j, i, 0, 1);
            break LOOP;
        }
      }
    }

    return new Data(map, guardPos);
  }
}
