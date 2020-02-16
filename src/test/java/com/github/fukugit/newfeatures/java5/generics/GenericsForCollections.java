package com.github.fukugit.newfeatures.java5.generics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 再帰型境界{@code <T extends Comparable<? super T>>}の確認のため、Collectionsの動作確認をします。
 */
@DisplayName("再帰型境界の確認のためのCollectionsの動作確認です。")
public class GenericsForCollections {

  @Nested
  @DisplayName("Collections.sortを使います")
  class Sort {
    /**
     * {@link Collections#sort(List)}のジェネリクスは、{@code <T extends Comparable<? super T>>}です。
     * {@link Integer}は、{@link Comparable}をimplementしているのでこのジェネリクス型に該当します。
     */
    @Test
    @DisplayName("Integerのリストでsortの確認します。")
    void test1() {
      // Given
      List<Integer> list = new ArrayList<>();
      list.add(2);
      list.add(1);
      list.add(3);
      // When
      Collections.sort(list);
      // Then
      assertEquals(1, list.get(0));
      assertEquals(2, list.get(1));
      assertEquals(3, list.get(2));
    }
  }

  @Nested
  @DisplayName("Collections.maxを使います")
  class Max {
    /**
     * {@link Collections#max(Collection)}のジェネリクスは、{@code <T extends Object & Comparable<? super T>>}です。
     * {@link Integer}は、{@link Comparable}をimplementしているのでこのジェネリクス型に該当します。
     */
    @Test
    @DisplayName("Integerのリストでmaxの確認します。")
    void test1() {
      // Given
      List<Integer> list = new ArrayList<>();
      list.add(2);
      list.add(1);
      list.add(3);
      // When
      Integer max = Collections.max(list);
      // Then
      assertEquals(3, max);
    }
  }
}
