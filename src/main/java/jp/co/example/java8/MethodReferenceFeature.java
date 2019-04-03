package jp.co.example.java8;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceFeature {
  public static void main(String[] args) {


    // Static
    // str -> Integer.parseInt(str)
    List<String> list1 = Arrays.asList("100", "200", "300");
    List<Integer> result1 = list1.stream().map(Integer::parseInt).collect(Collectors.toList());
    result1.stream().forEach(System.out::println);

    // Bound
    // Instant then = Instant.now();
    // s -> then.isAfter(s)
    Instant then = Instant.now();
    List<Instant> list2 = Arrays.asList(Instant.now());
    list2.stream().filter(Instant.now()::isAfter).forEach(System.out::println);

    // Unbound
    // str -> str.toLowerCase()
    List<String> list3 = Arrays.asList("A", "B", "C");
    list3.stream().map(String::toLowerCase).collect(Collectors.toList()).forEach(System.out::println);

    // Array constructor
    List<String> list4 = Arrays.asList("A", "B", "C");
    list4.stream().map(String::toLowerCase).toArray(String[]::new);

    // Using this.
    Book book = new Book();
    book.getPrices(Arrays.asList("100", "200")).stream().forEach(System.out::println);
  }

  public static class Book {
    public List<Integer> getPrices(List<String> prices) {
      List<Integer> results = prices.stream().map(this::convert).collect(Collectors.toList());
      return results;
    }
    private Integer convert(String str) {
      return Integer.valueOf(str);
    }
  }


}
