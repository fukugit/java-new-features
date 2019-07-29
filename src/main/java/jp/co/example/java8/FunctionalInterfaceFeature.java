package jp.co.example.java8;

import java.util.Date;
import java.util.function.Function;

public class FunctionalInterfaceFeature {

  public static void main(String[] args) {
    System.out.println("-------- This is own customized functional interface case, which is Book class. -------");
    Book book1 = (subject) -> {
      return subject.toLowerCase();
    };
    System.out.println(book1.showTitle("AAA"));

    Book book2 = get();
    System.out.println(book2.showTitle("bbb"));

    System.out.println("-------- This is Function class case, which Java provides. -------");
    Function<String, Integer> function1 = s -> Integer.valueOf(s) + 100;
    System.out.println(function1.apply("100"));
    Function<String, String> function2 = String::toUpperCase;
    System.out.println(function2.apply("aaa"));
  }

  private static Book get() {
    return s -> s.toUpperCase();
  }

  @FunctionalInterface
  interface Book {
    public String showTitle(String name);
  }
}
