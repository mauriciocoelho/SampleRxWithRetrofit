package com.example.mauricio.samplerxwithretrofit.di;

import com.example.mauricio.samplerxwithretrofit.MainActivity;

import dagger.Component;

@Component(modules = NetworkModule.class)
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);

}
