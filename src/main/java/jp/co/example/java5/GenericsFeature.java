package jp.co.example.java5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenericsFeature {
    public static void main(String[] args) {

        List<String> list = generateList("test");
        list.stream().forEach(System.out::println);

        Book book = new BookImpl();
        book.getTitle("AAA");

        Set<String> s1 = Set.of("test1","test2");
        Set<String> s2 = Set.of("test1");
        System.out.println("numElementsInCommon result : " + numElementsInCommon(s1, s2));
        System.out.println("getElementsInCommon result :" + getElementsInCommon(s1, s2).toString());
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

    private static int numElementsInCommon(Set<?> s1, Set<?> s2) {
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result++;
            }
        }
        return result;
    }

    private static Set<?> getElementsInCommon(Set<?> s1, Set<?> s2) {
        Set<Object> result = new HashSet<>();
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result.add(o1);
            }
        }
        return result;
    }
}
