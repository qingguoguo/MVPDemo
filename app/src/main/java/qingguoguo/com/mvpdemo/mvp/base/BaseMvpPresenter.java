package qingguoguo.com.mvpdemo.mvp.base;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

import qingguoguo.com.mvpdemo.mvp.Utils;

/**
 * 作者:qingguoguo
 * 创建日期：2018/1/7 on 15:56
 * 描述:
 * 1.动态创建的 model 的对象
 * 2.动态代理，避免每次都要判断 View==null 也可以不用动态代理
 * 3.P层 代码可以越来越复杂，静态代理抽离 Fragment Activity
 */

public class BaseMvpPresenter<V extends BaseMvpView, M extends BaseModel> implements IMvpPresenter<V> {

    private V mView;
    private M mModel;
    /**
     * 动态代理 View
     */
    private V mProxyView;

    public V getView() {
        //return mView;
        return mProxyView;
    }

    public M getModel() {
        return mModel;
    }

    @Override
    public void attachView(V view) {
        Utils.checkNotNull(view, "view 不能为 null");
        if (view.getClass().isInterface()) {
            throw new RuntimeException("view 不能是 interface");
        }
        this.mView = view;
        mProxyView = initProxyView();
        initModel();
    }

    private V initProxyView() {
        return (V) Proxy.newProxyInstance(mView.getClass().getClassLoader(),
                mView.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 如果解绑了 mView == null
                        if (mView == null) {
                            return null;
                        }
                        // 如果没有解绑 执行原始代理的方法
                        return method.invoke(mView, args);
                    }
                });
    }

    private void initModel() {
        Type[] params = ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments();
        try {
            // 获取 BaseMvpPresenter 上的第二个泛型 M  要判断一下类型 BaseModel
            if (params.length != 2) {
                throw new RuntimeException("Presenter 必须带两个泛型参数");
            }
            mModel = (M) ((Class) params[1]).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void detachView() {
        this.mView = null;
    }
}
