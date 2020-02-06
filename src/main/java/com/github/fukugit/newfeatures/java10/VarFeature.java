package com.github.fukugit.newfeatures.java10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VarFeature {
  public static void main(String[] args) {
    var str = "123";
    var num = 1;
    var list = List.of("123");
    var map1 = new HashMap<String, String>(){{put("one", "1st");}};
    var map2 = Map.of("key1","val2","key2","val2");

    // The following syntax can be used from Java 11.
    // It allow you to use "var" in "stream".
    List.of("test1", "test2").stream()
      .forEach((var s) -> {
        System.out.println(s);
      });
  }
}
