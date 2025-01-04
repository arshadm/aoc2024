package com.arshadm.aoc2024.problem01;


import com.google.common.collect.Streams;

import java.util.ArrayList;
import java.util.stream.Stream;


public class Task1 {
    public static int computeDistance(Stream<Entry> entries) {
        var left = new ArrayList<Integer>();
        var right = new ArrayList<Integer>();

        entries.forEach(entry -> {
            left.add(entry.left());
            right.add(entry.right());
        });

        System.out.println(left.stream().sorted().toList());

        return Streams.zip(left.stream().sorted(), right.stream().sorted(), (a, b) -> Math.abs(a - b)).mapToInt(i -> i).sum();
    }
}
