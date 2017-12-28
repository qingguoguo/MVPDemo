package qingguoguo.com.mvpdemo.mvp_primary;

/**
 * 作者:王青 admin
 * 创建日期：2017/12/29 on 0:48
 * 描述:
 */

public interface LoginView {

    void login();

    String getUserName();

    String getPassword();

    void showFailedError();
}
