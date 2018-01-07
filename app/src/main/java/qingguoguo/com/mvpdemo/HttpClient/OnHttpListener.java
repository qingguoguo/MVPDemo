package qingguoguo.com.mvpdemo.HttpClient;

/**
 * 作者:qingguoguo
 * 创建日期：2018/1/7 on 15:56
 * 描述:
 */

public interface OnHttpListener {

    void onSuccess(String data);

    void onFailed(String msg);
}
