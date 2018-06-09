package qingguoguo.com.mvpdemo.mvp_double_proxy.test;

import qingguoguo.com.mvpdemo.HttpClient.OnHttpListener;
import qingguoguo.com.mvpdemo.LoginModel;
import qingguoguo.com.mvpdemo.mvp_double_proxy.base.AbsMvpPresenter;


public class LoginPresenter extends AbsMvpPresenter<LoginView> {

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
