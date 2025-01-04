package com.arshadm.aoc2024;

import com.arshadm.aoc2024.util.DataHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Problem03 {
  record Entry(String expr) {
    public static Entry fromString(String line) {
      return new Entry(line);
    }

    public long computePart1() {
      var total = 0;

      // find each occurrency of mul(num,num) in the original string
      // extract the numbers and compute
      var pattern = Pattern.compile("mul\\(([\\d]{1,3}),([\\d]{1,3})\\)");
      var matcher = pattern.matcher(expr);
      while (matcher.find()) {
        var num1 = Integer.parseInt(matcher.group(1));
        var num2 = Integer.parseInt(matcher.group(2));
        total += num1 * num2;
      }

      return total;
    }

    public long computePart2() {
      var total = 0;
      var enabled = true;

      // find each occurrency of mul(num,num) in the original string
      // extract the numbers and compute
      var pattern = Pattern.compile("do\\(\\)|don't\\(\\)|mul\\(([\\d]{1,3}),([\\d]{1,3})\\)");
      var matcher = pattern.matcher(expr);
      while (matcher.find()) {
        var match = matcher.group();

        if (match.equals("do()")) {
          enabled = true;
        } else if (match.equals("don't()")) {
          enabled = false;
        } else if (enabled) {
          var num1 = Integer.parseInt(matcher.group(1));
          var num2 = Integer.parseInt(matcher.group(2));
          total += num1 * num2;
        }
      }

      return total;
    }

  }

  public static long computePart1(String resource) throws IOException {
    var entry = new Entry(DataHelper.readResource(resource));
    return entry.computePart1();
  }

  public static long computePart2(String resource) throws IOException {
    var entry = new Entry(DataHelper.readResource(resource));
    return entry.computePart2();
  }
}
