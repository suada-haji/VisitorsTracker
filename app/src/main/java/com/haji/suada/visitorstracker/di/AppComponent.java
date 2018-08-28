package com.haji.suada.visitorstracker.di;

import com.haji.suada.visitorstracker.BaseApplication;
import com.haji.suada.visitorstracker.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class})
public interface AppComponent extends AndroidInjector<BaseApplication> {
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<BaseApplication> {
    }
}
