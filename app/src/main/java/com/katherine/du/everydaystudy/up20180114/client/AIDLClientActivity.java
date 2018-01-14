package com.katherine.du.everydaystudy.up20180114.client;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

import com.katherine.du.everydaystudy.BaseActivity;
import com.katherine.du.everydaystudy.up20180114.NoteBook;
import com.katherine.du.everydaystudy.up20180114.NoteBookManager;
import com.katherine.du.everydaystudy.up20180114.server.AIDLService;

import java.util.List;


public class AIDLClientActivity extends BaseActivity {

    NoteBookManager manager;
    private ServiceConnection conn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, AIDLService.class);
        //do some operation
        conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                manager = NoteBookManager.Stub.asInterface(service);
                //do some operation
                try {
                    manager.addBook(new NoteBook());
                    List<NoteBook> books = manager.getBooks();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
        bindService(intent, conn, BIND_AUTO_CREATE);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
    }
}
