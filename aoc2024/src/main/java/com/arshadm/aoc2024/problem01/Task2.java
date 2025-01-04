package com.arshadm.aoc2024.problem01;


import java.util.ArrayList;
import java.util.stream.Stream;


public class Task2 {
    public static long computeDistance(Stream<Entry> entries) {
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
