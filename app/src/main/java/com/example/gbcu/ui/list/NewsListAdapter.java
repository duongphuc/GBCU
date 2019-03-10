package com.example.gbcu.ui.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.gbcu.data.model.NewsResponse;
import com.example.gbcu.data.model.NewsSchema;
import com.example.gbcu.databinding.ItemNewsViewBinding;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {
    private List<NewsSchema> listNews;
    private NewsListViewModel newsListViewModel;

    public NewsListAdapter(List<NewsSchema> listNews, NewsListViewModel newsListViewModel) {
        this.listNews = listNews;
        this.newsListViewModel = newsListViewModel;
    }

    public void clear() {
        listNews.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<NewsSchema> list) {
        listNews.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNewsViewBinding itemNewsViewBinding = ItemNewsViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new ViewHolder(itemNewsViewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return listNews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements NewsItemViewModel.NewsItemViewModelListener {
        private ItemNewsViewBinding itemNewsViewBinding;
        private NewsItemViewModel newsItemViewModel;

        public ViewHolder(@NonNull ItemNewsViewBinding binding) {
            super(binding.getRoot());
            itemNewsViewBinding = binding;
        }

        public void onBind(int position) {
            NewsSchema news = listNews.get(position);
            newsItemViewModel = new NewsItemViewModel(news, this);
            itemNewsViewBinding.setViewModel(newsItemViewModel);
            itemNewsViewBinding.executePendingBindings();
        }

        @Override
        public void onItemClick(String link, String title) {
            newsListViewModel.onNewsClick(link, title);
        }
    }
}
