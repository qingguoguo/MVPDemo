package qingguoguo.com.mvpdemo.mvp_final.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import qingguoguo.com.mvpdemo.mvp_final.mvp.proxy.ActivityMvpProxyImpl;

/**
 * 作者:qingguoguo
 * 创建日期：2018/1/7 on 15:56
 * 描述:
 * 1.反射动态创建 Model
 * 2.通过注解解决多个 Presenter，泛型保留，方便只有一个 Presenter 的情况
 */

public abstract class BaseMvpActivity<P extends BaseMvpPresenter> extends AppCompatActivity implements BaseMvpView {

    private P mPresenter;
    private ActivityMvpProxyImpl mActivityMvpProxy;

    public P getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        createAndAttachView();
        initView();
        initData();
    }

    private void createAndAttachView() {
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        mActivityMvpProxy = new ActivityMvpProxyImpl(this);
        mActivityMvpProxy.bindAndCreatePresenter();
    }

    protected abstract P createPresenter();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void setContentView();


    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        mActivityMvpProxy.unbindPresenter();
        super.onDestroy();
    }
}
