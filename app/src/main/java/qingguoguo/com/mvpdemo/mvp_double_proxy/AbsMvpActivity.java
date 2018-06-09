package qingguoguo.com.mvpdemo.mvp_double_proxy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import qingguoguo.com.mvpdemo.mvp_double_proxy.base.AbsMvpPresenter;
import qingguoguo.com.mvpdemo.mvp_double_proxy.base.IMvpView;

/**
 * 作者:qingguoguo
 * 创建日期：2018/1/7 on 15:56
 * 描述: 静态代理
 */

public abstract class AbsMvpActivity<V extends IMvpView, P extends AbsMvpPresenter<V>> extends AppCompatActivity implements MvpCallBack<V, P> {

    private ActivityMvpDelegate<V, P> mMvpDelegate;
    private P mPresenter;

    public ActivityMvpDelegate<V, P> getMvpDelegate() {
        if (mMvpDelegate == null) {
            mMvpDelegate = new ActivityMvpDelegateImpl<V, P>(this);
        }
        return mMvpDelegate;
    }

    @Override
    public P createPresenter() {
        return mPresenter;
    }

    @Override
    public V createView() {
        return (V) this;
    }

    @Override
    public P getMvpPresenter() {
        return mPresenter;
    }

    @Override
    public V getMvpView() {
        return (V) this;
    }

    @Override
    public void setMvpPresenter(P presenter) {
        mPresenter = presenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMvpDelegate().onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getMvpDelegate().onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getMvpDelegate().onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getMvpDelegate().onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        getMvpDelegate().onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        getMvpDelegate().onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getMvpDelegate().onDestroy();
    }
}
