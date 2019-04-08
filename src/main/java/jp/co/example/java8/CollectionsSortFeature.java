package jp.co.example.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CollectionsSortFeature {
  public static void main(String[] args) {
    List<String> list1 = Arrays.asList("AAA", "B", "CC");
    list1.sort((s1, s2) -> s1.length() - s2.length());
    list1.stream().forEach(System.out::println);

    List<String> list2 = Arrays.asList("AAA", "B", "CC");
    list2.sort(Comparator.comparing(s -> s.length()));
    list2.stream().forEach(System.out::println);

    List<String> list3 = Arrays.asList("AAA", "B", "CC");
    list3.sort(Comparator.comparing(String::length));
    list3.stream().forEach(System.out::println);

    List<Book> books = new ArrayList<>();
    books.add(new Book("AAA", 3000L));
    books.add(new Book("C", 2000L));
    books.add(new Book("B", 2000L));
    books.sort(Comparator.comparing(Book::getPrice).thenComparing(e -> e.getTitle().length()));
    books.stream().forEach(e -> System.out.println(e.getTitle()));
  }

  private static class Book {
    public Book(String title, Long price) {
      this.title = title;
      this.price = price;
    }
    String title;
    Long price;

    public String getTitle() {
      return title;
    }

    public Long getPrice() {
      return price;
    }
  }
}
