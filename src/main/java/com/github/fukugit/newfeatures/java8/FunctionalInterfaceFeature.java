package com.github.fukugit.newfeatures.java8;

import java.util.Date;
import java.util.function.Consumer;
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

    // ------------------ Function class ----------------------
    // 1 line logic.
    Function<String, Integer> function1 = s -> Integer.valueOf(s) + 100;
    System.out.println(function1.apply("100"));

    // Method reference.
    Function<String, String> function2 = String::toUpperCase;
    System.out.println(function2.apply("aaa"));

    // Multi Line logic.
    Function<String, String> function3 = s -> {
      String name = s.toUpperCase();
      return name + ":test";
    };
    System.out.println(function3.apply("bbb"));

    // Method argument.
    System.out.println(getBookTitle(String::toUpperCase));
    // ------------------ Function class end ----------------------

    // ------------------ Consumer class ----------------------
    // 1 line logic.
    Consumer<Integer> consumer1 = s -> System.out.println("Number is " + s);
    consumer1.accept(100);
    // ------------------ Consumer class end ----------------------
  }

  private static Book get() {
    return s -> s.toUpperCase();
  }

  @FunctionalInterface
  interface Book {
    public String showTitle(String name);
  }

  private static String getBookTitle(Function<String, String> function) {
    return function.apply("aaa book");
  }
}
