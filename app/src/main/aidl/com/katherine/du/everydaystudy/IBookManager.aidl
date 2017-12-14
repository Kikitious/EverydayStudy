// IBookManager.aidl
package com.katherine.du.everydaystudy;

import com.katherine.du.everydaystudy.Book;

interface IBookManager {
    List<Book> getBookList();
    void addBook(in Book book);
}
