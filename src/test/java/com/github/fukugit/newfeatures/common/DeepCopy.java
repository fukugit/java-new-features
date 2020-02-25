package com.github.fukugit.newfeatures.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;

public class DeepCopy {
  class CopyBook {
    String[] titles;
    Date date;

    public String[] getTitles() {
      if (titles == null) return null;
      return Arrays.copyOf(titles, titles.length);
    }

    public Date getDate() {
      if(date == null) return null;
      return Date.from(date.toInstant());
    }

    public void setTitles(String[] titles) {
      if (titles == null) return;
      this.titles = Arrays.copyOf(titles, titles.length);
    }

    public void setDate(Date date) {
      if(date == null) return;
      this.date = Date.from(date.toInstant());
    }
  }

  class NonCopyBook {
    String[] titles;
    Date date;

    public String[] getTitles() {
      return titles;
    }

    public Date getDate() {
      return date;
    }

    public void setTitles(String[] titles) {
      this.titles = titles;
    }

    public void setDate(Date date) {
      this.date = date;
    }
  }

  @Test
  @DisplayName("bestとbookListの値をセット/取得します。")
  void test1() {
    // Given
    CopyBook book = new CopyBook();
    book.setTitles(new String[]{"1", "2"});

    // When
    // Then
  }
}
