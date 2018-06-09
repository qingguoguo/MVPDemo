package qingguoguo.com.mvpdemo.mvp.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import qingguoguo.com.mvpdemo.mvp.Utils;

/**
 * 作者:qingguoguo
 * 创建日期：2018/1/7 on 15:56
 * 描述: 动态创建的 model 的对象
 */

public class BaseMvpPresenter<V extends BaseMvpView, M extends BaseModel> implements IMvpPresenter<V> {

    private V mView;
    private M mModel;

    public V getView() {
        return mView;
    }

    public M getModel() {
        return mModel;
    }

    @Override
    public void attachView(V view) {
        Utils.checkNotNull(view, "view 不能为 null");
        this.mView = view;
        initModel();
    }

    private void initModel() {
        Type[] params = ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments();
        try {
            // 获取 BaseMvpPresenter 上的第二个泛型 M  要判断一下类型 BaseModel
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
