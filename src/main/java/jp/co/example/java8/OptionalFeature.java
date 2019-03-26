package jp.co.example.java8;

import java.util.Optional;

public class OptionalFeature {
    public static void main(String[] args) throws Exception {
        // The below is Javadoc.
        // https://docs.oracle.com/javase/jp/8/docs/api/java/util/Optional.html

        Optional<String> title = Optional.ofNullable(get());
        String result = title.orElseThrow(() ->new Exception("Value is null. "));
        System.out.println(result);

        if (title.isPresent()) {
            System.out.println("Not null");
        }
    }

    private static String get() {
        return "test";
    }
}
