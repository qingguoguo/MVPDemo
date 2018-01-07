package qingguoguo.com.mvpdemo.mvp_double_proxy;

import qingguoguo.com.mvpdemo.mvp_base.MvpPresenter;
import qingguoguo.com.mvpdemo.mvp_base.MvpView;

/**
 * 作者:qingguoguo
 * 创建日期：2018/1/7 on 23:05
 * 描述:
 */

public class ProxyMvpCallBack<V extends MvpView, P extends MvpPresenter<V>> implements MvpCallBack<V, P> {

    private MvpCallBack<V, P> mVPMvpCallBack;

    public ProxyMvpCallBack(MvpCallBack<V, P> VPMvpCallBack) {
        mVPMvpCallBack = VPMvpCallBack;
    }

    @Override
    public P createPresenter() {
        P presenter = mVPMvpCallBack.getMvpPersenter();
        if (presenter == null) {
            presenter = this.mVPMvpCallBack.createPresenter();
        }

        if (presenter == null) {
            throw new NullPointerException("presenter 不能为空");
        }
        mVPMvpCallBack.setMvpPersenter(presenter);
        return presenter;
    }

    @Override
    public P getMvpPersenter() {
        return mVPMvpCallBack.getMvpPersenter();
    }

    @Override
    public void setMvpPersenter(P presenter) {

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
        getMvpPersenter().attachView(getMvpView());
    }

    public void detachview() {
        getMvpPersenter().detachView();
    }
}
