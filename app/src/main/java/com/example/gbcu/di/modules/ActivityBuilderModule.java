package com.example.gbcu.di.modules;

import com.example.gbcu.ui.list.NewsListActivity;
import com.example.gbcu.ui.login.LoginActivity;
import com.example.gbcu.ui.walkthrough.WalkThroughActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {
    @ContributesAndroidInjector
    abstract WalkThroughActivity bindWalkThroughActivity();

    @ContributesAndroidInjector
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector
    abstract NewsListActivity bindNewsListActivity();
}
