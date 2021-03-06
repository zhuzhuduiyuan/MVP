package com.liuweishan.project.mvp.presenter;

import android.os.Handler;
import android.os.Looper;

import com.liuweishan.project.mvp.model.OnRequestListener;
import com.liuweishan.project.mvp.model.RequestBiz;
import com.liuweishan.project.mvp.model.RequestBizImpl;
import com.liuweishan.project.mvp.view.MVPView;

import java.util.List;

/**
 * Created by Shanzi on 2016/9/16.
 */
public class MvpPreSenter extends BasePresenter<MVPView>{
    public RequestBiz requestBiz;
    private MVPView mvpView;
    private final Handler handler;

    public MvpPreSenter(MVPView mvpView) {
        this.mvpView = mvpView;
        requestBiz = new RequestBizImpl();
        handler = new Handler(Looper.getMainLooper());

    }

    public void onResume() {
        mvpView.showLoading();
        requestBiz.requestForData(new OnRequestListener() {
            @Override
            public void onSuccess(final List<String> data) {

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mvpView.setListView(data);
                        mvpView.closeLoading();
                    }
                });

            }

            @Override
            public void onFailed() {
                mvpView.showMessage("加载失败");
            }
        });
    }

    public void onItemClick(int position) {
        mvpView.showMessage("点击了" + position);
    }
}
