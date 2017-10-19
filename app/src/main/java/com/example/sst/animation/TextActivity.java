package com.example.sst.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.sst.animation.View.MyService;

public class TextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("TAG","Restart........");
        Intent intent=new Intent(TextActivity.this,MyService.class);
        intent.addFlags(0);
        startService(intent);
    }

    @Override
    protected void onStart() {
        Intent intent=new Intent(TextActivity.this,MyService.class);
        intent.addFlags(0);
        startService(intent);
        Log.i("tag","@2233rfiowrejfwjfa");
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG","Restart........");
        Intent intent=new Intent(TextActivity.this,MyService.class);
        intent.addFlags(0);
        startService(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(TextActivity.this,MyService.class);
        intent.addFlags(1);
        startService(intent);
        stopService(intent);
        super.onBackPressed();
    }
}
