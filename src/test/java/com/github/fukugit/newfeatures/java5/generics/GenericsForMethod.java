package com.github.fukugit.newfeatures.java5.generics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("staticメソッドにジェネリクス指定した場合の動作確認です。")
class GenericsForMethod {
  private static <T> T get(T name) {
    return name;
  }

  @Nested
  @DisplayName("getメソッドの動作確認")
  static class NovelToGenerics {
    @Test
    @DisplayName("引数へStringを指定します。")
    static void test1() {
      // Given
      // When
      String result = get("test");
      // Then
      assertEquals("test", result);
    }
  }
}
