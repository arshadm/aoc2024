package com.arshadm.aoc2024;


import com.arshadm.aoc2024.util.DataHelper;
import com.google.common.collect.Streams;

import java.util.ArrayList;
import java.util.regex.Pattern;


public class Problem01 {
  record Entry(Integer left, Integer right) {
    static final Pattern ENTRY_PATTER = Pattern.compile("(\\d+)\\s+(\\d+)");

    public static Entry fromString(String line) {
      var matcher = ENTRY_PATTER.matcher(line);
      if (matcher.matches()) {
        return new Entry(Integer.valueOf(matcher.group(1)), Integer.valueOf(matcher.group(2)));
      }

      throw new IllegalArgumentException("Cannot read entry: " + line);
    }
  }

  public static int computePartA(String resource) {
    var entries = DataHelper.readLines(resource)
        .map(Entry::fromString);
    var left = new ArrayList<Integer>();
    var right = new ArrayList<Integer>();

    entries.forEach(entry -> {
      left.add(entry.left());
      right.add(entry.right());
    });

    System.out.println(left.stream().sorted().toList());

    return Streams.zip(left.stream().sorted(), right.stream().sorted(), (a, b) -> Math.abs(a - b)).mapToInt(i -> i).sum();
  }

  public static long computePartB(String resource) {
    var entries = DataHelper.readLines(resource)
        .map(Entry::fromString);
    var left = new ArrayList<Integer>();
    var right = new ArrayList<Integer>();

    entries.forEach(entry -> {
      left.add(entry.left());
      right.add(entry.right());
    });


    return left.stream().map(l -> l * right.stream().filter(l::equals).count())
        .mapToLong(i -> i)
        .sum();
  }
}
