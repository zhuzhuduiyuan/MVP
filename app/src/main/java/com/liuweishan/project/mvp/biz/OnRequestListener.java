package com.liuweishan.project.mvp.biz;

import java.util.List;

public interface OnRequestListener {
    void onSuccess(List<String> data);

    void onFailed();


}
