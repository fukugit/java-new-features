package jp.co.example.java8;

public class FunctionalInterfaceFeature {

  public static void main(String[] args) {
    Book book = (String subject) -> {return "Subject : " + subject;};
    System.out.println(book.showTitle("AAA"));
  }
  @FunctionalInterface
  interface Book{
      public String showTitle(String name);
  }
}

