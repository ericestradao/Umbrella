package com.example.user.umbrella2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.umbrella2.model.ForecastPojo;
import com.example.user.umbrella2.model.WeatherPojo;
import com.example.user.umbrella2.presenter.Presenter;
import com.example.user.umbrella2.view.Adapter;
import com.example.user.umbrella2.view.ViewContract;

public class MainActivity extends AppCompatActivity implements ViewContract {
    final String TAG = MainActivity.class.getSimpleName();
    Presenter presenter;
    Adapter adapter;
    RecyclerView recyclerView;
    TextView city;
    TextView temp;
    TextView clouds;
    Button settings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settings = findViewById(R.id.settings);
        city = findViewById(R.id.city);
        temp = findViewById(R.id.temp);
        clouds = findViewById(R.id.clouds);
        presenter = new Presenter(this);
        presenter.getWeatherCurrent();
        presenter.getWeather5days();

        settings.setOnClickListener(event -> settingsActivity());
    }

    public void settingsActivity() {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    @Override
    public void populateData(ForecastPojo forecastPojo) {

        adapter = new Adapter(forecastPojo, this);
        recyclerView = findViewById(R.id.recycler_view);
        int numberOfColumns = 4;
        GridLayoutManager manager = new GridLayoutManager(this, numberOfColumns);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        Log.d(TAG, "populateData: "+ forecastPojo);
    }

    @Override
    public void populateWeather(WeatherPojo weatherPojo) {
        city.setText(weatherPojo.getName());
        temp.setText(weatherPojo.getMain().getTemp().toString());
        clouds.setText(weatherPojo.getWeather().get(0).getDescription());
    }

}
