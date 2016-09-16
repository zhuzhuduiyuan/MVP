package com.liuweishan.project.mvp;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.liuweishan.project.mvp.biz.OnRequestListener;
import com.liuweishan.project.mvp.biz.RequestBiz;
import com.liuweishan.project.mvp.biz.RequestBizImpl;
import com.liuweishan.project.mvp.mvc.MVCActivity;
import com.liuweishan.project.mvp.mvp.view.MVPActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        startActivity(new Intent(MainActivity.this, MVPActivity.class));
    }
}
