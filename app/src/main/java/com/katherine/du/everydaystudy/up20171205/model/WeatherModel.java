package com.katherine.du.everydaystudy.up20171205.model;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.katherine.du.everydaystudy.up20171205.model.entity.Weather;
import com.katherine.du.everydaystudy.up20171205.net.VolleyRequest;

/**
 * Created by du on 17/12/5.
 */
public class WeatherModel implements IWeatherModel {

    @Override
    public void loadSKWeather(String cityNo, final OnWeatherListener listener) {
        VolleyRequest.newInstance().newGsonRequest(//北京cityNo 101010100
                "http://www.weather.com.cn/data/sk/" + cityNo + ".html",
                Weather.class,
                new Response.Listener<Weather>() {
                    @Override
                    public void onResponse(Weather response) {
                        if (response != null) {
                            listener.onSuccess(response);
                        } else {
                            listener.onError();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onError();
                    }
                });
    }

    @Override
    public void loadCityInfoWeather(String cityNo, final OnWeatherListener listener) {
        VolleyRequest.newInstance().newGsonRequest(//北京cityNo 101010100
                "http://www.weather.com.cn/data/cityinfo/" + cityNo + ".html",
                Weather.class,
                new Response.Listener<Weather>() {
                    @Override
                    public void onResponse(Weather response) {
                        if (response != null) {
                            listener.onSuccess(response);
                        } else {
                            listener.onError();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onError();
                    }
                });
    }


}
