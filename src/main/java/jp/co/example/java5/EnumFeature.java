package jp.co.example.java5;

import java.util.Arrays;
import java.util.Optional;

public class EnumFeature {

  public static void main(String[] args) {
    System.out.println("The below code is for Status class. --------");
    System.out.println("Status.SUCCESS:" + Status.SUCCESS);
    System.out.println("Status.SUCCESS.toString():" + Status.SUCCESS.toString());

    System.out.println("The below code is for Result class. --------");
    System.out.println("Result.SUCCESS.toString():" + Result.SUCCESS.toString());
    System.out.println("Result.SUCCESS.getName():" + Result.SUCCESS.getName());
    System.out.println("Result.SUCCESS.getReturnValue():" + Result.SUCCESS.getReturnValue());

    Result result = Result.fromString("Success");
    System.out.println("result.toString:" + result.toString());
    System.out.println("result.getName:" + result.getName());
    System.out.println("result.getReturnValue:" + result.getReturnValue());

    System.out.println("The below code is for Operation class. --------");
    // TODO add for Operation class logic.
  }

  public enum Status {
    SUCCESS, FAIL;
  }

  public enum Result {
    
    SUCCESS("Success", 0),
    FAIL("Fail", -1);

    private String name;
    private Integer returnValue;

    public String getName() {
        return name;
    }
    public Integer getReturnValue() {
      return returnValue;
    }

    private Result (String name, Integer returnValue) {
      this.name = name;
      this.returnValue = returnValue;
    }

    public String toString() {
      return name;
    }

    public static Result fromString(String str) {
      Result[] results = Result.values();
      Optional<Result> result = Arrays.stream(results)
                            .filter(s -> str.equals(s.toString())).findFirst();
        return result.get();
    }
  }

  public enum Operation {
    PLUS("+") {
      @Override
      public double apply(double x, double y) {
        return x + y;
      }
    },
    MINUS("-") {
      @Override
      public double apply(double x, double y) {
        return x - y;
      }
    },
    TIMES("*") {
      @Override
      public double apply(double x, double y) {
        return x * y;
      }
    },
    DIVIDE("/") {
      @Override
      public double apply(double x, double y) {
        return x / y;
      }
    };

    private final String symbol;

    Operation(String symbol) {
      this.symbol = symbol;
    }

    @Override
    public String toString() {
      return this.symbol;
    }

    public abstract double apply(double x, double y);
  }
}
