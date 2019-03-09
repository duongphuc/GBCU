package com.example.gbcu.ui.list;

import android.content.Context;
import android.content.Intent;

import com.example.gbcu.BR;
import com.example.gbcu.R;
import com.example.gbcu.ViewModelProviderFactory;
import com.example.gbcu.databinding.ActivityNewsListBinding;
import com.example.gbcu.ui.base.BaseActivity;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProviders;

public class NewsListActivity extends BaseActivity<ActivityNewsListBinding, NewsListViewModel> {
    @Inject
    ViewModelProviderFactory factory;
    private NewsListViewModel mNewsListViewModel;
    private ActivityNewsListBinding mActivityNewsListBinding;

    public static Intent newIntent(Context context) {
        return new Intent(context, NewsListActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_news_list;
    }

    @Override
    public NewsListViewModel getViewModel() {
        mNewsListViewModel = ViewModelProviders.of(this, factory).get(NewsListViewModel.class);
        return mNewsListViewModel;
    }
}
