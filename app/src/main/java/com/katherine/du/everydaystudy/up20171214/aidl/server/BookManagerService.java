package com.katherine.du.everydaystudy.up20171214.aidl.server;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.katherine.du.everydaystudy.IBookManager;
import com.katherine.du.everydaystudy.Book;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by du on 17/12/14.
 */

public class BookManagerService extends Service {

    private static final String TAG = "BMS";
    private CopyOnWriteArrayList<Book> books = new CopyOnWriteArrayList<>();
    private Binder binder = new IBookManager.Stub() {

        @Override
        public List<com.katherine.du.everydaystudy.Book> getBookList() throws RemoteException {
            return books;
        }

        @Override
        public void addBook(com.katherine.du.everydaystudy.Book book) throws RemoteException {
            books.add(book);
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        books.add(new Book("Android开发艺术探索", 100));
        books.add(new Book("Android群英传", 101));
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}
