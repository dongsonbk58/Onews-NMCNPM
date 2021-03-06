package com.example.dongson.onews.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dongson.onews.Models.Articles;
import com.example.dongson.onews.Models.OnItemClickListener;
import com.example.dongson.onews.R;

import java.util.List;

/**
 * Created by Trang Rua on 20-Nov-17.
 */

public class ArticleTwoAdapter extends RecyclerView.Adapter<ArticleTwoAdapter.ArticleTypeTwoViewHolder> {
    private List<Articles> articleList;
    private OnItemClickListener listener;

    public ArticleTwoAdapter(List<Articles> articleList, OnItemClickListener listener) {
        this.articleList = articleList;
        this.listener = listener;

    }

    @Override
    public ArticleTypeTwoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_type_two, parent, false);

        return new ArticleTypeTwoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ArticleTypeTwoViewHolder holder, int position) {
        Articles object = articleList.get(position);
        if (object != null) {
            holder.bind(object, listener);
        }


    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public static class ArticleTypeTwoViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView created_time;
        private ImageView img_article;

        public ArticleTypeTwoViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_title_type_two);
            created_time = (TextView) itemView.findViewById(R.id.tv_created_time_type_two);
            img_article = (ImageView) itemView.findViewById(R.id.img_article_type_two);
        }

        public void bind(final Articles item, final OnItemClickListener listener) {
            title.setText(item.getTitle());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {listener.onItemClick(item);}

            });
        }

    }
}
