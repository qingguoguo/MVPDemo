package qingguoguo.com.mvpdemo.mvp_double_proxy;

import android.os.Bundle;

import qingguoguo.com.mvpdemo.mvp_base.MvpPresenter;
import qingguoguo.com.mvpdemo.mvp_base.MvpView;

/**
 * 作者:qingguoguo
 * 创建日期：2018/1/7 on 21:33
 * 描述:
 */

public interface ActivityMvpDelegate<V extends MvpView, P extends MvpPresenter> {

    void onCreate(Bundle savedInstanceState);

    void onStart();

    void onResume();

    void onPause();

    void onRestart();

    void onStop();

    void onDestory();
}
