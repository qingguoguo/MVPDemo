package qingguoguo.com.mvpdemo.HttpClient;

import qingguoguo.com.mvpdemo.mvp_primary.bean.User;

/**
 * 作者:王青 admin
 * 创建日期：2017/12/29 on 1:06
 * 描述:
 */

public class LoginNet {
    public void login(final String username, final String password, final OnHttpListener loginListener) {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("qingguoguo".equals(username) && "123456".equals(password)) {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginListener.onSuccess("登录成功");
                } else {
                    loginListener.onFailed("登录成功");
                }
            }
        }.start();
    }
}
