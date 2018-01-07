package qingguoguo.com.mvpdemo.mvp_middle;

/**
 * 作者:qingguoguo
 * 创建日期：2018/1/7 on 15:56
 * 描述:
 */

public interface MvpPresenter<V extends MvpView> {
    void attachView(V view);
    void detachView();
}
