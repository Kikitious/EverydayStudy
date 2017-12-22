package com.katherine.du.everydaystudy.up20171222.weather.obeserver;

import com.katherine.du.everydaystudy.up20171222.weather.obeservable.WeatherData;

/**
 * Created by du on 17/12/22.
 */

public class CurrentConditionsDisplay implements Observer {

    private WeatherData weatherData;
    private float temperature;//温度
    private float humidity;//湿度
    private float pressure;//气压

    public CurrentConditionsDisplay() {
    }

    public void registerObserver(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void update() {
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        this.pressure = weatherData.getPressure();
        //展示
        System.out.println("当前温度为：" + this.temperature + "℃");
        System.out.println("当前湿度为：" + this.humidity);
        System.out.println("当前气压为：" + this.pressure);
    }
}
