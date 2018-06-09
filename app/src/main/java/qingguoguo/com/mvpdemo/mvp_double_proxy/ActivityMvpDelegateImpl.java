package qingguoguo.com.mvpdemo.mvp_double_proxy;

import android.os.Bundle;

import qingguoguo.com.mvpdemo.mvp_double_proxy.base.AbsMvpPresenter;
import qingguoguo.com.mvpdemo.mvp_double_proxy.base.IMvpView;


/**
 * 作者:qingguoguo
 * 创建日期：2018/1/7 on 21:34
 * 描述:
 */

public class ActivityMvpDelegateImpl<V extends IMvpView, P extends AbsMvpPresenter<V>> implements ActivityMvpDelegate {

    private ProxyMvpCallBack<V, P> mVPProxyMvpCallBack;

    public ActivityMvpDelegateImpl(MvpCallBack<V, P> mvpCallBack) {
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
    public void onDestroy() {
        mVPProxyMvpCallBack.detachView();
    }
}
