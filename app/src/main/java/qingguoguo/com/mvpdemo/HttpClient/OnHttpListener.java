package qingguoguo.com.mvpdemo.HttpClient;

/**
 * 作者:王青 admin
 * 创建日期：2017/12/29 on 1:13
 * 描述:
 */

public interface OnHttpListener {

    void onSuccess(String data);

    void onFailed(String msg);
}
