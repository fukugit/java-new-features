package jp.co.example.java5;

import java.util.Arrays;
import java.util.Optional;

public class EnumFeature {

  public static void main(String[] args) {
    System.out.println("toString:" + Result.SUCCESS.toString());
    System.out.println("getName:" + Result.SUCCESS.getName());
    System.out.println("getReturnValue:" + Result.SUCCESS.getReturnValue());

    Result result = Result.fromString("Success");
    System.out.println("toString:" + result.toString());
    System.out.println("getName:" + result.getName());
    System.out.println("getReturnValue:" + result.getReturnValue());
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
}
