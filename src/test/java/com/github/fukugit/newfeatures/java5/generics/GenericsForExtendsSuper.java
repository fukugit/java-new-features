package com.github.fukugit.newfeatures.java5.generics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("ジェネリクスのextendsとsuperの動作確認をします。")
class GenericsForExtendsSuper {

  /**
   * PECS(Producer extends and Consumer super)を学ぶためのクラスです。
   * <p>PECSとは、{@code <? extends T>}や{@code <? super T>}のことを表しています。
   * {@code <? extends T>}のことは、プロデューサ(供給)と呼びます。
   * {@code <? super T>}のことは、コンシューマ(消費)と呼びます。
   *
   * <p>{@code <? extends T>}は、ジェネリクスで指定した子クラスを表現しています。
   * 例えば、ジェネリクスに{@link Number}を指定して場合の{@code <? extends T>}は、
   * {@link Long}や{@link Integer}が指定可能です。
   *
   * <p>{@code <? super T>}は、ジェネリクスで指定した親クラスを表現しています。
   * 例えば、ジェネリクスに{@link Long}を指定した場合の{@code <? super T>}は、
   * {@link Number}や{@link Object}が指定可能です。
   *
   * <p>一般的には、クラス内のメンバ変数へ値をセットする時は、
   * {@code <? extends T>}でジェネリクスの子クラスをセットして、
   * メンバ変数の値を取得するときは{@code <? super T>}で親クラスを取得します。
   *
   * @param <T> 本を表現するクラスを指定して下さい。
   */
  private class BookShelf<T> {
    List<T> bookList;

    /**
     * @param bookList {@code <? extends T>}なのでTの子クラスのリストを指定して下さい。
     */
    BookShelf(List<? extends T> bookList) {
      this.bookList = new ArrayList<>(bookList);
    }

    /**
     * メンバ変数へpushします。
     * @param t {@code <? extends T>}なのでTの子クラスのリストを指定して下さい。
     */
    void pushAll(List<? extends T> t) {
      bookList.addAll(t);
    }

    /**
     * メンバ変数の値を引数へaddします。
     * @param t {@code <? extends T>}なのでTの親クラスのリストを指定して下さい。
     */
    void popAll(List<? super T> t) {
      t.addAll(bookList);
    }

    /**
     * @return 戻り値に{@code <? extends T>}や{@code <? super T>}を指定しても意味がありません。
     */
     List<? super T> getList1() {
       return bookList;
     }

    /**
     * @return 戻り値のジェネリクスはこちらが妥当です。
     */
    List<T> getList2() {
      return bookList;
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

  /** 本関連クラスのベースクラスです。 */
  abstract class Book {
    private Book(String title) {
      this.title = title;
    }
    String title;
  }

  @Nested
  @DisplayName("BookShelfにBookを指定します。")
  class NovelToGenerics {
    @Test
    @DisplayName("bookListの値をセット/取得します。")
    void test1() {
      // Given
      Novel novel1 = new Novel("いとしのヒナゴン");
      Novel novel2 = new Novel("流星ワゴン");
      Magazine magazine1 = new Magazine("ポパイ");
      Magazine magazine2 = new Magazine("東京カレンダー");
      List<Book> results = new ArrayList<>();
      // When
      BookShelf<Book> bookShelf = new BookShelf<>(List.of(novel1, magazine1));
      bookShelf.pushAll(List.of(novel2));
      bookShelf.pushAll(List.of(magazine2));
      // Then
      bookShelf.popAll(results);
      assertEquals("いとしのヒナゴン", results.get(0).title);
      assertEquals("ポパイ", results.get(1).title);
      assertEquals("流星ワゴン", results.get(2).title);
      assertEquals("東京カレンダー", results.get(3).title);
    }
  }
}
