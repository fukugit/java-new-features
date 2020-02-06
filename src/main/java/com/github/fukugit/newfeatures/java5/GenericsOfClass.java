package com.github.fukugit.newfeatures.java5;

import java.util.ArrayList;
import java.util.List;

public class GenericsOfClass {

  public static void main(String[] args) {
    
    Book<Integer> book = new Book<>();
    
    System.out.println(book.set(Integer.valueOf(1)));
    
    book.add(Integer.valueOf(100)).stream().forEach(System.out::println);
  }
  
  public static class Book<T> {
    private T t;
    private List<T> list = new ArrayList<T>();
    
    public String set(T arg){
      this.t = arg;
      return t.toString();
    }
    
    public List<T> add(T arg){
      list.add(arg);
      return list;
    }
  }

}
