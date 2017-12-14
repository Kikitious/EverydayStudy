package com.katherine.du.everydaystudy.up20171214.aidl.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.katherine.du.everydaystudy.BaseActivity;
import com.katherine.du.everydaystudy.Book;
import com.katherine.du.everydaystudy.IBookManager;
import com.katherine.du.everydaystudy.R;
import com.katherine.du.everydaystudy.up20171214.aidl.server.BookManagerService;

import java.util.List;

/**
 * Created by du on 17/12/14.
 */

public class BookManagerActivity extends BaseActivity {

    private static final String TAG = "BookManagerActivity";

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            IBookManager manager = IBookManager.Stub.asInterface(service);
            try {
                List<Book> bookList = manager.getBookList();
                for (Book book : bookList) {
                    Log.i(TAG, book.getBookName());
                }

                manager.addBook(new Book("Android群英传：神兵利器", 102));

                List<Book> bookList2 = manager.getBookList();
                for (Book book : bookList2) {
                    Log.i(TAG, book.getBookName());
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
        Intent intent = new Intent(this, BookManagerService.class);
        //startService(intent);
        bindService(intent, conn, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
    }
}
