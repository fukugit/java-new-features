package jp.co.example.java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionFeature {

  public static void main(String[] args) {
    // Function<T, R>
    String result1 = convert(i -> i.toString());
    System.out.println(result1);

    // Consumer<T>
    print(s -> {
      String result = s.toUpperCase();
      System.out.println(result);
    });
    
    // Predicate<T>
    boolean result = is(s -> "bbb".equals(s));
    System.out.println(result);

    // Supplier<R>
    System.out.println(get(() -> "This is Supplier."));
  }

  private static String convert(Function<Integer, String> function) {
    return function.apply(100);
  }

  private static void print(Consumer<String> consumer) {
    consumer.accept("Consumer Test");
  }

  private static Boolean is(Predicate<String> predicate) {
    return predicate.test("test");
  }

  private static String get(Supplier<String> supplier) {
    return supplier.get();
  }
}
