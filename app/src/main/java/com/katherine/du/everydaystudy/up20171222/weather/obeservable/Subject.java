package com.katherine.du.everydaystudy.up20171222.weather.obeservable;

import com.katherine.du.everydaystudy.up20171222.weather.obeserver.Observer;

/**
 * Created by du on 17/12/22.
 */

public interface Subject {

    void registerObserver(Observer observer);

    void unregisterObserver(Observer observer);

    void notifyObservers();

}
