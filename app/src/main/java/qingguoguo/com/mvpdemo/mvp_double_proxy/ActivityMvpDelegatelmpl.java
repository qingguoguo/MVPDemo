package qingguoguo.com.mvpdemo.mvp_double_proxy;

import android.os.Bundle;

import qingguoguo.com.mvpdemo.mvp_base.MvpPresenter;
import qingguoguo.com.mvpdemo.mvp_base.MvpView;

/**
 * 作者:qingguoguo
 * 创建日期：2018/1/7 on 21:34
 * 描述:
 */

public class ActivityMvpDelegatelmpl<V extends MvpView, P extends MvpPresenter<V>> implements ActivityMvpDelegate {
    private ProxyMvpCallBack<V, P> mVPProxyMvpCallBack;

    public ActivityMvpDelegatelmpl(MvpCallBack<V, P> mvpCallBack) {
        mVPProxyMvpCallBack = new ProxyMvpCallBack<>(mvpCallBack);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mVPProxyMvpCallBack.createPresenter();
        mVPProxyMvpCallBack.createView();
        mVPProxyMvpCallBack.attachView();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestory() {
        mVPProxyMvpCallBack.detachview();
    }
}
