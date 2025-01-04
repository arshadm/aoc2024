package com.arshadm.aoc2024.util;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
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

    public static String readResource(String resource) throws IOException {
        var inputStream = DataHelper.class.getResourceAsStream(resource);
        if (inputStream == null) {
            throw new IllegalArgumentException("Resource not found: " + resource);
        }

        return CharStreams.toString(new InputStreamReader(inputStream, Charsets.UTF_8));
    }
}
