package com.katherine.du.everydaystudy.up20180114;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by du on 18/1/14.
 */

public class NoteBook implements Parcelable{

    private String name;

    private int price;

    public NoteBook() {
    }

    protected NoteBook(Parcel in) {
        name = in.readString();
        price = in.readInt();
    }

    public static final Creator<NoteBook> CREATOR = new Creator<NoteBook>() {
        @Override
        public NoteBook createFromParcel(Parcel in) {
            return new NoteBook(in);
        }

        @Override
        public NoteBook[] newArray(int size) {
            return new NoteBook[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(price);
    }
}
