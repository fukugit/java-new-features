package jp.co.example.keymap;

public class BookImpl implements Book {
    public static String getTitle() {
        return "book title";
    }

    @Override
    public Long getPrice() {
        return 1000L;
    }
}
