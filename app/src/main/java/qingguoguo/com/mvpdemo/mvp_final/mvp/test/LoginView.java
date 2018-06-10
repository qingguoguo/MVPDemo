package qingguoguo.com.mvpdemo.mvp_final.mvp.test;


import qingguoguo.com.mvpdemo.mvp_final.mvp.base.BaseMvpView;

/**
 * 作者:qingguoguo
 * 创建日期：2018/1/7 on 15:56
 * 描述:
 */

public interface LoginView extends BaseMvpView {

    void onLoginResult(String result);
}
