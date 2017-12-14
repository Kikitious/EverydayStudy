package com.katherine.du.everydaystudy.up20171214.serializaleparcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by du on 17/12/14.
 */

public class Subject implements Parcelable {

    private String author;

    public Subject(String author) {
        this.author = author;
    }

    protected Subject(Parcel in) {
        author = in.readString();
    }

    public static final Creator<Subject> CREATOR = new Creator<Subject>() {
        @Override
        public Subject createFromParcel(Parcel in) {
            return new Subject(in);
        }

        @Override
        public Subject[] newArray(int size) {
            return new Subject[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(author);
    }
}
