package com.github.fukugit.newfeatures.java8;

import java.util.*;

public class CollectionsSortFeature {
  public static void main(String[] args) {

    // This is old style. Therefore, we never use it.
    List<String> list0 = Arrays.asList("AAA", "B", "CC");
    Collections.sort(list0, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
      }
    });
    list0.stream().forEach(System.out::println);

    // Using Lambda in sort.
    List<String> list1 = Arrays.asList("AAA", "B", "CC");
    list1.sort((s1, s2) -> s1.length() - s2.length());
    list1.stream().forEach(System.out::println);

    // Using "Comparator.comparing", and Lambda.
    List<String> list2 = Arrays.asList("AAA", "B", "CC");
    list2.sort(Comparator.comparing(s -> s.length()));
    list2.stream().forEach(System.out::println);

    // Using "Comparator.comparing", and Method reference as comparing.
    List<String> list3 = Arrays.asList("AAA", "B", "CC");
    list3.sort(Comparator.comparing(String::length));
    list3.stream().forEach(System.out::println);

    // Using "Comparator.comparing", and Method reference as comparingInt.
    List<String> list4 = Arrays.asList("AAA", "B", "CC");
    list4.sort(Comparator.comparingInt(String::length));
    list4.stream().forEach(System.out::println);

    // Comparing for Object list.
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
