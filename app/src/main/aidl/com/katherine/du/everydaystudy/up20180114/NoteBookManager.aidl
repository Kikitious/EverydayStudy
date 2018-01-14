// NoteBookManager.aidl
package com.katherine.du.everydaystudy.up20180114;
import com.katherine.du.everydaystudy.up20180114.NoteBook;

// Declare any non-default types here with import statements

interface NoteBookManager {

    List<NoteBook> getBooks();

    void addBook(in NoteBook notebook);
}
