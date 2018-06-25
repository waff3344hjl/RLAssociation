package com.example.hjl.tldfxhapp.lx;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hjl.tldfxhapp.R;

public class NewsContenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_contet);
        String title = getIntent().getStringExtra("news_title");
        String content = getIntent().getStringExtra("news_content");
        NewsContentFragent newsContentFragent =
                (NewsContentFragent) getSupportFragmentManager()
                        .findFragmentById(R.id.news_content_fragment);
        newsContentFragent.refresh(title,content);
    }
    public static void actionStart(Context context,String  title,String conten){
        Intent intent = new Intent(context,NewsContenActivity.class);
        intent.putExtra("news_title",title);
        intent.putExtra("news_content",conten);
        context.startActivity(intent);
    }
}
