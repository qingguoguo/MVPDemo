package qingguoguo.com.mvpdemo.mvp_primary;

import qingguoguo.com.mvpdemo.HttpClient.LoginNet;
import qingguoguo.com.mvpdemo.HttpClient.OnHttpListener;

/**
 * 作者:王青 admin
 * 创建日期：2018/1/1 on 23:05
 * 描述:
 */

public class LoginModel {

    public void login(final String username, final String password, final OnHttpListener loginListener) {
        new LoginNet().login(username, password, loginListener);
    }
}
