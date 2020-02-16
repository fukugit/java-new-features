package com.github.fukugit.newfeatures.java5.generics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * ワイルドカード<?>がついている場合とついていない場合の動作確認をしていきます。
 */
public class GenericsForWildcard {

  @Nested
  @DisplayName("SetにGenerics無しでの動作確認をします。")
  class NoWildcard {
    @Test
    @DisplayName("SetにGenerics無しで動かします。")
    void test1() {
      // Given
      Set s1 = new HashSet();
      s1.add("a");
      Set s2 = new HashSet();
      s2.add(1);

      // When
      addAll(s1, s2);
      // Then
      assertEquals(true, s1.contains("a"));
      assertEquals(true, s1.contains(1));
    }

    /**
     * s1にs2をaddします。
     * 両パラメータにGenericsを指定しないので、何でも入れることが出来ます。
     * @param s1 任意のSet。
     * @param s2 任意のSet
     */
    void addAll(Set s1, Set s2) {
      s1.addAll(s2);
    }
  }

  @Nested
  @DisplayName("SetにGenerics有りでの動作確認をします。")
  class Wildcard {
    @Test
    @DisplayName("SetにGenerics有りで動かします。")
    void test1() {
      // Given
      Set s1 = new HashSet();
      s1.add("a");
      Set s2 = new HashSet();
      s2.add(1);

      // When
      addAllWithWilidCard(s1, s2);
      // Then
      assertEquals(true, s1.contains(null));
    }

    /**
     * s1にs2をaddします。
     * 両パラメータにGenericsを指定しないので、何でも入れることが出来ます。
     * @param s1 任意のSet。
     * @param s2 任意のSet
     */
    void addAllWithWilidCard(Set<? extends Set<?>> s1, Set<?> s2) {
      /**
       * Set<?>でワイルドカード指定すると、s1に対してはnull以外のいかなる値も入れることができなくなります。
       */
      //s1.add(s2);
      s1.add(null);
    }
  }
}
