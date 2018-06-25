package com.example.hjl.tldfxhapp.lx;


import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hjl.tldfxhapp.R;

import static com.example.hjl.tldfxhapp.R.id.news_title;

/**
 * Created by hjl on 2018/6/21.
 */

public class NewsContentFragent extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_content_frag,container,false);
        return view;
    }
    public void  refresh(String  newsTitle,String  newsContent){
        View visibilityLayout =view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        TextView   newsTitleText = (TextView) view.findViewById(R.id.news_title);
        TextView   newsContentText = (TextView) view.findViewById(R.id.news_content);
        newsTitleText.setText(newsTitle);
        newsContentText.setText(newsContent);
    }
}
