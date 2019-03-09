package com.example.gbcu.di.modules;

import android.app.Application;
import android.content.Context;

import com.example.gbcu.data.AppDataManager;
import com.example.gbcu.data.DataManager;

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
}
