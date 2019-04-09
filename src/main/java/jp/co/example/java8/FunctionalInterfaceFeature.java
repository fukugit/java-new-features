package jp.co.example.java8;

import java.util.Date;

public class FunctionalInterfaceFeature {

  public static void main(String[] args) {
    Book book1 = (subject) -> {
      return "Subject : " + subject;
    };
    System.out.println(book1.showTitle("AAA"));

    Book book2 = get();
    System.out.println(book2.showTitle("bbb"));
  }

  private static Book get() {
    return s -> s.toUpperCase();
  }

  @FunctionalInterface
  interface Book {
    public String showTitle(String name);
  }
}
