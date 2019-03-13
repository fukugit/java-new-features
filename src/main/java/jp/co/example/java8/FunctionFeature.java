package jp.co.example.java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionFeature {

  public static void main(String[] args) {
    // Function<T, R>
    // Represents a function that accepts one argument and produces a result.
    Function<Integer, String> function1 = (i) -> { return "Test1 : " + i; };
    String result1 = function1.apply(1);
    System.out.println(result1);
    function1.apply(1);
    
    // Consumer<T>
    // Represents an operation that accepts a single input argument and returns no result.
    // Unlike most other functional interfaces, Consumer is expected to operate via side-effects.
    Consumer<Integer> consumer1 = (i) -> { System.out.println("Test2 : " + i ); };
    consumer1.accept(2);
    
    // Predicate<T>
    // Represents a predicate (boolean-valued function) of one argument.
    Predicate<String> predicate1 = (s)-> { return s.equals("Test3"); };
    boolean result = predicate1.test("Test3");
    System.out.println(result);
  }
}
