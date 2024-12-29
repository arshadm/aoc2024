package com.arshadm.aoc2024.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class DataHelper {
    public static Stream<String> readLines(String resource) {
        var inputStream = DataHelper.class.getResourceAsStream(resource);
        if (inputStream == null) {
            throw new IllegalArgumentException("Resource not found: " + resource);
        }

        var reader = new BufferedReader(new InputStreamReader(inputStream));
        return reader.lines();
    }
}
