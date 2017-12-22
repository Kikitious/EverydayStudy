package com.katherine.du.everydaystudy.up20171222.weather;

import com.katherine.du.everydaystudy.up20171222.weather.obeservable.WeatherData;
import com.katherine.du.everydaystudy.up20171222.weather.obeserver.CurrentConditionsDisplay;
import com.katherine.du.everydaystudy.up20171222.weather.obeserver.ForecastDisplay;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by du on 17/12/22.
 */

public class ObserverPatternTest {

    public static void main(String[] args) {
        List<Float> forecastTemperatures = new ArrayList<Float>();
        forecastTemperatures.add(22f);
        forecastTemperatures.add(-1f);
        forecastTemperatures.add(9f);
        forecastTemperatures.add(23f);
        forecastTemperatures.add(27f);
        forecastTemperatures.add(30f);
        forecastTemperatures.add(10f);


        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay();
        currentConditionsDisplay.registerObserver(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay();
        forecastDisplay.registerObserver(weatherData);
        weatherData.setMeasurements(22f, 0.8f, 1.2f, forecastTemperatures);
    }
}
