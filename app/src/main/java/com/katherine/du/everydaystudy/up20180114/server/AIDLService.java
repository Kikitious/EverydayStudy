package com.katherine.du.everydaystudy.up20180114.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.katherine.du.everydaystudy.up20180114.NoteBook;
import com.katherine.du.everydaystudy.up20180114.NoteBookManager;

import java.util.ArrayList;
import java.util.List;


public class AIDLService extends Service {


    private List<NoteBook> books = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        NoteBook book = new NoteBook();
        book.setName("Android第一行代码");
        books.add(book);

    }

    private NoteBookManager.Stub noteBookManager = new NoteBookManager.Stub() {

        @Override
        public List<NoteBook> getBooks() throws RemoteException {
            return books;
        }

        @Override
        public void addBook(NoteBook notebook) throws RemoteException {
            books.add(notebook);
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return noteBookManager;
    }


}
