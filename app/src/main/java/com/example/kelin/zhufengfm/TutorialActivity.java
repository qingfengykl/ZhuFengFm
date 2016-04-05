package com.example.kelin.zhufengfm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TutorialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        // TODO:更新教程页显示的设置，下一次不再显示

        SharedPreferences sp = getSharedPreferences("app", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt("tutorial.shown",BuildConfig.VERSION_CODE);
        edit.apply();

    }

    public void btnGoNext(View v){
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
