package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    MyData myData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myData = new MyData(getApplicationContext());
        //用this有内存泄露的危险
        myData.number = 1000;
        myData.save();;
        int x = myData.load();
        String TAG = "myLog";
        Log.d(TAG,"oncreat:"+x);

        /*//SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences = getSharedPreferences("MY_DATA",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("NUMBER",200);
        editor.apply();

        int x = sharedPreferences.getInt("NUMBER",0);
        //默认值为0，也就是说如果没有取到值，就是0
        String TAG = "myLog";
        Log.d(TAG,"oncreat:"+x);*/
    }
}
