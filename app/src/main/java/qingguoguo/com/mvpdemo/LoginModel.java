package qingguoguo.com.mvpdemo;

import qingguoguo.com.mvpdemo.HttpClient.LoginNet;
import qingguoguo.com.mvpdemo.HttpClient.OnHttpListener;

/**
 * 作者:qingguoguo
 * 创建日期：2018/1/7 on 15:56
 * 描述:
 */

public class LoginModel {

    public void login(final String username, final String password, final OnHttpListener loginListener) {
        new LoginNet().login(username, password, loginListener);
    }
}
