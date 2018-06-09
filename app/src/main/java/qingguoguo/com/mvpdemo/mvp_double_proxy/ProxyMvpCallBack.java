package qingguoguo.com.mvpdemo.mvp_double_proxy;

import qingguoguo.com.mvpdemo.mvp_double_proxy.base.AbsMvpPresenter;
import qingguoguo.com.mvpdemo.mvp_double_proxy.base.IMvpView;

/**
 * 作者:qingguoguo
 * 创建日期：2018/1/7 on 23:05
 * 描述:双重代理实现MVP模式
 */

public class ProxyMvpCallBack<V extends IMvpView, P extends AbsMvpPresenter<V>> implements MvpCallBack<V, P> {

    private MvpCallBack<V, P> mVPMvpCallBack;

    public ProxyMvpCallBack(MvpCallBack<V, P> VPMvpCallBack) {
        mVPMvpCallBack = VPMvpCallBack;
    }

    @Override
    public P createPresenter() {
        P presenter = mVPMvpCallBack.getMvpPresenter();
        if (presenter == null) {
            presenter = this.mVPMvpCallBack.createPresenter();
        }

        if (presenter == null) {
            throw new NullPointerException("presenter 不能为空");
        }
        mVPMvpCallBack.setMvpPresenter(presenter);
        return presenter;
    }

    @Override
    public P getMvpPresenter() {
        return mVPMvpCallBack.getMvpPresenter();
    }

    @Override
    public void setMvpPresenter(P presenter) {

    }

    @Override
    public V createView() {
        V view = mVPMvpCallBack.getMvpView();
        if (view == null) {
            view = mVPMvpCallBack.createView();
        }
        if (view == null) {
            throw new NullPointerException("view 不能为空");
        }
        return view;
    }

    @Override
    public V getMvpView() {
        return mVPMvpCallBack.getMvpView();
    }

    public void attachView() {
        getMvpPresenter().attachView(getMvpView());
    }

    public void detachView() {
        getMvpPresenter().detachView();
    }
}
