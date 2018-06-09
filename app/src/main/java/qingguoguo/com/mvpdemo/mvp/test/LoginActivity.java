package qingguoguo.com.mvpdemo.mvp.test;

import android.view.View;
import android.widget.Toast;

import qingguoguo.com.mvpdemo.R;
import qingguoguo.com.mvpdemo.mvp.AbsMvpActivity;
import qingguoguo.com.mvpdemo.mvp.InjectPresenter;


public class LoginActivity extends AbsMvpActivity<LoginView, LoginPresenter> implements LoginView {

    @InjectPresenter
    LoginPresenter mLoginPresenter;

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
    }

    public void onLogin(View view) {
        // getPresenter().login("123456", "123456");
        mLoginPresenter.login("123456", "123456");
    }

    @Override
    public void onLoginResult(final String result) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this, result, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
