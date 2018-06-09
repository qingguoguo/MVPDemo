package qingguoguo.com.mvpdemo.mvp_double_proxy.base;

/**
 * 作者:qingguoguo
 * 创建日期：2018/1/7 on 15:56
 * 描述:
 */

public interface IMvpPresenter<V extends IMvpView> {

    void attachView(V view);

    void detachView();
}
