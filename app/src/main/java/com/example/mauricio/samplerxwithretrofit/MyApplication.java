package com.example.mauricio.samplerxwithretrofit;

import android.app.Application;

import com.example.mauricio.samplerxwithretrofit.di.ApplicationComponent;
import com.example.mauricio.samplerxwithretrofit.di.DaggerApplicationComponent;
import com.example.mauricio.samplerxwithretrofit.di.NetworkModule;

public class MyApplication extends Application {

    private static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .networkModule(new NetworkModule())
                .build();

    }

    public static ApplicationComponent getApplicationComponent(){
        return  applicationComponent;
    }
}
