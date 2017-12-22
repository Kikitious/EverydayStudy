package com.katherine.du.everydaystudy.up20171222.javadefault;

import java.util.Observable;

/**
 * Created by du on 17/12/22.
 */

public class BookStore extends Observable {


    private String info;

    public String getInfo() {
        return info;
    }

    public void pushlishBookInfo(String info) {
        this.info = info;
        System.out.println("书店出了新书：" + info);
        setChanged();
        notifyObservers();
    }


}
