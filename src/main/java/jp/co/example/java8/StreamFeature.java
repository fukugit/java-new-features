package jp.co.example.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFeature {

  public static void main(String[] args) {
    
    // The following web site is very useful to learn Stream feature of Java 8.
    // http://d.hatena.ne.jp/nowokay/20130504
    
    // forEach
    // This function can be loop instead of "for", and is most basic one in the stream feature.
    List<String> stream1 = Arrays.asList("Test1", "Test1");
    stream1.stream().forEach(s -> System.out.println(s));
    
    // map
    // The feature can change the value in the stream.
    List<String> map1 = Arrays.asList("Test2", "Test2");
    map1.stream().map(s -> "[" + s + "]").forEach(System.out::println);
    
    List<String> map2 = Arrays.asList("Test3", "Test3");
    List<String> map2result = map2.stream().map(s -> "[" + s + "]").collect(Collectors.toList());
    map2result.stream().forEach(System.out::println);
    
    List<String> map3 = Arrays.asList("Test4", "Test4");
    List<TestMap> map3result = map3.stream().map(TestMap::new).collect(Collectors.toList());
    map3result.stream().map(s -> s.getName()).forEach(System.out::println);
    
    // filter
    
    // collect
    
  }
  private static class TestMap {
    public TestMap(String name) {
      this.name = name;
    }
    String name;
    public String getName() {
      return name;
    }
  }
}
