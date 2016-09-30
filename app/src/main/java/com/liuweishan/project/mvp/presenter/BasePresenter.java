package com.liuweishan.project.mvp.presenter;

/**
 * Created by Shanzi on 2016/9/30.
 */

public abstract class BasePresenter<T> {
    public T mView;

    public void attach(T mView) {
        this.mView = mView;
    }

    public void dettach() {
        mView = null;
    }

}
