package jp.co.example.java8;

import java.util.Optional;

public class OptionalFeature {
    public static void main(String[] args) throws Exception {
        // The below is Javadoc.
        // https://docs.oracle.com/javase/jp/8/docs/api/java/util/Optional.html

        Optional<String> title = Optional.ofNullable(get());
        String result1 = title.orElseThrow(() ->new Exception("Value is null. "));
        System.out.println(result1);

        if (title.isPresent()) System.out.println("Value is not null");

        Optional<String> title2 = Optional.ofNullable(null);
        String result2 = title2.orElse("This is null.");
        System.out.println(result2);

        Optional<String> title3 = Optional.ofNullable(null);
        String result3 = title3.orElseGet(() -> get());
        System.out.println(result3);

    }

    private static String get() {
        return "This is result of get method.";
    }
}
