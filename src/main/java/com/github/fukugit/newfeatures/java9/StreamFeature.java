package com.github.fukugit.newfeatures.java9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamFeature {
  public static void main(String[] args) {
    // takeWhile (条件に一致している間のみ処理を実施)
    List<String> list1 = Arrays.asList("Tokyo", "Osaka", "Okinawa", "Kanagawa", "Ooita");
    long count = list1.stream().filter(city -> city.length() < 7).count();
    list1.stream().limit(count - 1).forEach(s -> System.out.println("Like takeWhile at Java8: " + s));
    // Java9
    list1.stream().takeWhile(city -> city.length() < 7)
      .forEach(s -> System.out.println("takeWhile at Java9: " + s));

    // dropWhile (条件に一致しないデータが現れて以降、処理をする)
    List<String> list2 = Arrays.asList("Tokyo", "Osaka", "Okinawa", "Kanagawa", "Ooita");
    boolean isDirty = false;
    for (String city : list2) {
      if (!isDirty && !(city.length() < 7)) isDirty = true;
      if (isDirty) System.out.println("Like dropWhile at Java8: " + city);
    }
    // Java9
    list1.stream().dropWhile(city -> city.length() < 7)
      .forEach(s -> System.out.println("dropWhile at Java9: " + s));

    // ofNullable (Nullをスキップする。)
    Stream.of(null,7,2,4,3,5,null,6).flatMap(i -> {
      if(i == null){
        return Stream.empty();
      }
      else{
        return Stream.of(i);
      }
    }).forEach(System.out::println);
    // Java 9
    // https://codezine.jp/article/detail/10726
    Stream.of(null,7,2,4,3,5,null,6).flatMap(i -> Stream.ofNullable(i)).forEach(System.out::println);
  }
}
