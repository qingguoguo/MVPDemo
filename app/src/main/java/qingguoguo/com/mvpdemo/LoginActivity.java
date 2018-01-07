package qingguoguo.com.mvpdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import qingguoguo.com.mvpdemo.mvp_middle.LoginPresenter;
import qingguoguo.com.mvpdemo.mvp_middle.LoginView;
import qingguoguo.com.mvpdemo.mvp_double_proxy.MvpActivity;

/**
 * MVP 模式是从MVC演变而来
 * P 主持人,持有M V引用
 */

public class LoginActivity extends MvpActivity<LoginView,LoginPresenter> implements LoginView {

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onlogin(View view) {
        getMvpPersenter().login("qingguoguo", "123456");
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
