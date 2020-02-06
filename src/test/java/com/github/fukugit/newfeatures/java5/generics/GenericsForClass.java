package com.github.fukugit.newfeatures.java5.generics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("ジェネリクスを使ったクラスの動作確認です。")
public class GenericsForClass {

  @Nested
  public class GenericsBase {
    @Test
    @DisplayName("BookShelfのジェネリクスにNovelを指定します。")
    void test1() {
      Novel novel = new Novel();
      novel.title = "いとしのヒナゴン";
      BookShelf<Novel> bookShelf = new BookShelf<>();
      bookShelf.setBest(novel);
      assertEquals("いとしのヒナゴン", bookShelf.getBest().title);
    }
  }

  public class BookShelf<T> {
    List<T> bookList = new ArrayList<>();
    T best;
    public List<T> add(T t) {
      bookList.add(t);
      return bookList;
    }
    public void setBest(T t) {
      best = t;
    }
    public T getBest() {
      return best;
    }
  }

  public class Novel {
    String title;
  }
}
