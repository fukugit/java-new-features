package jp.co.example.java5;

import java.io.Serializable;
import java.util.*;

public class GenericsOfMethod {

  public static void main(String[] args) {
    // The below is good site for Generics.
    // https://qiita.com/rodentia/items/b36d134fa24867ba4d63

    ////// Using generics method, whose result is single.
    String test1 = get("Test1");
    System.out.println(test1);

    ////// Using generics method, whose result is list.
    List<String> test2 = getList("Test2");
    test2.stream().forEach(System.out::println);

    ////// To define the Type inference(型推論) class.
    Map<String, Integer> map1 = getHashMap();
    map1.put("key", 1);
    map1.entrySet().stream().map(e -> e.getKey() + ": " + e.getValue()).forEach(System.out::println);

    Map<String, String> map2 = getHashMap();
    map2.put("key", "val");
    map2.entrySet().stream().map(e -> e.getKey() + ": " + e.getValue()).forEach(System.out::println);

    Map<String, Integer> map3 = getHashMap("key", 1000);
    map3.entrySet().stream().map(e -> e.getKey() + ": " + e.getValue()).forEach(System.out::println);

    ////// Using single 'extends' for generics class.
    List<Integer> test3 = getList(Integer.valueOf(1));
    test3.stream().forEach(System.out::println);

    List<Long> test4 = getList(2L);
    test4.stream().forEach(System.out::println);

    ////// Wild card.
    Set<String> s1 = Set.of("test1", "test2");
    Set<String> s2 = Set.of("test1");
    System.out.println("numElementsInCommon result : " + numElementsInCommon(s1, s2));
    System.out.println("getElementsInCommon result :" + getElementsInCommon(s1, s2).toString());

    List<Number> list2 = Arrays.asList(1L);
    System.out.println("The class type : " + getNum(list2).getClass());
  }

  private static <T> T get(T name) {
    return name;
  }

  private static <T> List<T> getList(T name) {
    List<T> list = new ArrayList<>();
    list.add(name);
    return list;
  }

  public static <K, V> Map<K, V> getHashMap() {
    return new HashMap<K, V>();
  }

  public static <K, V> Map<K, V> getHashMap(K k, V v) {
    Map map = new HashMap<K, V>();
    map.put(k, v);
    return map;
  }

  private static <T extends Number> List<T> getList(T id) {
    List<T> list = new ArrayList<>();
    list.add(id);
    return list;
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

  private static <E> E getNum(Iterable<? extends E> src) {
    for (E e : src) {
      return e;
    }
    return null;
  }
}
