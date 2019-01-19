package jp.co.example.java5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericsOfMethod {

  public static void main(String[] args) {
    // Using generics method, whose result is single.
    String test1 = get("Test1");
    System.out.println(test1);
    
    // Using generics method, whose result is list.
    List<String> test2 = getList("Test2");
    test2.stream().forEach(System.out::println);
    
    // Able to be Type inference(型推論)
    Map<String, Integer> map1 = getHashMap();
    map1.put("key", 1);
    map1.entrySet().stream().map(e -> e.getKey() + ": " + e.getValue()).forEach(System.out::println);
    
    Map<String, String> map2 = getHashMap();
    map2.put("key", "val");
    map2.entrySet().stream().map(e -> e.getKey() + ": " + e.getValue()).forEach(System.out::println);
  }

  private static <T> T get(T name) {
    return name;
  }

  private static <T> List<T> getList(T name) {
    List<T> list = new ArrayList<>();
    list.add(name);
    return list;
  }

  public static <K, V> HashMap<K, V> getHashMap(){
    return new HashMap<K, V>();
  }
}
