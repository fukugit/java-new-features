package com.github.fukugit.newfeatures.java5.generics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("ジェネリクスのExtendsとSuperの動作確認をします。")
public class GenericsForExtendsSuper {

  @Nested
  @DisplayName("BookShelfにBookを指定します。")
  public class NovelToGenerics {
    @Test
    @DisplayName("extendsとsuperの違いを確認します。")
    void test1() {
      Novel novel = new Novel("いとしのヒナゴン");
      Magazine magazine = new Magazine("ポパイ");

      BookShelf<Book> bookShelf = new BookShelf<>();
      bookShelf.push(List.of(novel));
      bookShelf.push(List.of(magazine));

      List<Book> results = new ArrayList<>();
      bookShelf.popAll(results);
      assertEquals("いとしのヒナゴン", results.get(0).title);
      assertEquals("ポパイ", results.get(1).title);
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
    public void push(List<? extends T> t) {
      bookList.addAll(t);
    }
    public void popAll(List<? super T> t) {
      t.addAll(bookList);
    }
  }

  /**
   * 小説
   */
  public class Novel extends Book {
    public Novel(String title) {
      super(title);
    }
  }

  /**
   * 雑誌
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
