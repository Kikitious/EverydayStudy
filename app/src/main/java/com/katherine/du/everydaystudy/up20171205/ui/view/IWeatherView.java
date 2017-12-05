package com.katherine.du.everydaystudy.up20171205.ui.view;

import com.katherine.du.everydaystudy.up20171205.model.entity.Weather;

/**
 * Created by du on 17/12/5.
 */
public interface IWeatherView {

    void showLoading();

    void hideLoading();

    void showToast(String msg);

    void setWeatherInfo(Weather weather);

    String getCityNo();
}
