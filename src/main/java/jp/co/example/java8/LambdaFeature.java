package jp.co.example.java8;

import java.util.Arrays;
import java.util.List;

public class LambdaFeature {

  public static void main(String[] args) {
    // Not Lambda.
    Runnable run = new Runnable() {
      @Override
      public void run() {
        System.out.println("This is not Lambda.");
      }
    };
    run.run();

    // Single line in Lambda.
    Run run1 = (String name) -> name + "!";
    System.out.println(run1.show("Single line in Lambda"));
    
    // Multiple line in Lambda.
    Run run2 = (String name) -> {
      String result = name + "!";
      return result + "!";
    };
    System.out.println(run2.show("Multiple line in Lambda"));


    Run run4 = (name) -> {return name + "!";};
    Run run5 = name -> {return name + "!";};
    System.out.println(run4.show("test 4"));
    System.out.println(run5.show("test 5"));

    Run run6 = (String::toUpperCase);
    System.out.println(run6.show("test 6"));
  }


  @FunctionalInterface
  interface Run {
      public String show(String name);
      public default String getName(String name) {return name;};
  }
}
