package qingguoguo.com.mvpdemo.mvp_final.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import qingguoguo.com.mvpdemo.mvp_final.mvp.proxy.FragmentMvpProxyImpl;

/**
 * @author :qingguoguo
 * @datetime ：2018/6/10
 * @describe :
 */
public abstract class BaseFragment<P extends BaseMvpPresenter> extends Fragment implements BaseMvpView {

    private P mPresenter;
    private FragmentMvpProxyImpl mFragmentMvpProxy;

    public P getPresenter() {
        return mPresenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        createAndAttachView();
        View rootView = inflater.inflate(getLayoutResId(), container);
        initView();
        initData();
        return rootView;
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract P createPresenter();

    protected abstract int getLayoutResId();

    private void createAndAttachView() {
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        mFragmentMvpProxy = new FragmentMvpProxyImpl<>(this);
        mFragmentMvpProxy.bindAndCreatePresenter();
    }


    @Override
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        mFragmentMvpProxy.unbindPresenter();
        super.onDestroy();
    }
}
