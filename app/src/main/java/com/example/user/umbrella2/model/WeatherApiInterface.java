package com.example.user.umbrella2.model;

import com.example.user.umbrella2.model.pojos.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiInterface {

    @GET("forecast?")
    Call<ForecastPojo> getForecast(@Query("zip") String zip,
//                                 @Query("country") String country,
                                   @Query("appid") String appid);

    @GET("weather?")
    Call<WeatherPojo> getWeather(@Query("zip") String zip,
//                                 @Query("country") String country,
                             @Query("appid") String appid);
}
