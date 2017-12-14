package com.katherine.du.everydaystudy.up20171214.contentprovider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import com.katherine.du.everydaystudy.BaseActivity;
import com.katherine.du.everydaystudy.R;
import com.katherine.du.everydaystudy.up20171214.contentprovider.remoteprovider.BookProvider;

/**
 * Created by du on 17/12/14.
 */

public class ProviderActivity extends BaseActivity {
    private static final String TAG = "ProviderActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        ContentResolver resolver = getContentResolver();

        //查询user表
        Cursor cursor = resolver.query(BookProvider.USER_CONENT_URI, new String[]{"_id", "name", "sex"}, null, null, null);
        while (cursor.moveToNext()) {
            int userId = cursor.getInt(0);
            String userName = cursor.getString(1);
            boolean isMale = cursor.getInt(2) == 0 ? true : false;
            Log.i(TAG, "userId:" + userId + " userName:" + userName + " isMale:" + isMale);
        }

        //向book表插入数据
        ContentValues values = new ContentValues();
        values.put("_id", 100);
        values.put("name", "农夫山泉茶派");
        resolver.insert(BookProvider.BOOK_CONTENT_URI, values);

        //查询book表
        Cursor cursor1 = resolver.query(BookProvider.BOOK_CONTENT_URI, new String[]{"_id", "name"}, null, null, null);
        while (cursor1.moveToNext()) {
            int bookId = cursor1.getInt(0);
            String bookName = cursor1.getString(1);
            Log.i(TAG, "bookId:" + bookId + " bookName:" + bookName);
        }

    }
}
