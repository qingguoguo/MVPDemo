package qingguoguo.com.mvpdemo.mvp.test;

import qingguoguo.com.mvpdemo.HttpClient.OnHttpListener;
import qingguoguo.com.mvpdemo.mvp.base.BaseMvpPresenter;


public class LoginPresenter extends BaseMvpPresenter<LoginView, LoginModel> {

    public void login(String username, String password) {
        this.getModel().login(username, password, new OnHttpListener() {
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
