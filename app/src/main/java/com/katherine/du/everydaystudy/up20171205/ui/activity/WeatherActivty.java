package com.katherine.du.everydaystudy.up20171205.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.katherine.du.everydaystudy.BaseActivity;
import com.katherine.du.everydaystudy.R;
import com.katherine.du.everydaystudy.up20171205.model.entity.Weather;
import com.katherine.du.everydaystudy.up20171205.model.entity.WeatherInfo;
import com.katherine.du.everydaystudy.up20171205.presenter.WeatherPresenter;
import com.katherine.du.everydaystudy.up20171205.ui.view.IWeatherView;

/**
 * Created by du on 17/12/5.
 */
public class WeatherActivty extends BaseActivity implements IWeatherView {
    private EditText cityNoEt;
    private TextView cityTv;
    private TextView cityNoTv;
    private TextView tempTv;
    private TextView wdTv;
    private TextView wsTv;
    private TextView sdTv;
    private TextView timeTv;
    private TextView jsonStringTv;
    private WeatherPresenter presenter;
    private Button searchSkBt;
    private Button searchCityBt;
    private ProgressDialog dialog;
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        findView();
        presenter = new WeatherPresenter(this);
        dialog = new ProgressDialog(this);
        dialog.setTitle("加载天气中");
    }

    private void findView() {
        cityNoEt = (EditText) findViewById(R.id.et_city_no);
        cityTv = (TextView) findViewById(R.id.tv_city);
        cityNoTv = (TextView) findViewById(R.id.tv_city_no);
        tempTv = (TextView) findViewById(R.id.tv_temp);
        wdTv = (TextView) findViewById(R.id.tv_WD);
        wsTv = (TextView) findViewById(R.id.tv_WS);
        sdTv = (TextView) findViewById(R.id.tv_SD);
        timeTv = (TextView) findViewById(R.id.tv_time);
        jsonStringTv = (TextView) findViewById(R.id.jsonString);
        searchSkBt = (Button) findViewById(R.id.btn_go_sk);
        searchCityBt = (Button) findViewById(R.id.btn_go_city);
        searchSkBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getSKWeather();
            }
        });
        searchCityBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getCityWeather();
            }
        });
    }

    @Override
    public void showLoading() {
        if (!dialog.isShowing() && !this.isFinishing()) {
            dialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (dialog.isShowing() && !this.isFinishing()) {
            dialog.dismiss();
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setWeatherInfo(Weather weather) {
        if (weather != null) {
            WeatherInfo info = weather.getWeatherinfo();
            cityTv.setText(info.getCity());
            cityNoTv.setText(info.getCityid());
            tempTv.setText(info.getTemp());
            wdTv.setText(info.getWD());
            wsTv.setText(info.getWS());
            sdTv.setText(info.getSD());
            timeTv.setText(info.getTime());
            jsonStringTv.setText(gson.toJson(weather));
        }
    }

    @Override
    public String getCityNo() {
        return cityNoEt.getText().toString().trim();
    }
}
