package com.example.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;

public class MyData {

    public int number;
    private Context context;
    public MyData(Context context){
        this.context = context;
    }

    public void save(){
        String name = context.getResources().getString(R.string.MY_DATA);
        //不在MainActivity.java文件中，需要先context.getResources()
        SharedPreferences sharedPreferences = context.getSharedPreferences(name,Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        String key = context.getResources().getString(R.string.MY_KEY);
        editor.putInt(key,number);
        editor.apply();
    }

    public int load(){
        String name = context.getResources().getString(R.string.MY_DATA);
        //不在MainActivity.java文件中，需要先context.getResources()
        SharedPreferences sharedPreferences = context.getSharedPreferences(name,Context.MODE_PRIVATE);

        String key = context.getResources().getString(R.string.MY_KEY);
        int x = sharedPreferences.getInt(key,context.getResources().getInteger(R.integer.defValue));

        number = x;
        return x;

    }
}
