package qingguoguo.com.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import qingguoguo.com.mvpdemo.mvp_primary.LoginView;
import qingguoguo.com.mvpdemo.mvp_primary.Presenter;

/**
 * MVP 模式是从MVC演变而来
 *
 * P 主持人,持有M V引用
 */

public class LoginActivity extends AppCompatActivity implements LoginView {

    private Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new Presenter(this);
    }

    @Override
    public void login() {
        mPresenter.login();
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void showFailedError() {

    }
}
