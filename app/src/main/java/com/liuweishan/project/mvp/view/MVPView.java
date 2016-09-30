package com.liuweishan.project.mvp.view;

import java.util.List;

/**
 * Created by Shanzi on 2016/9/16.
 */
public interface MVPView extends BaseMVPView{

    void setListView(List<String> data);

    void showMessage(String string);
}
