package com.example.gbcu.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.gbcu.BR;
import com.example.gbcu.R;
import com.example.gbcu.ViewModelProviderFactory;
import com.example.gbcu.databinding.ActivityNewsDetailBinding;
import com.example.gbcu.ui.base.BaseActivity;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import okhttp3.Interceptor;

public class NewsDetailActivity extends BaseActivity<ActivityNewsDetailBinding, NewsDetailViewModel> implements NewsDetailNavigator {
    @Inject
    ViewModelProviderFactory factory;
    private ActivityNewsDetailBinding mActivityNewsDetailBinding;
    private NewsDetailViewModel newsDetailViewModel;
    private static String TITLE_KEY = "title";
    private static String LINK_KEY = "link";

    public static Intent newIntent(Context context, String link, String title) {
        Intent intent = new Intent(context, NewsDetailActivity.class);
        intent.putExtra(TITLE_KEY, title);
        intent.putExtra(LINK_KEY, link);
        return intent;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_news_detail;
    }

    @Override
    public NewsDetailViewModel getViewModel() {
        newsDetailViewModel = ViewModelProviders.of(this, factory).get(NewsDetailViewModel.class);
        return newsDetailViewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityNewsDetailBinding = getViewDataBinding();
        newsDetailViewModel.setNavigator(this);
        mActivityNewsDetailBinding.tvTitle.setText(getIntent().getStringExtra(TITLE_KEY));
        setupWebView();
    }

    private void setupWebView() {
        WebView webView = mActivityNewsDetailBinding.webview;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                newsDetailViewModel.setIsLoading(false);
            }
        });
        // For API level below 18 (This method was deprecated in API level 18)
        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);

        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        if (Build.VERSION.SDK_INT >= 19) {
            webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        }
        else {
            webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        mActivityNewsDetailBinding.webview.loadUrl(getIntent().getStringExtra(LINK_KEY));
        newsDetailViewModel.setIsLoading(true);
    }

    @Override
    public void onBackClick() {
        onBackPressed();
    }
}
