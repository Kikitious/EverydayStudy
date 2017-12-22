package com.katherine.du.everydaystudy.up20171222.javadefault;

/**
 * Created by du on 17/12/22.
 */

public class Test {

    public static void main(String[] args) {
        BookStore store = new BookStore();
        Reader reader1 = new Reader(store, "Katherine");
        Reader reader2 = new Reader(store, "Bob");
        store.pushlishBookInfo("奇特的一生");
    }
}
