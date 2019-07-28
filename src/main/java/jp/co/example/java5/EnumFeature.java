package jp.co.example.java5;

import java.util.Arrays;
import java.util.Optional;

public class EnumFeature {

  public static void main(String[] args) {
    System.out.println("------- The below code is for Status class. --------");
    System.out.println("Status.SUCCESS:" + Status.SUCCESS);
    System.out.println("Status.SUCCESS.toString():" + Status.SUCCESS.toString());
    Arrays.stream(Status.values()).forEach(System.out::println);

    System.out.println("------- The below code is for Result class. --------");
    System.out.println("Result.SUCCESS.toString():" + Result.SUCCESS.toString());
    System.out.println("Result.SUCCESS.getName():" + Result.SUCCESS.getName());
    System.out.println("Result.SUCCESS.getReturnValue():" + Result.SUCCESS.getReturnValue());
    System.out.println("Result.fromString(\"Success\").toString():" + Result.fromString("Success").toString());

    Result result = Result.fromString("Success");
    System.out.println("result.toString:" + result.toString());
    System.out.println("result.getName:" + result.getName());
    System.out.println("result.getReturnValue:" + result.getReturnValue());

    System.out.println("------- The below code is for Operation class. --------");
    System.out.println("Operation.PLUS.apply:" + Operation.PLUS.apply(10, 20));
    System.out.println("Operation.MINUS.apply:" + Operation.MINUS.apply(10, 20));
    System.out.println("Operation.TIMES.apply:" + Operation.TIMES.apply(10, 20));
    System.out.println("Operation.DIVIDE.apply:" + Operation.DIVIDE.apply(10, 20));

    System.out.println("------- The below code is for PayrollDay class. --------");
    System.out.println("PayrollDay.MONDAY.pay:" + PayrollDay.MONDAY.pay(720, 80));
    System.out.println("PayrollDay.SUNDAY.pay:" + PayrollDay.SUNDAY.pay(720, 80));
    System.out.println("PayrollDay.MONDAY.payType.overtimePay:" + PayrollDay.MONDAY.payType.overtimePay(720, 80));
    System.out.println("PayrollDay.SUNDAY.payType.overtimePay:" + PayrollDay.SUNDAY.payType.overtimePay(720, 80));

    System.out.println("------- The below code is for BasicOperation class. --------");
    System.out.println("BasicOperation.PLUS.apply:" + BasicOperation.PLUS.apply(10, 20));
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

  enum PayrollDay {
    MONDAY(PayType.WEEKDAY),
    SUNDAY(PayType.WEEKEND);

    private final PayType payType;

    PayrollDay(PayType payType) {
      this.payType = payType;
    }

    int pay(int minutesWorked, int payRate) {
      return payType.pay(minutesWorked, payRate);
    }

    private enum PayType {
      WEEKDAY {
        @Override
        int overtimePay(int mins, int payRate) {
          return mins <= MINS_PER_SHIFT ? 0 : (mins - MINS_PER_SHIFT) * payRate / 2;
        }
      },
      WEEKEND {
        @Override
        int overtimePay(int mins, int payRate) {
          return mins * payRate / 2;
        }
      };

      abstract int overtimePay(int mins, int payRate);

      private static final int MINS_PER_SHIFT = 8 * 60;

      int pay(int minsWorked, int payRate) {
        int basePay = minsWorked * payRate;
        return basePay + overtimePay(minsWorked, payRate);
      }
    }
  }

  public interface OperationIF {
    double apply(double x, double y);
  }
  public enum BasicOperation implements OperationIF {
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

    private  final String symbol;

    BasicOperation(String symbol) {
      this.symbol = symbol;
    }

    @Override
    public String toString() {
      return this.symbol;
    }
  }
}
