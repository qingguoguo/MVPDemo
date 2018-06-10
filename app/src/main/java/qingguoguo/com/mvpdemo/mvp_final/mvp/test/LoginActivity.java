package qingguoguo.com.mvpdemo.mvp_final.mvp.test;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import qingguoguo.com.mvpdemo.R;
import qingguoguo.com.mvpdemo.mvp_final.mvp.InjectPresenter;
import qingguoguo.com.mvpdemo.mvp_final.mvp.base.BaseMvpActivity;


public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements LoginView {

    @InjectPresenter
    LoginPresenter mLoginPresenter;

    EditText mPhone;
    EditText mPassword;

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initView() {
        mPhone = findViewById(R.id.phone);
        mPassword = findViewById(R.id.password);
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
    }

    public void onLogin(View view) {
        Editable phone = mPhone.getText();
        Editable password = mPassword.getText();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        getPresenter().login(phone.toString(), password.toString());
        mLoginPresenter.login(phone.toString(), password.toString());
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
