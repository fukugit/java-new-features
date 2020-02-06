package com.github.fukugit.newfeatures.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    List<String> list1 = Arrays.asList("Test2", "Test2");
    list1.stream().map(s -> "[" + s + "]").forEach(System.out::println);

    List<String> list2 = Arrays.asList("Test3", "Test3");
    List<String> map2result = list2.stream().map(s -> "[" + s + "]").collect(Collectors.toList());
    map2result.stream().forEach(System.out::println);
    
    List<String> list3 = Arrays.asList("Test4", "Test4");
    List<TestMap> map3result = list3.stream().map(TestMap::new).collect(Collectors.toList());
    map3result.stream().map(s -> s.getName()).forEach(System.out::println);

    // flatMap
    List<String> list4 = Arrays.asList("Test4", "Test4");
    List<Object> result4 = list4.stream().flatMap(x -> Stream.of(x, x.length())).collect(Collectors.toList());
    result4.stream().forEach(System.out::println);

    // filter
    // The feature can judge the behavior based on condition, such as "if" statement.
    List<String> stream5 = Arrays.asList("Test5", "Test5");
    stream5.stream().filter(s -> s.length() > 4).forEach(System.out::println);
    
    
    // Judgement for collection
    // Checking, whether the all of values in List is empty.
    List<String> stream6 = Arrays.asList("Test6", "Test6");
    System.out.println(stream6.stream().allMatch(s -> !s.isEmpty())); //true
    
    // The case of the one of the value condition in List is true, result should be true.
    List<String> stream7 = Arrays.asList("Test7", "Test77777");
    System.out.println(stream7.stream().anyMatch(s -> s.length() > 7)); //true
    
    // Checking, whether nothing true condition in the List.
    List<String> stream8 = Arrays.asList("Test8", "Test8");
    System.out.println(stream8.stream().noneMatch(s -> s.startsWith("B"))); //true
    
    // collect
    List<String> stream9 = Arrays.asList("Test9", "Test9-2");
    List<String> result9 = stream9.stream().filter(s -> "Test9-2".equals(s.toString())).collect(Collectors.toList());
    result9.forEach(System.out::println);  
    
    // Using stream for map object.
    Map<String, String> map = new HashMap<>() {
      {
          put("Test10-1", "1");
          put("Test10-2", "2");
          put("Test10-3", "3");
      }
    };
    map.entrySet().stream()
      .map(s -> s.getKey() + ":" + s.getValue()).forEach(System.out::println);

    // String to Long
    List<String> stream10 = Arrays.asList("100", "200");
    List<Long> result10 = stream10.stream().map(Long::valueOf).collect(Collectors.toList());
    result10.stream().forEach(System.out::println);

    // https://qiita.com/megmogmog1965/items/414e71913ea080232396
    
    // findFirst
    // https://qiita.com/kumazo/items/284098c530fceb05805c
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
