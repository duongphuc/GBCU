package com.example.gbcu.ui.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.gbcu.BR;
import com.example.gbcu.R;
import com.example.gbcu.ViewModelProviderFactory;
import com.example.gbcu.data.model.NewsSchema;
import com.example.gbcu.databinding.ActivityNewsListBinding;
import com.example.gbcu.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NewsListActivity extends BaseActivity<ActivityNewsListBinding, NewsListViewModel> implements NewsListNavigator {
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityNewsListBinding = getViewDataBinding();
        mNewsListViewModel.setNavigator(this);
        mNewsListViewModel.fetchNews();
    }

    private void setupRecyclerView() {

    }

    @Override
    public void fetchNewsSuccess(List<NewsSchema> items) {
        RecyclerView recyclerView = mActivityNewsListBinding.recyclerViewList;
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(new NewsListAdapter(items));
    }

    @Override
    public void fetchNewsFail() {

    }
}