package com.example.mauricio.samplerxwithretrofit;

import android.databinding.BaseObservable;
import android.databinding.Bindable;



public class User extends BaseObservable {

    private String description;

    @Bindable
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }

}
