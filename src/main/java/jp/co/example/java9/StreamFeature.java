package jp.co.example.java9;

import java.util.Arrays;
import java.util.List;

public class StreamFeature {
  public static void main(String[] args) {
    List<String> list = Arrays.asList("Tokyo", "Osaka", "Okinawa", "Kanagawa", "Ooita");
    long count = list.stream().filter(city -> city.length() < 7).count();
    list.stream().limit(count - 1).forEach(System.out::println);
    // takeWhile
    list.stream().takeWhile(city -> city.length() < 7).forEach(System.out::println);
  }
}
