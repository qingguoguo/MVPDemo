package qingguoguo.com.mvpdemo.mvp_double_proxy.test;


import qingguoguo.com.mvpdemo.mvp_double_proxy.base.IMvpView;

/**
 * 作者:qingguoguo
 * 创建日期：2018/1/7 on 15:56
 * 描述:
 */

public interface LoginView extends IMvpView {

    void onLoginResult(String result);
}
