package qingguoguo.com.mvpdemo.mvp_base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * 作者:qingguoguo
 * 创建日期：2018/1/7 on 15:56
 * 描述:泛型加弱引用实现抽象Presenter
 */

public abstract class MvpBasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private Reference<V> mViewReference;

    public V getView() {
        return mViewReference.get();
    }

    @Override
    public void attachView(V view) {
        this.mViewReference = new WeakReference<V>(view);
    }

    @Override
    public void detachView() {
        if (mViewReference != null) {
            mViewReference.clear();
            mViewReference = null;
        }
    }
}
