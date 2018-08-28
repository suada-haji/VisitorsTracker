package com.haji.suada.visitorstracker;

import com.haji.suada.visitorstracker.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class BaseApplication extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return  DaggerAppComponent.builder().create(this);
    }
}
