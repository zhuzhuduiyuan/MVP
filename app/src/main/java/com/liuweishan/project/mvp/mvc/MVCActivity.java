package com.liuweishan.project.mvp.mvc;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.liuweishan.project.mvp.R;
import com.liuweishan.project.mvp.biz.OnRequestListener;
import com.liuweishan.project.mvp.biz.RequestBiz;
import com.liuweishan.project.mvp.biz.RequestBizImpl;

import java.util.List;

/**
 * Created by Shanzi on 2016/9/16.
 */
public class MVCActivity extends Activity{

    private RequestBiz requestBiz;
    private TextView tv;
    private ListView lv;
    private Handler handler;
    private AdapterView.OnItemClickListener itemClickListener;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);

        initView();
        setREquestData();

        itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(context, "click" + i, Toast.LENGTH_SHORT).show();
            }
        };

    }

    private void initView() {
        context = MVCActivity.this;
        requestBiz = new RequestBizImpl();
        tv = (TextView) findViewById(R.id.tv);
        lv = (ListView) findViewById(R.id.lv);
        handler = new Handler(Looper.getMainLooper());
        tv.setVisibility(View.VISIBLE);

    }

    private void setREquestData() {
        requestBiz.requestForData(new OnRequestListener() {
            @Override
            public void onSuccess(final List<String> data) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        tv.setVisibility(View.GONE);
                        ArrayAdapter adapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, data);
                        lv.setAdapter(adapter);
                        lv.setOnItemClickListener(itemClickListener);
                    }
                });

            }
            @Override
            public void onFailed() {
                Toast.makeText(context, "加载失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
