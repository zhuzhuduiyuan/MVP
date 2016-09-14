package com.liuweishan.project.mvp;

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

import java.util.List;
import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {

    private RequestBiz requestBiz;
    private TextView tv;
    private ListView lv;
    private Handler handler;
    private AdapterView.OnItemClickListener itemClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        requestBiz = new RequestBizImpl();
        tv = (TextView) findViewById(R.id.tv);
        lv = (ListView) findViewById(R.id.lv);
//        handler = new Handler(Looper.getMainLooper());
        tv.setVisibility(View.VISIBLE);
        setREquestData();

        itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "click" + i, Toast.LENGTH_SHORT).show();
            }
        };

    }

    private void setREquestData() {
        requestBiz.requestForData(new OnRequestListener() {
            @Override
            public void onSuccess(List<String> data) {
                tv.setVisibility(View.GONE);
                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, data);
                lv.setAdapter(adapter);
                lv.setOnItemClickListener(itemClickListener);
            }
            @Override
            public void onFailed() {

            }
        });
    }
}
