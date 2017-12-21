package com.katherine.du.everydaystudy.up20171220;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.katherine.du.everydaystudy.BaseActivity;
import com.katherine.du.everydaystudy.R;
import com.katherine.du.everydaystudy.up20171220.api.Api;
import com.katherine.du.everydaystudy.up20171220.db.DbHelper;
import com.katherine.du.everydaystudy.up20171220.entity.UserInfo;
import com.katherine.du.everydaystudy.up20171220.request.LoginRequest;
import com.katherine.du.everydaystudy.up20171220.request.RegisterRequest;
import com.katherine.du.everydaystudy.up20171220.request.UserBaseInfoRequest;
import com.katherine.du.everydaystudy.up20171220.request.UserExtraInfoRequest;
import com.katherine.du.everydaystudy.up20171220.response.LoginResponse;
import com.katherine.du.everydaystudy.up20171220.response.RegisterResopnse;
import com.katherine.du.everydaystudy.up20171220.response.UserBaseInfoResponse;
import com.katherine.du.everydaystudy.up20171220.response.UserExtraInfoResponse;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by du on 17/12/20.
 */

public class RxJavaTestActivity extends BaseActivity {
    private static final String TAG = "RxJavaTestActivity";
    private Subscription mSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_test);
        readText();
    }

    public void readText() {
        final TextView textView = (TextView) findViewById(R.id.textView);
        final File directory = Environment.getExternalStorageDirectory();
        final StringBuffer sb = new StringBuffer();
        Flowable
                .create(new FlowableOnSubscribe<String>() {
                    @Override
                    public void subscribe(FlowableEmitter<String> e) throws Exception {
                        try {
                            FileReader reader = new FileReader(directory + "/haha.pdf");
                            BufferedReader br = new BufferedReader(reader);
                            String str;
                            while ((str = br.readLine()) != null && !e.isCancelled()) {
                                while (e.requested() == 0) {
                                    if (e.isCancelled()) {
                                        break;
                                    }
                                }
                                e.onNext(str);
                            }

                            br.close();
                            reader.close();
                            e.onComplete();
                        } catch (Exception err) {
                            e.onError(err);
                        }
                    }
                }, BackpressureStrategy.ERROR)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        mSubscription = s;
                        s.request(1);
                    }

                    @Override
                    public void onNext(String s) {
                        sb.append(s);
                        mSubscription.request(1);
                    }

                    @Override
                    public void onError(Throwable t) {
                    }

                    @Override
                    public void onComplete() {
                        textView.setText(sb);
                    }
                });
    }

    public void testFlowable() {
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSubscription.request(48);
            }
        });
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
                Log.d(TAG, "First requested = " + emitter.requested());
                boolean flag;
                for (int i = 0; ; i++) {
                    flag = false;
                    while (emitter.requested() == 0) {
                        if (!flag) {
                            Log.d(TAG, "Oh no! I can't emit value!");
                            flag = true;
                        }
                    }
                    emitter.onNext(i);
                    Log.d(TAG, "emit " + i + " , requested = " + emitter.requested());
                }
            }
        }, BackpressureStrategy.ERROR)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {

                    @Override
                    public void onSubscribe(Subscription s) {
                        Log.d(TAG, "onSubscribe");
                        mSubscription = s;
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.w(TAG, "onError: ", t);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }
                });

    }

    private void getUserInfo() {
        Retrofit retrofit = OkhttpWrapper.create();
        Api api = retrofit.create(Api.class);
        Observable<UserBaseInfoResponse> observable1 = api.getUserBaseInfo(new UserBaseInfoRequest());
        Observable<UserExtraInfoResponse> observable2 = api.getUserExtraInfo(new UserExtraInfoRequest());
        Observable.zip(observable1, observable2,
                new BiFunction<UserBaseInfoResponse, UserExtraInfoResponse, UserInfo>() {
                    @Override
                    public UserInfo apply(UserBaseInfoResponse userBaseInfoResponse, UserExtraInfoResponse userExtraInfoResponse) throws Exception {
                        return new UserInfo(userBaseInfoResponse, userExtraInfoResponse);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserInfo>() {
                    @Override
                    public void accept(UserInfo userInfo) throws Exception {
                        //刷新UI
                    }
                });
    }

    private void registerAndlogin() {
        Retrofit retrofit = OkhttpWrapper.create();
        final Api api = retrofit.create(Api.class);
        api.register(new RegisterRequest())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<RegisterResopnse>() {
                    @Override
                    public void accept(RegisterResopnse registerResopnse) throws Exception {
                        //先根据注册的响应结果去做一些操作
                    }
                })
                .observeOn(Schedulers.io())
                .flatMap(new Function<RegisterResopnse, ObservableSource<LoginResponse>>() {
                    @Override
                    public ObservableSource<LoginResponse> apply(RegisterResopnse registerResopnse) throws Exception {
                        return api.login(new LoginRequest());
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginResponse>() {
                    @Override
                    public void accept(LoginResponse loginResponse) throws Exception {
                        Toast.makeText(RxJavaTestActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(RxJavaTestActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public Observable<List<String>> readAllRecords() {
        DbHelper dbHelper = new DbHelper(this);
        final SQLiteDatabase db = dbHelper.getReadableDatabase();
        Observable<List<String>> observable = Observable.create(new ObservableOnSubscribe<List<String>>() {
            @Override
            public void subscribe(ObservableEmitter<List<String>> e) throws Exception {
                Cursor cursor = null;
                try {
                    cursor = db.rawQuery("select * from rxjava_table", new String[]{});
                    List<String> result = new ArrayList<>();
                    while (cursor.moveToNext()) {
                        result.add(cursor.getString(1));
                    }
                    e.onNext(result);
                    e.onComplete();
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        });
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return observable;
    }

    private void login() {
        Retrofit retrofit = OkhttpWrapper.create();
        Api api = retrofit.create(Api.class);
        api.login(new LoginRequest())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginResponse loginResponse) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void test() {
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                Log.i(TAG, "subscribe: " + Thread.currentThread().getName());
                Log.i(TAG, "subscribe: 1");
                e.onNext(1);
                Log.i(TAG, "subscribe: 2");
                e.onNext(2);
                Log.i(TAG, "subscribe: 3");
                e.onNext(3);
                Log.i(TAG, "subscribe: onComplete");
                e.onComplete();
                Log.i(TAG, "subscribe: 4");
                e.onNext(4);
            }
        });

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "subscribe: " + Thread.currentThread().getName());
                Log.i(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "onNext: " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError: ");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete: ");
            }
        };
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


}
