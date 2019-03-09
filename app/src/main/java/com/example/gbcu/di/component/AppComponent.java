package com.example.gbcu.di.component;

import android.app.Application;

import com.example.gbcu.GbcuApp;
import com.example.gbcu.di.modules.ActivityBuilderModule;
import com.example.gbcu.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilderModule.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(GbcuApp app);
}
