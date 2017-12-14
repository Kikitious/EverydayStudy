package com.katherine.du.everydaystudy.up20171214;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by du on 17/12/14.
 */

public class Teacher implements Parcelable {

    private String name;
    private int age;
    private Subject subject;

    public Teacher(String name, int age, Subject subject) {
        this.name = name;
        this.age = age;
        this.subject = subject;
    }

    //反序列化
    protected Teacher(Parcel in) {
        name = in.readString();
        age = in.readInt();
        //这里的subject是另一个可序列化的对象，故反序列化需要传递当前线程的上下文类加载器
        subject = in.readParcelable(Thread.currentThread().getContextClassLoader());
    }

    //反序列化
    public static final Creator<Teacher> CREATOR = new Creator<Teacher>() {
        @Override
        public Teacher createFromParcel(Parcel in) {
            return new Teacher(in);
        }

        @Override
        public Teacher[] newArray(int size) {
            return new Teacher[size];
        }
    };

    //内容描述
    @Override
    public int describeContents() {
        return 0;
    }

    //序列化
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeParcelable(subject, 0);
    }
}
