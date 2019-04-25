package com.wujie.daggerwanandroid.ui.fragment.project;

import com.wujie.commonmoudle.presenter.IPresenter;
import com.wujie.commonmoudle.view.IBaseView;
import com.wujie.daggerwanandroid.bean.PageListDataBean;
import com.wujie.daggerwanandroid.bean.ProjectItemBean;

/**
 * Time：2019/1/15 0015 上午 11:44
 * Author：WuChen
 * Description：
 **/
public interface ProjectListContact {

    interface View extends IBaseView {
        void getProjectList(PageListDataBean<ProjectItemBean> pageListDataBean);
    }

    interface Presenter extends IPresenter<View> {
        void getProjectList(int cid);
    }

}
