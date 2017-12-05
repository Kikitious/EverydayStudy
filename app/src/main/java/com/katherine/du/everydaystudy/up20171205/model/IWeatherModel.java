package com.katherine.du.everydaystudy.up20171205.model;

/**
 * Created by du on 17/12/5.
 */

public interface IWeatherModel {

    void loadSKWeather(String cityNo, OnWeatherListener listener);

    void loadCityInfoWeather(String cityNo, OnWeatherListener listener);

}
