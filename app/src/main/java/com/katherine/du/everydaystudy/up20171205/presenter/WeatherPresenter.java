package com.katherine.du.everydaystudy.up20171205.presenter;

import com.katherine.du.everydaystudy.up20171205.model.OnWeatherListener;
import com.katherine.du.everydaystudy.up20171205.model.IWeatherModel;
import com.katherine.du.everydaystudy.up20171205.model.entity.Weather;
import com.katherine.du.everydaystudy.up20171205.model.WeatherModel;
import com.katherine.du.everydaystudy.up20171205.ui.view.IWeatherView;

/**
 * Created by du on 17/12/5.
 */
public class WeatherPresenter {

    private IWeatherModel weatherModel;
    private IWeatherView weatherView;

    public WeatherPresenter(IWeatherView weatherView) {
        this.weatherView = weatherView;
        this.weatherModel = new WeatherModel();
    }

    public void getSKWeather() {
        weatherView.showLoading();
        weatherModel.loadSKWeather(weatherView.getCityNo(), new OnWeatherListener() {
            @Override
            public void onSuccess(Weather weather) {
                weatherView.hideLoading();
                weatherView.setWeatherInfo(weather);
            }

            @Override
            public void onError() {
                weatherView.hideLoading();
                weatherView.showToast("获取数据异常！");
            }
        });
    }

    public void getCityWeather() {
        weatherView.showLoading();
        weatherModel.loadCityInfoWeather(weatherView.getCityNo(), new OnWeatherListener() {
            @Override
            public void onSuccess(Weather weather) {
                weatherView.hideLoading();
                weatherView.setWeatherInfo(weather);
            }

            @Override
            public void onError() {
                weatherView.hideLoading();
                weatherView.showToast("获取数据异常！");
            }
        });
    }


}
