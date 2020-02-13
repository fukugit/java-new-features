package com.github.fukugit.newfeatures.java5.generics;

import com.github.fukugit.newfeatures.keymap.Magazin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Interfaceにジェネリクス指定した場合の動作確認です。")
public class GenericsForInterface {

  public interface BookShelf<BOOK> {
    void pushAll(List<BOOK> t);
    void popAll(List<BOOK> t);
    void setBest(BOOK t);
    BOOK getBest();
  }

  public interface BookRepository<INSERT, UPDATE> {
    INSERT insert(INSERT entity);
    UPDATE update(UPDATE entity);
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

  public class BookRepositoryImpl implements BookRepository<Novel, Magazine> {

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
  @DisplayName("BookShelfにBookを指定します。")
  public class NovelToGenerics {
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
}
