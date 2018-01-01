package qingguoguo.com.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import qingguoguo.com.mvpdemo.mvp_primary.LoginView;
import qingguoguo.com.mvpdemo.mvp_primary.LoginPresenter;

/**
 * MVP 模式是从MVC演变而来
 * *
 * P 主持人,持有M V引用
 */

public class LoginActivity extends AppCompatActivity implements LoginView {

    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new LoginPresenter();
        mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    public void onlogin(View view) {
        mPresenter.login("qingguoguo", "123456");
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
