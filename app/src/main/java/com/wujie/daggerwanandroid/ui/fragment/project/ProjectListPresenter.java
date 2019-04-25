package com.wujie.daggerwanandroid.ui.fragment.project;

import com.wujie.commonmoudle.net.BaseObserver;
import com.wujie.commonmoudle.presenter.BasePresenter;
import com.wujie.daggerwanandroid.bean.PageListDataBean;
import com.wujie.daggerwanandroid.bean.ProjectItemBean;
import com.wujie.daggerwanandroid.net.RxHelper;
import com.wujie.daggerwanandroid.net.RxRetrofit;

/**
 * Time：2019/1/15 0015 上午 11:46
 * Author：WuChen
 * Description：
 **/
public class ProjectListPresenter extends BasePresenter<ProjectListContact.View> implements ProjectListContact.Presenter {
    @Override
    public void getProjectList(int cid) {
        addDisposable(RxRetrofit.getApi()
                .getProjectList(cid)
                .compose(RxHelper.rxSchedulderHelper())
                .compose(RxHelper.handleResult2())
                .subscribeWith(new BaseObserver<PageListDataBean<ProjectItemBean>>() {
                    @Override
                    protected void start() {
                        mV.showLoading("");
                    }

                    @Override
                    protected void onSuccess(PageListDataBean<ProjectItemBean> pageListDataBean) {
                        mV.hideLoading();
                        mV.getProjectList(pageListDataBean);
                    }

                    @Override
                    protected void onFailure(int errorCode, String errorMsg) {
                        mV.showError();
                    }
                }));
    }
}
