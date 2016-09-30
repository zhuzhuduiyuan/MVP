package com.liuweishan.project.mvp.view;

import android.app.Activity;
import android.os.Bundle;

import com.liuweishan.project.mvp.presenter.BasePresenter;

/**
 * Created by Shanzi on 2016/9/30.
 */

public abstract class BaseMVPActivity<V,T extends BasePresenter<V>> extends Activity{
    public T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
    }

    protected abstract T initPresenter();

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attach((V)this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dettach();
    }
}
