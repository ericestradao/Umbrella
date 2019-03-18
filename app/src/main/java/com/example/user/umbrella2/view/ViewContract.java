package com.example.user.umbrella2.view;

import com.example.user.umbrella2.model.ForecastPojo;
import com.example.user.umbrella2.model.WeatherPojo;

public interface ViewContract {
    void populateData(ForecastPojo forecastPojo);
    void populateWeather(WeatherPojo weatherPojo);

}
