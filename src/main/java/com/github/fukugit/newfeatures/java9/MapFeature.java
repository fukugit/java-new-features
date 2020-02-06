package com.github.fukugit.newfeatures.java9;

import java.util.Map;

public class MapFeature {
    public static void main(String[] args) {
        Map map = Map.of("1", "one", "2", "two", "3", "three");
        map.entrySet().stream()
                .forEach(s -> System.out.println(s.toString()));
    }
}
