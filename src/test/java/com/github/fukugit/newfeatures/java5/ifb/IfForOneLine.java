package com.github.fukugit.newfeatures.java5.ifb;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IfForOneLine {

  @Test
  @DisplayName("Ifの結果がTrueの場合に処理を終了させる書き方。")
  static void test1() {
    // When
    // このメソッドの戻り値がbooleanの場合は、return falseのような書き方になります。
    if("test".equals("test")) return;
    // Then
    // ここには処理が到達しません。
    assertEquals("test", "");
  }
}
