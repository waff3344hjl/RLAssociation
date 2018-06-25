package com.example.hjl.tldfxhapp.lx1;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;

import com.example.hjl.tldfxhapp.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by hjl on 2018/6/22.
 * 文件存储<2018/6/22>
 */

public class FileOutPutStreamActivity extends AppCompatActivity{
    private EditText editText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file_save);
        editText = (EditText) findViewById(R.id.edit);
        String  inputText = load();

        if (!TextUtils.isEmpty(inputText)) {
            editText.setText(inputText);
            editText.setSelection(inputText.length());//移动光标到文字末尾
        }else {
            Log.e("TAG","inputText----is null!");
        }
    }

    private String load() {
        Log.e("TAG","lx1_data----zb open!");
        FileInputStream in =null;
        BufferedReader reader =null;
        StringBuilder content  = new StringBuilder();
        try {
            in = openFileInput("lx1_data");
            reader = new BufferedReader( new InputStreamReader(in));
            String line ="";
            while ((line = reader.readLine())!=null){
                content.append(line);
                Log.e("TAG","lx1_data----is open!");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.e("TAG","Open___FileNotFoundException"+e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("TAG","Open___IOException"+e.getMessage());
        }finally {
            {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
              return content.toString();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("TAG","onDestroy");
        if (!TextUtils.isEmpty(editText.getText().toString().trim())) {
            String  inputEd =editText.getText().toString().trim();
            Log.e("TAG","editText.getText().toString().trim()----"
            +inputEd);
            save(inputEd);
        }
    }

    private void save(String inputEd) {
        Log.e("TAG","lx1_data----zb save!");
        FileOutputStream out=null;
        BufferedWriter writer =null;
        try {
            out = openFileOutput("lx1_data", Context.MODE_PRIVATE);
            writer = new BufferedWriter( new OutputStreamWriter(out));
            writer.write(inputEd);
            Log.e("TAG","lx1_data----is save!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.e("TAG","Save___FileNotFoundException"+e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("TAG","Save___IOException"+e.getMessage());
        }finally {
            {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
