package com.katherine.du.everydaystudy.up20171214.contentprovider.remoteprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.katherine.du.everydaystudy.up20171214.contentprovider.database.DbOpenHelper;

/**
 * Created by du on 17/12/14.
 */
public class BookProvider extends ContentProvider {
    private static final String TAG = "BookProvider";
    public static final String AUTHORITY = "com.katherine.du.everydaystudy.provider";
    public static final Uri BOOK_CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/book");
    public static final Uri USER_CONENT_URI = Uri.parse("content://" + AUTHORITY + "/user");
    public static final int BOOK_URI_CODE = 0;
    public static final int USER_URI_CODE = 1;
    private static final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
    private Context context;
    private SQLiteDatabase database;

    static {//为book表和user表指定自己的URI
        matcher.addURI(AUTHORITY, "book", BOOK_URI_CODE);
        matcher.addURI(AUTHORITY, "user", USER_URI_CODE);
    }


    @Override
    public boolean onCreate() {
        context = getContext();
        initProviderData();
        return true;
    }

    private void initProviderData() {
        DbOpenHelper db = new DbOpenHelper(context);
        database = db.getWritableDatabase();
        database.execSQL("delete from " + DbOpenHelper.BOOK_TABLE_NAME);
        database.execSQL("delete from " + DbOpenHelper.USER_TABLE_NAME);
        database.execSQL("insert into book values(3, 'Android开发艺术探索')");
        database.execSQL("insert into book values(2, 'Android群英传')");
        database.execSQL("insert into book values(1, 'Android第一行代码')");
        database.execSQL("insert into book values(4, 'Android群英传：神兵利器')");
        database.execSQL("insert into book values(5, 'Android入门')");
        database.execSQL("insert into book values(6, 'Android21天速成法')");
        database.execSQL("insert into user values(1, 'katherine', 1)");
        database.execSQL("insert into user values(2, 'kathy', 1)");
        database.execSQL("insert into user values(3, 'bob', 0)");
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Log.i(TAG, "query");
        String tableName = getTableName(uri);
        if (tableName == null) {
            throw new IllegalArgumentException("Unsuppored URI: " + uri);
        }
        Cursor cursor = database.query(tableName, projection, selection, selectionArgs, null, null, sortOrder, null);
        return cursor;
    }


    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        Log.i(TAG, "insert");
        String tableName = getTableName(uri);
        if (tableName == null) {
            throw new IllegalArgumentException("Unsuppored URI: " + uri);
        }
        database.insert(tableName, null, values);
        context.getContentResolver().notifyChange(uri, null);
        return uri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        Log.i(TAG, "delete");
        String tableName = getTableName(uri);
        if (tableName == null) {
            throw new IllegalArgumentException("Unsuppored URI: " + uri);
        }
        int count = database.delete(tableName, selection, selectionArgs);
        if (count > 0) {
            context.getContentResolver().notifyChange(uri, null);
        }
        return count;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        Log.i(TAG, "update");
        String tableName = getTableName(uri);
        if (tableName == null) {
            throw new IllegalArgumentException("Unsuppored URI: " + uri);
        }
        int row = database.update(tableName, values, selection, selectionArgs);
        if (row > 0) {
            context.getContentResolver().notifyChange(uri, null);
        }
        return row;
    }

    private String getTableName(Uri uri) {
        String tableName = null;
        switch (matcher.match(uri)) {
            case BOOK_URI_CODE:
                tableName = DbOpenHelper.BOOK_TABLE_NAME;
                break;
            case USER_URI_CODE:
                tableName = DbOpenHelper.USER_TABLE_NAME;
                break;
        }
        return tableName;
    }
}
