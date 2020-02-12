package com.github.fukugit.newfeatures.java5.generics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Interfaceにジェネリクス指定した場合の動作確認です。")
public class GenericsForInterface {

  public interface BookShelf<BOOK> {
    public void pushAll(List<BOOK> t);
    public void popAll(List<BOOK> t);
    public void setBest(BOOK t);
    public BOOK getBest();
  }

  public class BookShelfImpl implements BookShelf<Book> {
    List<Book> bookList;
    Book best;

    public BookShelfImpl(List<Book> bookList, Book best) {
      this.bookList = new ArrayList<>(bookList);
      this.best = best;
    }

    @Override
    public void pushAll(List<Book> t) {
      bookList.addAll(t);
    }
    @Override
    public void popAll(List<Book> t) {
      t.addAll(bookList);
    }
    @Override
    public void setBest(Book t) {
      best = t;
    }
    @Override
    public Book getBest() {
      return best;
    }
  }

  /** 小説クラス */
  public class Novel extends Book {
    public Novel(String title) {
      super(title);
    }
  }

  /** 雑誌クラス */
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

  @Nested
  @DisplayName("BookShelfにNovelを指定します。")
  public class NovelToGenerics {
    @Test
    @DisplayName("bestとbookListの値をセット/取得します。")
    void test1() {
      // Given
      Novel novel1 = new Novel("いとしのヒナゴン");
      Novel novel2 = new Novel("流星ワゴン");
      List<Book> results = new ArrayList<>();
      // When
      BookShelfImpl bookShelf = new BookShelfImpl(List.of(novel1), novel2);
      bookShelf.pushAll(List.of(novel2));
      bookShelf.setBest(novel1);
      bookShelf.popAll(results);
      // Then
      assertEquals("いとしのヒナゴン", bookShelf.getBest().title);
      assertEquals("いとしのヒナゴン", results.get(0).title);
      assertEquals("流星ワゴン", results.get(1).title);
    }
  }
}
