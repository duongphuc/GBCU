package com.example.gbcu.di.modules;

import android.app.Application;
import android.content.Context;

import com.example.gbcu.data.AppDataManager;
import com.example.gbcu.data.DataManager;
import com.example.gbcu.data.local.AppPreferenceHelper;
import com.example.gbcu.data.local.PreferenceHelper;
import com.example.gbcu.data.remote.ApiHelper;
import com.example.gbcu.data.remote.AppApiHelper;
import com.example.gbcu.di.PreferenceInfo;
import com.example.gbcu.util.AppConstant;
import com.example.gbcu.util.AppSchedulerProvider;
import com.example.gbcu.util.SchedulerProvider;
import com.example.gbcu.util.SecurePreferences;

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

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstant.PREF_NAME;
    }

    @Provides
    @Singleton
    PreferenceHelper providePreferencesHelper(AppPreferenceHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

}
