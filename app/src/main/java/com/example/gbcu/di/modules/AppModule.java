package com.example.gbcu.di.modules;

import android.app.Application;
import android.content.Context;

import com.example.gbcu.data.AppDataManager;
import com.example.gbcu.data.DataManager;
import com.example.gbcu.util.AppSchedulerProvider;
import com.example.gbcu.util.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }
}
