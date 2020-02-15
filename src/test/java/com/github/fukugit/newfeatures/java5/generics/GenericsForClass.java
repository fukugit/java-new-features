package com.github.fukugit.newfeatures.java5.generics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("クラスにジェネリクス指定した場合の動作確認です。")
class GenericsForClass {

  /**
   * 本棚クラス
   * 本のListとベストブックを持つクラスです。
   * 本の型はジェネリクス指定しているので、Stringでも独自クラスでもどのような型でもOKです。
   * <br>
   * 注意：このクラス内のT(ジェネリクス)は全てObjectとして扱われます。
   * @param <T> 本を表現するクラスを指定して下さい。
   */
   private class BookShelf<T> {
    List<T> bookList;
    T best;

    BookShelf(List<T> bookList, T best) {
      this.bookList = new ArrayList<>(bookList);
      this.best = best;
    }

    void pushAll(List<T> t) {
      bookList.addAll(t);
    }
    void popAll(List<T> t) {
      t.addAll(bookList);
    }
    void setBest(T t) {
      best = t;
    }
    T getBest() {
      return best;
    }
  }

  /** 小説クラス */
  private class Novel extends Book {
    Novel(String title) {
      super(title);
    }
  }

  /** 雑誌クラス */
  private class Magazine extends Book {
    Magazine(String title) {
      super(title);
    }
  }

  /**
   * 本関連クラスのベースクラスです。
   */
  private abstract class Book {
    Book(String title) {
      this.title = title;
    }
    String title;
  }

  @Nested
  @DisplayName("BookShelfにNovelを指定します。")
  class NovelToGenerics {
    @Test
    @DisplayName("bestとbookListの値をセット/取得します。")
    void test1() {
      // Given
      Novel novel1 = new Novel("いとしのヒナゴン");
      Novel novel2 = new Novel("流星ワゴン");
      List<Novel> results = new ArrayList<>();
      // When
      BookShelf<Novel> bookShelf = new BookShelf(List.of(novel1), "うーん、思いつかない");
      bookShelf.pushAll(List.of(novel2));
      bookShelf.setBest(novel1);
      bookShelf.popAll(results);
      // Then
      assertEquals("いとしのヒナゴン", bookShelf.getBest().title);
      assertEquals("いとしのヒナゴン", results.get(0).title);
      assertEquals("流星ワゴン", results.get(1).title);
    }
  }

  @Nested
  @DisplayName("BookShelfにMagazineを指定します。")
  class MagazineToGenerics {
    @Test
    @DisplayName("bestとbookListの値をセット/取得します。")
    void test1() {
      // Given
      Magazine magazine1 = new Magazine("ポパイ");
      Magazine magazine2 = new Magazine("東京カレンダー");
      List<Magazine> results = new ArrayList<>();
      // When
      BookShelf<Magazine> bookShelf = new BookShelf(List.of(magazine1), "うーん、思いつかない");
      bookShelf.pushAll(List.of(magazine2));
      bookShelf.setBest(magazine1);
      bookShelf.popAll(results);
      // Then
      assertEquals("ポパイ", bookShelf.getBest().title);
      assertEquals("ポパイ", results.get(0).title);
      assertEquals("東京カレンダー", results.get(1).title);
    }
  }

  @Nested
  @DisplayName("BookShelfにStringを指定します。")
  class StringToGenerics {
    @Test
    @DisplayName("bestとbookListの値をセット/取得します。")
    void test1() {
      // Given
      String magazine1 = "ドラえもん";
      String magazine2 = "キテレツ";
      List<String> results = new ArrayList<>();
      // When
      BookShelf<String> bookShelf = new BookShelf(List.of(magazine1), "うーん、思いつかない");
      bookShelf.pushAll(List.of(magazine2));
      bookShelf.setBest(magazine1);
      bookShelf.popAll(results);
      // Then
      assertEquals("ドラえもん", bookShelf.getBest());
      assertEquals("ドラえもん", results.get(0));
      assertEquals("キテレツ", results.get(1));
    }
  }


}
