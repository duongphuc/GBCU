package com.example.gbcu.ui.walkthrough;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gbcu.BR;
import com.example.gbcu.R;
import com.example.gbcu.ViewModelProviderFactory;
import com.example.gbcu.databinding.ActivityWalkthroughBinding;
import com.example.gbcu.ui.base.BaseActivity;
import com.example.gbcu.ui.login.LoginActivity;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class WalkThroughActivity extends BaseActivity<ActivityWalkthroughBinding, WalkThroughViewModel> implements WalkThroughNavigator {

    @Inject
    ViewModelProviderFactory factory;
    private WalkThroughViewModel walkThroughViewModel;
    private TextView[] dots;
    private int[] layouts;
    private ActivityWalkthroughBinding mActivityBinding;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_walkthrough;
    }

    @Override
    public WalkThroughViewModel getViewModel() {
        walkThroughViewModel = ViewModelProviders.of(this, factory).get(WalkThroughViewModel.class);
        return walkThroughViewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityBinding = getViewDataBinding();
        walkThroughViewModel.setNavigator(this);

        layouts = new int[]{
                R.layout.walkthrough_slide_1,
                R.layout.walkthrough_slide_2,
                R.layout.walkthrough_slide_3};

        ViewPager viewPager = mActivityBinding.viewpager;
        viewPager.setAdapter(new MyViewPagerAdapter());
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        // adding bottom dots
        addBottomDots(0);
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];
        LinearLayout dotsLayout = mActivityBinding.layoutDots;
        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.gray));
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(getResources().getColor(R.color.black));
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    @Override
    public void skip() {
        Intent intent = LoginActivity.newIntent(WalkThroughActivity.this);
        startActivity(intent);
        finish();
    }

    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}
