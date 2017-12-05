package com.katherine.du.everydaystudy.up20171205.model;

import com.katherine.du.everydaystudy.up20171205.model.entity.Weather;

/**
 * Created by du on 17/12/5.
 */
public interface OnWeatherListener {

    void onSuccess(Weather weather);

    void onError();
}
