package com.example.mauricio.samplerxwithretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import com.example.mauricio.samplerxwithretrofit.models.Weather;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Inject
    WeatherService weatherService;

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private String TOKEN = "7a60287bea1a12c76face6dbd1803295";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyApplication.getApplicationComponent().inject(this);

        Button button = (Button) findViewById(R.id.buttonTest);
        button.setOnClickListener(v -> getWeather());

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        ArrayList<User> weathers = new ArrayList<>();
        User weather = new User();
        weather.setDescription("teste um dois");
        weathers.add(weather);

        recyclerViewAdapter = new RecyclerViewAdapter(weathers);
        recyclerView.setAdapter(recyclerViewAdapter);
    }


    private void getWeather() {
        weatherService.getWeatherData("Islamabad", TOKEN)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(weatherData -> {
                    Log.e("Current Weather", weatherData.name);
                    User weather = new User();
                    weather.setDescription("teste um dois tres");
                    recyclerViewAdapter.addItem(weather);


                }, throwable -> {
                    Log.e("Current Weather - ERROR", throwable.getMessage());
                });

    }
}
