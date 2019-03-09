package com.example.gbcu.ui.base;

import com.example.gbcu.data.DataManager;
import com.example.gbcu.util.SchedulerProvider;

import java.lang.ref.WeakReference;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel<T> extends ViewModel {
    private final DataManager mDataManager;

    private final ObservableBoolean mIsLoading = new ObservableBoolean();

    private final SchedulerProvider mSchedulerProvider;

    private CompositeDisposable mCompositeDisposable;

    private WeakReference<T> mNavigator;

    public BaseViewModel(DataManager dataManager,
                         SchedulerProvider schedulerProvider) {
        this.mDataManager = dataManager;
        this.mSchedulerProvider = schedulerProvider;
        this.mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }

    public T getNavigator() {
        return mNavigator.get();
    }

    public void setNavigator(T navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }
}
