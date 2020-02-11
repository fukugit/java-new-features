package com.github.fukugit.newfeatures.java5.generics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("ジェネリクスのextendsとsuperの動作確認をします。")
public class GenericsForExtendsSuper {

  /**
   * 本棚クラス<br>
   * 本のListを持つクラスです。<br>
   * 本の型はジェネリクス指定しているので、Stringでもオリジナルクラスでもどのような型でもOKです。<br>
   * コンストラクタでextends指定しているため、ジェネリクスへ指定した型の子クラスもListへ入れることが可能です。<br>
   * <br>
   * 注意：このクラス内のT(ジェネリクス)は全てObjectとして扱われます。
   * @param <T> 本を表現するクラスを指定して下さい。
   */
  public class BookShelf<T> {
    List<T> bookList;

    /**
     * コンストラクタ<br>
     * extendsを指定しているので、引数へ渡す時のListの型はTかTの子クラスでなければいけません。<br>
     * @param bookList プロデューサ(供給)なので、Tを継承しているクラスのリストを指定します。
     */
    public BookShelf(List<? extends T> bookList) {
      this.bookList = new ArrayList<>(bookList);
    }

    /**
     * リストへpushします。<br>
     * extendsを指定しているので、引数へ渡す時のListの型はTかTの子クラスでなければいけません。<br>
     * @param t プロデューサ(供給)なので、Tを継承しているクラスのリストを指定します。
     */
    public void pushAll(List<? extends T> t) {
      bookList.addAll(t);
    }

    /**
     * 指定されたリストへ、bookListをaddします。<br>
     * superを使っているので、引数へ渡す時のListの型はTかTの親クラスでなければいけません。<br>
     * @param t コンシューマ(消費)なので、Tの親クラスのリストを指定します。
     */
    public void popAll(List<? super T> t) {
      t.addAll(bookList);
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

  /** 本関連クラスのベースクラスです。 */
  public abstract class Book {
    public Book(String title) {
      this.title = title;
    }
    String title;
  }

  @Nested
  @DisplayName("BookShelfにBookを指定します。")
  public class NovelToGenerics {
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
