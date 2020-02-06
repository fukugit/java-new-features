package com.github.fukugit.newfeatures.keymap;

public class BookImpl implements Book {
    public static String getTitle() {
        return "book title";
    }
    
    @Override
    public Long getPrice() {
        Long price = 1000L;
        price += 100L;
        return price;
    }
}
