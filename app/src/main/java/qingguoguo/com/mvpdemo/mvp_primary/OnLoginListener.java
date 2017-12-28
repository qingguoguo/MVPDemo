package qingguoguo.com.mvpdemo.mvp_primary;

import qingguoguo.com.mvpdemo.mvp_primary.bean.User;

/**
 * 作者:王青 admin
 * 创建日期：2017/12/29 on 1:13
 * 描述:
 */

public interface OnLoginListener {

    void loginSuccess(User user);

    void loginFailed();
}
