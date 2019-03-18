package com.example.user.umbrella2.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.TextView;

import com.example.user.umbrella2.R;
import com.example.user.umbrella2.Settings;
import com.example.user.umbrella2.model.ConnectApi;
import com.example.user.umbrella2.model.WeatherApiInterface;
import com.example.user.umbrella2.model.ForecastPojo;
import com.example.user.umbrella2.model.WeatherPojo;
import com.example.user.umbrella2.view.ViewContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Presenter implements PresenterInterface {
    public static Context contextOfApplication;

    final String TAG = Presenter.class.getSimpleName();
    ViewContract viewContract;
    private Context context;
    Context applicationContext = Settings.getContextOfApplication();

    public Presenter(ViewContract viewContract) {
        this.viewContract = viewContract;
    }

   // SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
   // String android_choice = sp.getString("zip_preference", "None selected");


    @Override
    public void getWeather5days() {
        Retrofit retrofit = ConnectApi.getInstance().initRetrofit();
        WeatherApiInterface weatherApiInterface = retrofit.create(WeatherApiInterface.class);
        weatherApiInterface.getForecast("94040", "f9b25c2365a23c4f5643722386d01941").enqueue(new Callback<ForecastPojo>() {
            @Override
            public void onResponse(Call<ForecastPojo> call, Response<ForecastPojo> response) {
                viewContract.populateData(response.body());
            }

            @Override
            public void onFailure(Call<ForecastPojo> call, Throwable t) {
                Log.d(TAG,"Error");
            }
        });

    }

    @Override
    public void getWeatherCurrent() {
        Retrofit retrofit = ConnectApi.getInstance().initRetrofit();
        WeatherApiInterface weatherApiInterface = retrofit.create(WeatherApiInterface.class);
        weatherApiInterface.getWeather("94040", "f9b25c2365a23c4f5643722386d01941").enqueue(new Callback<WeatherPojo>() {
            @Override
            public void onResponse(Call<WeatherPojo> call, Response<WeatherPojo> response) {
                viewContract.populateWeather(response.body());
            }

            @Override
            public void onFailure(Call<WeatherPojo> call, Throwable t) {
                Log.d(TAG,"Error");
            }
        });

    }
}
