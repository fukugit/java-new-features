package com.github.fukugit.newfeatures.java8;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDateFeature {
  public static void main(String[] args) {
    DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy/M/d");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d");

    // Retrieving local current date.
    LocalDate localdate1 = LocalDate.now();
    System.out.println("Local current date : " + localdate1.format(pattern));

    // LocalDate -> String
    LocalDate localdate2 = LocalDate.now();
    String result2 = localdate2.format(pattern);
    System.out.println("LocalDate -> String : " + result2);

    // String -> LocalDate
    LocalDate localdate3 = LocalDate.parse("2017-1-1", DateTimeFormatter.ofPattern("[yyyy/M/d]" + "[yyyy-M-d]"));
    LocalDate localdate6 = LocalDate.parse("2017/1/1", DateTimeFormatter.ofPattern("[yyyy/M/d]" + "[yyyy-M-d]"));
    System.out.println("String -> LocalDate : " + localdate3);
    System.out.println("String -> LocalDate : " + localdate6);

    // java.util.Date -> LocalDate
    Date date = new Date();
    LocalDate localdate4 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    System.out.println("java.util.Date -> LocalDate : " + localdate4.format(pattern));

    // LocalDate -> java.util.Date
    LocalDate localdate5 = LocalDate.now();
    Date date2 = Date.from(localdate5.atStartOfDay(ZoneId.systemDefault()).toInstant());
    System.out.println("LocalDate -> java.util.Date : " + sdf.format(date2));
  }
}
