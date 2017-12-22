package com.katherine.du.everydaystudy.up20171222.teacher.observable;

import com.katherine.du.everydaystudy.up20171222.teacher.observer.Observer;

/**
 * Created by du on 17/12/22.
 */

public interface Subject {


    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();

}
