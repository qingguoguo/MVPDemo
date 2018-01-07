package qingguoguo.com.mvpdemo.mvp_double_proxy;

import qingguoguo.com.mvpdemo.mvp_base.MvpPresenter;
import qingguoguo.com.mvpdemo.mvp_base.MvpView;

/**
 * 作者:qingguoguo
 * 创建日期：2018/1/7 on 22:11
 * 描述:
 */

public interface MvpCallBack<V extends MvpView, P extends MvpPresenter<V>> {

    P createPresenter();

    P getMvpPersenter();

    V createView();

    V getMvpView();

    void setMvpPersenter(P presenter);
}
