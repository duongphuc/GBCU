package com.example.gbcu.ui.list;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.gbcu.data.model.NewsSchema;

import java.util.Observable;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;

public class NewsItemViewModel {
    public final ObservableField<String> title;
    public final ObservableField<String> date;
    public final ObservableField<String> imageUrl;
    public final ObservableField<String> intro;

    private NewsSchema news;
    private NewsItemViewModelListener listener;
    public interface NewsItemViewModelListener {
        void onItemClick();
    }

    public NewsItemViewModel(NewsSchema news, NewsItemViewModelListener listener) {
        this.news = news;
        this.listener = listener;
        title = new ObservableField<>(news.getTitle());
        date = new ObservableField<>(news.getDate());
        imageUrl = new ObservableField<>(news.getImgUrl());
        intro = new ObservableField<>(news.getStoryIntro());
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.transforms(new CenterCrop(), new RoundedCorners(16));
        Glide.with(view.getContext())
                .load(imageUrl)
                .apply(requestOptions)
                .into(view);
    }
}
