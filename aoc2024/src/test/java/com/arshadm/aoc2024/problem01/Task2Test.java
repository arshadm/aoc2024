package com.arshadm.aoc2024.problem01;

import com.arshadm.aoc2024.util.DataHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

class Task2Test {
    static final Pattern ENTRY_PATTER = Pattern.compile("(\\d+)[ ]+(\\d+)");

    @Test
    public void Task2aTest() {
        var distance = Task2.computeDistance(DataHelper.readLines("/problem01/task1a_data.txt")
                .map(Task2Test::readLine));

        Assertions.assertEquals(31, distance);
    }

    @Test
    public void Task2bTest() {
        var distance = Task2.computeDistance(DataHelper.readLines("/problem01/task1b_data.txt")
                .map(Task2Test::readLine));

        Assertions.assertEquals(29379307, distance);
    }

    private static Entry readLine(String line) {
        var matcher = ENTRY_PATTER.matcher(line);
        if (matcher.matches()) {
            return new Entry(Integer.valueOf(matcher.group(1)), Integer.valueOf(matcher.group(2)));
        }

        throw new IllegalArgumentException("Cannot read entry: " + line);
    }
}