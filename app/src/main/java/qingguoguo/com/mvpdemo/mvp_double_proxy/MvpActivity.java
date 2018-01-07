package qingguoguo.com.mvpdemo.mvp_double_proxy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import qingguoguo.com.mvpdemo.mvp_base.MvpPresenter;
import qingguoguo.com.mvpdemo.mvp_base.MvpView;

/**
 * 作者:qingguoguo
 * 创建日期：2018/1/7 on 15:56
 * 描述:
 */

public abstract class MvpActivity<V extends MvpView, P extends MvpPresenter<V>> extends AppCompatActivity implements MvpCallBack<V, P>, MvpView {

    private ActivityMvpDelegate<V, P> mMvpDelegate;
    private P mPresenter;

    public ActivityMvpDelegate<V, P> getMvpDelegate() {
        if (mMvpDelegate == null) {
            mMvpDelegate = new ActivityMvpDelegatelmpl<V, P>(this);
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
    public P getMvpPersenter() {
        return mPresenter;
    }

    @Override
    public V getMvpView() {
        return (V) this;
    }

    @Override
    public void setMvpPersenter(P presenter) {
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
        getMvpDelegate().onDestory();
    }
}
