package com.arshadm.aoc2024;

import com.arshadm.aoc2024.util.DataHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem05 {
  record Data(Map<Integer, Set<Integer>> ordering, List<List<Integer>> pages) {
    public long computePart1() {
      var ordered = pages.stream().filter(page -> {
        for (var i = 0; i < page.size(); i++) {
          var p1 = page.get(i);

          for (var j = i + 1; j < page.size(); j++) {
            var p2 = page.get(j);

            if (ordering.containsKey(p1)) {
              if (!ordering.get(p1).contains(p2)) {
                return false;
              }
            } else if (ordering.containsKey(p2)) {
              if (ordering.get(p2).contains(p1)) {
                return false;
              }
            }
          }
        }

        return true;
      }).toList();

      var middlePages = new ArrayList<Integer>();
      for (var pages : ordered) {
        middlePages.add(pages.get(pages.size() / 2));
      }

      return middlePages.stream().mapToInt(i -> i).sum();
    }

    public long computePart2() {
      var notOrdered = pages.stream().filter(page -> {
        for (var i = 0; i < page.size(); i++) {
          var p1 = page.get(i);

          for (var j = i + 1; j < page.size(); j++) {
            var p2 = page.get(j);

            if (ordering.containsKey(p1)) {
              if (!ordering.get(p1).contains(p2)) {
                return true;
              }
            } else if (ordering.containsKey(p2)) {
              if (ordering.get(p2).contains(p1)) {
                return true;
              }
            }
          }
        }

        return false;
      }).toList();

      var fixedPages = notOrdered.stream().map(page -> {
        var fixed = new ArrayList<>(page);

        for (var i = 0; i < fixed.size(); i++) {
          var p1 = fixed.get(i);
          for (var j=i+1; j<fixed.size(); j++) {
            var p2 = fixed.get(j);

            if (ordering.containsKey(p2)) {
              if (ordering.get(p2).contains(p1)) {
                fixed.set(i, p2);
                fixed.set(i + 1, p1);
                p1 = p2;
              }
            }
          }
        }

        return fixed;
      }).toList();

      System.out.println("Not Ordered: " + notOrdered);
      System.out.println("Fixed:" + fixedPages);

      var middlePages = new ArrayList<Integer>();
      for (var pages : fixedPages) {
        middlePages.add(pages.get(pages.size() / 2));
      }

      return middlePages.stream().mapToInt(i -> i).sum();
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
    var mode = 1;
    var ordering = new HashMap<Integer, Set<Integer>>();
    var pages = new ArrayList<List<Integer>>();

    for (var line : lines) {
      if (line.isBlank()) {
        mode = 2;
        continue;
      }

      if (mode == 1) {
        var tokens = line.split("\\|");
        var p1 = Integer.parseInt(tokens[0]);
        var p2 = Integer.parseInt(tokens[1]);

        ordering.putIfAbsent(p1, new HashSet<>());
        ordering.get(p1).add(p2);
      } else {
        var tokens = line.split(",");
        pages.add(Arrays.stream(tokens).map(Integer::parseInt).toList());
      }
    }

    return new Data(ordering, pages);
  }
}
