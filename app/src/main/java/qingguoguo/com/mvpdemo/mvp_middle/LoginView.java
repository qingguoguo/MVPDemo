package qingguoguo.com.mvpdemo.mvp_middle;

import qingguoguo.com.mvpdemo.mvp_base.MvpView;

/**
 * 作者:qingguoguo
 * 创建日期：2018/1/7 on 15:56
 * 描述:
 */

public interface LoginView extends MvpView {
    void onLoginResult(String result);
}
