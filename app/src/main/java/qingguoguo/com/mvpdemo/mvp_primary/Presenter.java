package qingguoguo.com.mvpdemo.mvp_primary;

import qingguoguo.com.mvpdemo.mvp_primary.bean.User;

/**
 * 作者:王青 admin
 * 创建日期：2017/12/29 on 0:21
 */

public class Presenter {

    private LoginView mLoginView;
    private LoginNet loginNet;

    public Presenter(LoginView mLoginView) {
        mLoginView = mLoginView;
        loginNet = new LoginNet();
    }

    public LoginView getView() {
        return mLoginView;
    }

    public void setView(LoginView view) {
        mLoginView = mLoginView;
    }


    public void login() {
        loginNet.login(mLoginView.getUserName(), mLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(User user) {

            }

            @Override
            public void loginFailed() {

            }
        });
    }
}
