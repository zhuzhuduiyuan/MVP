package com.liuweishan.project.mvp.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.liuweishan.project.mvp.R;
import com.liuweishan.project.mvp.presenter.MvpPreSenter;

import java.util.List;

/**
 * Created by Shanzi on 2016/9/16.
 */
public class MVPActivity
        extends BaseMVPActivity<MVPView,MvpPreSenter>
        implements AdapterView.OnItemClickListener, MVPView {

    private TextView tv;
    private Context context;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mvp);
        context = MVPActivity.this;
        initView();
    }

    @Override
    protected MvpPreSenter initPresenter() {
        return new MvpPreSenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
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

    @Override
    public void showMessage(String string) {

        Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        presenter.onItemClick(i);
    }
}
