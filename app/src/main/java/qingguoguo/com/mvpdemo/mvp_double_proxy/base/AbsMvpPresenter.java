package qingguoguo.com.mvpdemo.mvp_double_proxy.base;

/**
 * 作者:qingguoguo
 * 创建日期：2018/1/7 on 15:56
 * 描述:
 */

public abstract class AbsMvpPresenter<V extends IMvpView> implements IMvpPresenter<V> {

    private V view;

    public V getView() {
        return view;
    }

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
