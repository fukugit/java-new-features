package jp.co.example.java5;

import java.util.ArrayList;
import java.util.List;

public class GenericsFeature {
    public static void main(String[] args) {

        List<String> list = generateList("test");
        list.stream().forEach(System.out::println);

        Book book = new BookImpl();
        book.getTitle("AAA");
    }

    public static <T> List<T> generateList(T arg){
        List<T> list = new ArrayList<>();
        list.add(arg);

        return list;
    }

    public interface Book<T> {
        String getTitle(T title);
    }
    public static class BookImpl implements Book<String> {
        @Override
        public String getTitle(String title) {
            return "AAA";
        }
    }
}
