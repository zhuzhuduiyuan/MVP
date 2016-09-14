package com.liuweishan.project.mvp.biz;

import java.util.List;

/**
 * Created by Zys on 2016/9/14.
 */
public interface OnRequestListener {
    void onSuccess(List<String> data);

    void onFailed();


}
