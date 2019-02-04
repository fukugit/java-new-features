package jp.co.example.java5;

import java.util.Arrays;
import java.util.Optional;

public class EnumFeature {

  public static void main(String[] args) {
    Result result = Result.get("Success");
    System.out.println(result.getName());
  }

  public enum Result {
    
    SUCCESS("Success"),
    FAIL("Fail");

    private String name;

    public String getName() {
        return name;
    }

    private Result (String name) {
      this.name = name;
    }

    public String toString() {
      return name;
    }

    public static Result get(String str) {
      Result[] results = Result.values();
      Optional<Result> result = Arrays.stream(results)
                            .filter(s -> str.equals(s.toString())).findFirst();
        return result.get();
    }
}
}
