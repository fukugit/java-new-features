package jp.co.example.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceFeature {
    public void get() {
        List<String> list = Arrays.asList("AA", "BB", "CC");
        List<Integer> results = list.stream().map(this::convert).collect(Collectors.toList());
    }
    private Integer convert(String str) {
        return Integer.valueOf(str);
    }
}
