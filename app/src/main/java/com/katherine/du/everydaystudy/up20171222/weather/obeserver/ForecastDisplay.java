package com.katherine.du.everydaystudy.up20171222.weather.obeserver;

import com.katherine.du.everydaystudy.up20171222.weather.obeservable.WeatherData;

import java.util.List;

/**
 * Created by du on 17/12/22.
 */
public class ForecastDisplay implements Observer {
    private WeatherData weatherData;
    private List<Float> forecastTemperatures;

    public ForecastDisplay() {
    }

    public void registerObserver(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void update() {
        this.forecastTemperatures = weatherData.getForecastTemperatures();
        System.out.println("未来几天的气温");
        for (int i = 0; i < forecastTemperatures.size(); i++) {
            System.out.println("第" + i + "天:" + forecastTemperatures.get(i) + "℃");
        }
    }
}
