package com.example.hjl.tldfxhapp.lx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.hjl.tldfxhapp.R;

/**
 * Created by hjl on 2018/6/21.
 */

public class NewsActivity extends AppCompatActivity{
    boolean isTwoPane;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_news);
        if (findViewById(R.id.news_content_layout)!=null) {
            isTwoPane =true;
        }else {
            isTwoPane=false;
        }
        if (isTwoPane) {
            Log.e("TAG","NewsActivity__2");
            replaceFragment(new NewsTitleFragent());
            replaceFragment2(new NewsContentFragent());

        }else {
            Log.e("TAG","NewsActivity__1");
            replaceFragment(new NewsTitleFragent());
        }
    }

    private void replaceFragment(Fragment f) {
        FragmentManager manager  = getSupportFragmentManager();
        FragmentTransaction transaction  =manager.beginTransaction();
        transaction.replace(R.id.news_title_fragent,f);
        transaction.commit();
    }

    private void replaceFragment2(Fragment f){
        FragmentManager manager  = getSupportFragmentManager();
        FragmentTransaction transaction  =manager.beginTransaction();
        transaction.replace(R.id.news_content_fragment,f);
        transaction.commit();
    }
}
