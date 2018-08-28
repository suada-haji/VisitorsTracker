package com.haji.suada.visitorstracker.di;

import com.haji.suada.visitorstracker.view.RegisterVisitorActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector
    abstract RegisterVisitorActivity bindRegisterVisitorActivity();
}
