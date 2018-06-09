package qingguoguo.com.mvpdemo.mvp_double_proxy;

import android.os.Bundle;

import qingguoguo.com.mvpdemo.mvp_double_proxy.base.AbsMvpPresenter;
import qingguoguo.com.mvpdemo.mvp_double_proxy.base.IMvpView;


/**
 * 作者:qingguoguo
 * 创建日期：2018/1/7 on 21:33
 * 描述:
 */

public interface ActivityMvpDelegate<V extends IMvpView, P extends AbsMvpPresenter> {

    void onCreate(Bundle savedInstanceState);

    void onStart();

    void onResume();

    void onPause();

    void onRestart();

    void onStop();

    void onDestroy();
}
