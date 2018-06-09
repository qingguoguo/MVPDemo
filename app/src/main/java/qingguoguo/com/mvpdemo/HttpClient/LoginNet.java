package qingguoguo.com.mvpdemo.HttpClient;

import qingguoguo.com.mvpdemo.bean.User;

/**
 * 作者:qingguoguo
 * 创建日期：2018/1/7 on 15:56
 * 描述:
 */

public class LoginNet {
    public void login(final String username, final String password, final OnHttpListener loginListener) {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("123456".equals(username) && "123456".equals(password)) {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginListener.onSuccess("登录成功");
                } else {
                    loginListener.onFailed("登录失败");
                }
            }
        }.start();
    }
}
