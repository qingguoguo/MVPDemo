package qingguoguo.com.mvpdemo.mvp_primary;

/**
 * 作者:王青 admin
 * 创建日期：2017/12/29 on 1:04
 * 描述:
 */

public interface HttpNet {
    void login(String username, String password, OnLoginListener loginListener);
}
