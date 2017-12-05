package com.katherine.du.everydaystudy.up20171205.model.entity;

/**
 * Created by du on 17/12/5.
 */
public class Weather {

    /**
     *
     * {"weatherinfo":{"city":"鍖椾含","cityid":"101010100","temp":"18","WD":"涓滃崡椋�","WS":"1绾�","SD":"17%","WSE":"1","time":"17:05","isRadar":"1","Radar":"JC_RADAR_AZ9010_JB","njd":"鏆傛棤瀹炲喌","qy":"1011","rain":"0"}}
     *
     */
    private WeatherInfo weatherinfo;

    public WeatherInfo getWeatherinfo() {
        return weatherinfo;
    }

    public void setWeatherinfo(WeatherInfo weatherinfo) {
        this.weatherinfo = weatherinfo;
    }





}
