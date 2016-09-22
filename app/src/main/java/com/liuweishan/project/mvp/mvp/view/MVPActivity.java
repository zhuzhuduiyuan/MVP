package com.liuweishan.project.mvp.mvp.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.liuweishan.project.mvp.R;
import com.liuweishan.project.mvp.mvp.presenter.MvpPreSenter;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by Shanzi on 2016/9/16.
 */
public class MVPActivity extends Activity implements AdapterView.OnItemClickListener, MVPView {
    private MvpPreSenter mvpPreSenter;
    private TextView tv;
    private Context context;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);

        mvpPreSenter = new MvpPreSenter(this);
        context = MVPActivity.this;
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mvpPreSenter.onResume();
    }

    private void initView() {
        tv = (TextView) findViewById(R.id.tv);
        lv = (ListView) findViewById(R.id.lv);
    }

    @Override
    public void showLoading() {

        tv.setVisibility(View.VISIBLE);
    }

    @Override
    public void closeLoading() {

        tv.setVisibility(View.GONE);
    }

    @Override
    public void setListView(List<String> data) {

        ArrayAdapter adapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, data);
        lv.setAdapter(adapter);
    }


    private static class MyHandler extends Handler {
        private WeakReference<MVPActivity> activityWeakReference;

        public MyHandler(MVPActivity activity) {
            activityWeakReference = new WeakReference<MVPActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            MVPActivity activity = activityWeakReference.get();
            if (activity != null) {

            }
        }
    }

    @Override
    public void showMessage(String string) {

        Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        mvpPreSenter.onItemClick(i);
    }
}
