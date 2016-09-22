package com.liuweishan.project.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.liuweishan.project.mvp.mvp.view.MVPActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        startActivity(new Intent(MainActivity.this, MVPActivity.class));
    }
}
