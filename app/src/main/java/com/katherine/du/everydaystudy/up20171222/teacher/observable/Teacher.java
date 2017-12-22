package com.katherine.du.everydaystudy.up20171222.teacher.observable;

import com.katherine.du.everydaystudy.up20171222.teacher.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by du on 17/12/22.
 */

public class Teacher implements Subject {

    private List<Observer> observers = new ArrayList<>();

    private String info;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.receiveHomework(getInfo());
        }
    }

    public String getInfo() {
        return info;
    }

    public void publishHomeWork(String info) {
        this.info = info;
        System.out.println("This is the homework " + info);
        this.notifyObservers();
    }
}
