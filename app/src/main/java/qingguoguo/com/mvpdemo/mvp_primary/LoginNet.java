package qingguoguo.com.mvpdemo.mvp_primary;

import qingguoguo.com.mvpdemo.mvp_primary.bean.User;

/**
 * 作者:王青 admin
 * 创建日期：2017/12/29 on 1:06
 * 描述:
 */

public class LoginNet implements HttpNet {
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("qingguo".equals(username) && "123456".equals(password)) {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                } else {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}
