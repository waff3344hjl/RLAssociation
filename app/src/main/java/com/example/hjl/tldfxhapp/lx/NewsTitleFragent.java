package com.example.hjl.tldfxhapp.lx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hjl.tldfxhapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hjl on 2018/6/21.
 */

public class NewsTitleFragent extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.news_title_frag,container,false);
        RecyclerView  recyclerView =
                (RecyclerView) v.findViewById(R.id.news_title_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        NewsAdapter newsAdapter = new NewsAdapter();
        recyclerView.setAdapter(newsAdapter);
        newsAdapter.setNewsAdapter(getNews());
        return  v;
    }

    private List<News> getNews() {
        List<News>  newsList = new ArrayList<>();
        for (int i = 0; i <120 ; i++) {
            News news = new News();
            news.setTitle("Title"+i);
            news.setContent("Content____"+i);
            newsList.add(news);
        }
                return newsList;
    }

    private boolean  isTwoPane;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.news_content_layout)!=null) {
            isTwoPane =true;
        }else {
            isTwoPane=false;
        }
    }
    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{
       private List<News> mNewsList;
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view =LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.news_item,parent,false);
            final ViewHolder viewHolder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    News news = mNewsList.get(viewHolder.getAdapterPosition());
                    if (isTwoPane) {
                        Log.e("TAG","TitleFragment_2");
                        NewsContentFragent newsContentFragent =
                                (NewsContentFragent) getFragmentManager()
                                        .findFragmentById(R.id.news_content_fragment);
                        newsContentFragent.refresh(news.getTitle(),news.getContent());

                    }else {
                        Log.e("TAG","TitleFragment_1");
                        NewsContenActivity.
                                actionStart(getActivity(),news.getTitle(),news.getContent());
                    }
                }
            });
            return viewHolder;
        }


        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
                   News news = mNewsList.get(position);
            holder.tv.setText(news.getTitle());
        }

        @Override
        public int getItemCount() {
            return mNewsList.size();
        }
       public void setNewsAdapter(List<News> li){
           mNewsList =li;
       }
        public class ViewHolder extends RecyclerView.ViewHolder{
            TextView tv;
            public ViewHolder(View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(R.id.news_title);
            }
        }
    }
}
