package com.example.mauricio.samplerxwithretrofit;

import com.example.mauricio.samplerxwithretrofit.models.WeatherData;



import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface WeatherService {

    @GET("weather?")
    Observable<WeatherData> getWeatherData(@Query("q") String city, @Query("APPID") String token);

}
