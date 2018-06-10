package qingguoguo.com.mvpdemo.mvp_final.mvp.base;

/**
 * 作者:qingguoguo
 * 创建日期：2018/1/7 on 15:56
 * 描述: 抽象 P
 */

public interface IMvpPresenter<V extends BaseMvpView> {

    void attachView(V view);

    void detachView();
}
