package jp.co.example.java8;

import java.util.Arrays;
import java.util.List;

public class LambdaFeature {

  public static void main(String[] args) {
    // Not Lambda.
    Runnable run = new Runnable() {
      @Override
      public void run() {
        System.out.println("test");
      }
    };
    run.run();;

    // 1st way
    Runnable run1 = () -> {System.out.println("test 1");};
    run1.run();

    // 2nd way
    runRunnable(()->{System.out.println("test 2");});
    
    // 3rd way
    List<String> list = Arrays.asList("AA", "BB", "CC");
    list.stream().forEach((String s) -> System.out.println(s));
    
    // 4th way
    Run3 run3 = (String name) -> {return name + "!";};
    System.out.println(run3.show("test 3"));
  }

  public static void runRunnable(Runnable r) {
    r.run();
  }

  @FunctionalInterface
  interface Run3{
      public String show(String name);
      public default String getName(String name) {return name;};
  }
}
