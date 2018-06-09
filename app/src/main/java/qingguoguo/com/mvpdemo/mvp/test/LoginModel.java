package qingguoguo.com.mvpdemo.mvp.test;

import qingguoguo.com.mvpdemo.HttpClient.LoginNet;
import qingguoguo.com.mvpdemo.HttpClient.OnHttpListener;
import qingguoguo.com.mvpdemo.mvp.base.BaseModel;

/**
 * 作者:qingguoguo
 * 创建日期：2018/1/7 on 15:56
 * 描述:
 */

public class LoginModel extends BaseModel {

    public void login(final String username, final String password, final OnHttpListener loginListener) {
        new LoginNet().login(username, password, loginListener);
    }
}
