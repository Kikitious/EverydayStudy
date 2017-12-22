package com.katherine.du.everydaystudy.up20171222.javadefault;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by du on 17/12/22.
 */

public class Reader implements Observer {

    private BookStore store;
    private String name;

    public Reader(BookStore store, String name) {
        this.store = store;
        this.name = name;
        this.store.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(name + "收到了" + ((BookStore) o).getInfo() + "的信息");
    }


}
