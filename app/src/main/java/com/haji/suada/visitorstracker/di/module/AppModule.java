package com.haji.suada.visitorstracker.di.module;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.haji.suada.visitorstracker.BaseApplication;
import com.haji.suada.visitorstracker.core.Constants;
import com.haji.suada.visitorstracker.model.db.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ViewModelModule.class})
public class AppModule {
    @Provides
    @Singleton
    Context provideContext(BaseApplication application) {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(Context context) {
        return Room.databaseBuilder(context,
                AppDatabase.class, Constants.DB)
                .allowMainThreadQueries()
                .build();
    }
}
