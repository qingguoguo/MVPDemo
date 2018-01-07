package qingguoguo.com.mvpdemo.mvp_middle;

import qingguoguo.com.mvpdemo.HttpClient.OnHttpListener;
import qingguoguo.com.mvpdemo.LoginModel;


/**
 * 作者:qingguoguo
 * 创建日期：2018/1/7 on 15:56
 * 描述:
 */

public class LoginPresenter extends MvpBasePresenter<LoginView> {

    private LoginModel mLoginModel;

    public LoginPresenter() {
        mLoginModel = new LoginModel();
    }

    public void login(String username, String password) {
        this.mLoginModel.login(username, password, new OnHttpListener() {
            @Override
            public void onSuccess(String data) {
                if (getView() != null) {
                    getView().onLoginResult(data);
                }
            }

            @Override
            public void onFailed(String msg) {
                if (getView() != null) {
                    getView().onLoginResult(msg);
                }
            }
        });
    }
}
