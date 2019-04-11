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


    // Type(String) is omitted.
    Run run4 = (name) -> {return name + "!";};
    System.out.println(run4.show("Type(String) is omitted"));

    // Brackets() are omitted.
    Run run5 = name -> {return name + "!";};
    System.out.println(run5.show("Brackets() are omitted"));

    // Using method reference.
    Run run6 = (String::toUpperCase);
    System.out.println(run6.show("Using method reference."));

    // Arguments are multiple.
    // In this case, Brackets() are not able to be omitted.
    RunMultiple run7 = (name, age) -> "Name:" + name + " Age:" + age;
    System.out.println(run7.show("Test", 20));
  }


  @FunctionalInterface
  interface Run {
      public String show(String name);
      public default String getName(String name) {return name;};
  }
  @FunctionalInterface
  interface RunMultiple {
    public String show(String name, Integer age);
    public default String getName(String name) {return name;};
  }
}
