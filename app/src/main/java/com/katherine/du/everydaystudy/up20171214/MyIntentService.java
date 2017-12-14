package com.katherine.du.everydaystudy.up20171214;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by du on 17/12/14.
 */

//必须实现 构造函数 和 onHandleIntent方法
public class MyIntentService extends IntentService {

    //使用自定义的名称
    public MyIntentService() {
        super("MyIntentService");
    }

    public MyIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}

//必须实现 onBind方法
class MyService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
