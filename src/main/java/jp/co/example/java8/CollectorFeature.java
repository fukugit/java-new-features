package jp.co.example.java8;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class CollectorFeature {

  // Refer the below site for spec. I implemented this class referring the below document.  
  //https://qiita.com/civic/items/b5800ab4b620a53a9be1
  
  public static void main(String[] args) {
    Stream<String> stream = Arrays.asList("Hello", "World", "Java8", "Stream", "API").stream();
    String commaJoinedString = stream.collect(new MyStringJoinCollector());
    System.out.println(commaJoinedString);
  }

  private static class MyStringJoinCollector 
    implements Collector<String, StringBuilder, String> {

    @Override
    public Supplier<StringBuilder> supplier() {
      // This method should create the 2nd parameter of StringBuilder, which is for intermediate variable.
      return ()->new StringBuilder();
    }
    
    @Override
    public BiConsumer<StringBuilder, String> accumulator() {
      // This method defines contents of "for" loop.  
      return (sb, s) -> {
        if (sb.length() != 0){
            sb.append(",");
        }
        sb.append(s);
      };
    }

    @Override
    public Function<StringBuilder, String> finisher() {
      // This method process define procedure of after "for".
      return sb -> sb.toString();
    }
    
    @Override
    public BinaryOperator<StringBuilder> combiner() {
      return (sb1, sb2) ->{
        sb1.append(sb2);
        return sb1;
      };
    }
    
    @Override
    public Set<Characteristics> characteristics() {
      return EnumSet.noneOf(Characteristics.class);
    }
  }
}

