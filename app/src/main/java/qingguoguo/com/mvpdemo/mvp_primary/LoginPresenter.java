package qingguoguo.com.mvpdemo.mvp_primary;

import qingguoguo.com.mvpdemo.HttpClient.OnHttpListener;

/**
 * 作者:王青 admin
 * 创建日期：2017/12/29 on 0:21
 */

public class LoginPresenter {

    private LoginView mLoginView;
    private LoginModel mLoginModel;

    public LoginPresenter() {
        mLoginModel = new LoginModel();
    }

    //提供绑定 解绑方法
    public void attachView(LoginView mLoginView) {
        this.mLoginView = mLoginView;
    }

    public void detachView() {
        this.mLoginView = null;
    }

    public void login(String username, String password) {
        this.mLoginModel.login(username, password, new OnHttpListener() {
            @Override
            public void onSuccess(String data) {
                if (mLoginView != null) {
                    mLoginView.onLoginResult(data);
                }
            }

            @Override
            public void onFailed(String msg) {
                if (mLoginView != null) {
                    mLoginView.onLoginResult(msg);
                }
            }
        });
    }
}
