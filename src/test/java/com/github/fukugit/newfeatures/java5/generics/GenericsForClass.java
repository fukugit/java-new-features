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
  @DisplayName("BookShelfにNovelを指定します。")
  public class NovelToGenerics {
    @Test
    @DisplayName("bestに値をセット/取得します。")
    void test1() {
      Novel novel = new Novel("いとしのヒナゴン");
      BookShelf<Novel> bookShelf = new BookShelf<>();
      bookShelf.setBest(novel);
      assertEquals("いとしのヒナゴン", bookShelf.getBest().title);
    }
    @Test
    @DisplayName("リストに値をセット/取得します。")
    void test2() {
      Novel novel1 = new Novel("いとしのヒナゴン 上");
      Novel novel2 = new Novel("いとしのヒナゴン 下");
      BookShelf<Novel> bookShelf = new BookShelf<>();
      bookShelf.push(novel1);
      bookShelf.push(novel2);
      assertEquals("いとしのヒナゴン 上", bookShelf.popAll().get(0).title);
      assertEquals("いとしのヒナゴン 下", bookShelf.popAll().get(1).title);
    }
  }

  @Nested
  @DisplayName("BookShelfにMagazineを指定します。")
  public class MagazineToGenerics {
    @Test
    @DisplayName("bestに値をセット/取得します。")
    void test1() {
      Magazine magazine = new Magazine("少年ジャンプ");
      BookShelf<Magazine> bookShelf = new BookShelf<>();
      bookShelf.setBest(magazine);
      assertEquals("少年ジャンプ", bookShelf.getBest().title);
    }
  }

  @Nested
  @DisplayName("BookShelfにStringを指定します。")
  public class StringToGenerics {
    @Test
    @DisplayName("bestに値をセット/取得します。")
    void test1() {
      String subject = "青空文庫";
      BookShelf<String> bookShelf = new BookShelf<>();
      bookShelf.setBest(subject);
      assertEquals("青空文庫", bookShelf.getBest());
    }
  }

  /**
   * 本棚<br>
   * 本のListとベストブックを持つクラスです。<br>
   * 本の型はジェネリクス指定しているので、どのような型でもOKです。<br>
   * <br>
   * 本クラス内のT(ジェネリクス)は全てObjectとして扱われます。
   * @param <T> 本クラスを指定して下さい。
   */
  public class BookShelf<T> {
    List<T> bookList = new ArrayList<>();
    T best;
    public void push(T t) {
      bookList.add(t);
    }
    public List<T> popAll() {
      return bookList;
    }
    public void setBest(T t) {
      best = t;
    }
    public T getBest() {
      return best;
    }
  }

  /**
   * 小説<br>
   * Bookを継承したクラスです。
   */
  public class Novel extends Book {
    public Novel(String title) {
      super(title);
    }
  }

  /**
   * 雑誌<br>
   * Bookを継承したクラスです。
   */
  public class Magazine extends Book {
    public Magazine(String title) {
      super(title);
    }
  }

  /**
   * 本関連クラスのベースクラスです。
   */
  public abstract class Book {
    public Book(String title) {
      this.title = title;
    }
    String title;
  }
}
