package com.github.fukugit.newfeatures.java5.generics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Interfaceにジェネリクス指定した場合の、実クラスの方でどのようにジェネリクスを指定するかを確認するためのクラスです。
 */
@DisplayName("Interfaceにジェネリクス指定した場合の動作確認です。")
class GenericsForInterface {

  /**
   * インターフェースのジェネリクスなので、実クラスでTの型を決定します。
   * このテストクラスでは、Tに{@link Novel}、{@link Magazine}、{@link Book}が指定される想定です。
   * もちろんString, IntegerでもOKです。
   * @param <T> 本の型です。
   */
  private interface BookShelf<T> {
    void pushAll(List<T> t);
    void popAll(List<T> t);
    void setBest(T t);
    T getBest();
  }

  /**
   * これはジェネリクスを複数指定したケースです。
   * リポジトリ層のジェネリクスであれば、TとかEと命名せずにINSERTのような感じで何をするのかを明確にするのもよいと思います。
   * @param <INSERT> insertメソッドの引数及び返却値
   * @param <UPDATE> updateメソッドの引数及び返却値
   */
  private interface BookRepository<INSERT, UPDATE> {
    INSERT insert(INSERT entity);
    UPDATE update(UPDATE entity);
  }

  /**
   * {@link BookShelf}の実クラスです。
   * ジェネリクスには{@link Book}を指定します。
   * 全てのメソッドで、{@link Novel}、{@link Magazine}、{@link Book}が指定できます。
   */
  private class BookShelfImpl implements BookShelf<Book> {
    List<Book> bookList;
    Book best;

    BookShelfImpl(List<Book> bookList, Book best) {
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

  /**
   * {@link BookRepository}の実クラスです。
   * INSERTには{@link Novel}、UPDATEには{@link Magazine}を指定します。
   */
  private class BookRepositoryImpl implements BookRepository<Novel, Magazine> {
    @Override
    public Novel insert(Novel entity) {
      return entity;
    }
    @Override
    public Magazine update(Magazine entity) {
      return entity;
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
  @DisplayName("BookShelfを実行します。")
  class BookShelfTest {
    /**
     * BookShelfにNovelとMagazineをセットします。
     * 取り出し(pop)時はベースクラスのBookとして扱います。
     */
    @Test
    @DisplayName("bestとbookListの値をセット/取得します。")
    void test1() {
      // Given
      Novel novel1 = new Novel("いとしのヒナゴン");
      Novel novel2 = new Novel("流星ワゴン");
      Magazine magazine1 = new Magazine("ポパイ");
      Magazine magazine2 = new Magazine("東京カレンダー");
      Novel bestBefore = new Novel("天国はまだ遠く");
      Novel bestAfter = new Novel("戸村飯店青春100連発");
      // GenericsにはBookクラスを指定します。
      List<Book> results = new ArrayList<>();

      // When
      BookShelf<Book> bookShelf = new BookShelfImpl(List.of(novel1, magazine1), bestBefore);
      bookShelf.pushAll(List.of(novel2, magazine2));
      bookShelf.setBest(bestAfter);
      bookShelf.popAll(results);

      // Then
      assertEquals("戸村飯店青春100連発", bookShelf.getBest().title);
      assertEquals("いとしのヒナゴン", results.get(0).title);
      assertEquals("ポパイ", results.get(1).title);
      assertEquals("流星ワゴン", results.get(2).title);
      assertEquals("東京カレンダー", results.get(3).title);
    }
  }

  @Nested
  @DisplayName("BookRepositoryを実行します。")
  class BookRepositoryTest {
    /**
     * BookRepositoryにNovelとMagazineをセットします。
     */
    @Test
    @DisplayName("insert・updateメソッドを実行します。")
    void test1() {
      // Given
      Novel novel1 = new Novel("いとしのヒナゴン");
      Magazine magazine1 = new Magazine("ポパイ");

      // When
      BookRepository<Novel, Magazine> bookShelf = new BookRepositoryImpl();
      Novel result1 = bookShelf.insert(novel1);
      Magazine result2 = bookShelf.update(magazine1);

      // Then
      assertEquals("いとしのヒナゴン", result1.title);
      assertEquals("ポパイ", result2.title);
    }
  }
}
