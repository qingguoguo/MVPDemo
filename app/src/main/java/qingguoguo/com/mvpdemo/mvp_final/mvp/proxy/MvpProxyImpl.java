package qingguoguo.com.mvpdemo.mvp_final.mvp.proxy;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import qingguoguo.com.mvpdemo.mvp_final.mvp.InjectPresenter;
import qingguoguo.com.mvpdemo.mvp_final.mvp.Utils;
import qingguoguo.com.mvpdemo.mvp_final.mvp.base.BaseMvpPresenter;
import qingguoguo.com.mvpdemo.mvp_final.mvp.base.BaseMvpView;

/**
 * @author :qingguoguo
 * @datetime ：2018/6/10
 * @describe :
 */
public class MvpProxyImpl<V extends BaseMvpView> implements IMvpProxy {

    private V mView;
    private List<BaseMvpPresenter> mBasePresenters;

    public MvpProxyImpl(V view) {
        Utils.checkNotNull(view, "view 不能为 null");
        if (view.getClass().isInterface()) {
            throw new RuntimeException("view 不能是 interface");
        }
        mBasePresenters = new ArrayList<>();
        this.mView = view;
    }

    @Override
    public void bindAndCreatePresenter() {
        Field[] declaredFields = this.mView.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            InjectPresenter annotation = field.getAnnotation(InjectPresenter.class);
            if (annotation != null) {
                Class<?> fieldClazz = field.getType();
                // 要判断一下类型  获取父类，如果不是 BasePresenter 的子类 抛异常
                if (!BaseMvpPresenter.class.isAssignableFrom(fieldClazz)) {
                    throw new RuntimeException("InjectPresenter 注解的属性应该是 BaseMvpPresenter 的子类");
                }

                try {
                    BaseMvpPresenter presenter = (BaseMvpPresenter) fieldClazz.newInstance();
                    field.setAccessible(true);
                    field.set(this.mView, presenter);
                    presenter.attachView(mView);
                    checkIsImplementsView(presenter);
                    mBasePresenters.add(presenter);

                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 检查是否实现了 View
     *
     * @param presenter
     */
    private void checkIsImplementsView(BaseMvpPresenter presenter) {
        Type[] params = ((ParameterizedType) presenter.getClass()
                .getGenericSuperclass()).getActualTypeArguments();
        // 获取 Presenter 上的第一个泛型 V  要判断 mView 是否 implements View
        if (params.length != 2) {
            throw new RuntimeException("Presenter 必须带两个泛型参数");
        }
        Class viewClass = (Class) params[0];
        Class<?>[] viewInterfaces = mView.getClass().getInterfaces();

        boolean isImplementsView = false;
        if (viewInterfaces != null) {
            for (Class<?> interfaceClass : viewInterfaces) {
                if (interfaceClass.isAssignableFrom(viewClass)) {
                    isImplementsView = true;
                }
            }
        }

        if (!isImplementsView) {
            throw new RuntimeException(mView.getClass().getName() +
                    "must implements " + viewClass.getSimpleName());
        }
    }

    @Override
    public void unbindPresenter() {
        this.mView = null;
        if (mBasePresenters != null) {
            for (BaseMvpPresenter presenter : mBasePresenters) {
                presenter.detachView();
            }
        }
    }
}
