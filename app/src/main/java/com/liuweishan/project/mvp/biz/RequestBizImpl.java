package com.liuweishan.project.mvp.biz;

import java.util.ArrayList;

public class RequestBizImpl implements RequestBiz{
    @Override
    public void requestForData(final OnRequestListener listener) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    ArrayList<String> data = new ArrayList<String>();
                    for (int i = 0; i < 8; i++) {
                        data.add("item" + i);
                    }
                    if (listener != null) {
                        listener.onSuccess(data);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
