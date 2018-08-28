package com.haji.suada.visitorstracker.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.haji.suada.visitorstracker.di.ViewModelKey;
import com.haji.suada.visitorstracker.viewmodel.ViewModelFactory;
import com.haji.suada.visitorstracker.viewmodel.VisitorViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(VisitorViewModel.class)
    abstract ViewModel bindsVisitorViewModel(VisitorViewModel visitorViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory viewModelFactory);

}
