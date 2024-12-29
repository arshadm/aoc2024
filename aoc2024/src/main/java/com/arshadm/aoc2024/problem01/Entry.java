package com.arshadm.aoc2024.problem01;

public record Entry(Integer left, Integer right) {
    public Integer left() {
        return left;
    }

    public Integer right() {
        return right;
    }
}