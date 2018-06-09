package qingguoguo.com.mvpdemo.mvp_double_proxy;

import qingguoguo.com.mvpdemo.mvp_double_proxy.base.AbsMvpPresenter;
import qingguoguo.com.mvpdemo.mvp_double_proxy.base.IMvpView;

/**
 * 作者:qingguoguo
 * 创建日期：2018/1/7 on 22:11
 * 描述:
 */

public interface MvpCallBack<V extends IMvpView, P extends AbsMvpPresenter<V>> {

    P createPresenter();

    P getMvpPresenter();

    V createView();

    V getMvpView();

    void setMvpPresenter(P presenter);
}
