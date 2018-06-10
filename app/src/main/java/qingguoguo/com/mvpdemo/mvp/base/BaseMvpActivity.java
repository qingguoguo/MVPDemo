package qingguoguo.com.mvpdemo.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import qingguoguo.com.mvpdemo.mvp.InjectPresenter;
import qingguoguo.com.mvpdemo.mvp.Utils;

/**
 * 作者:qingguoguo
 * 创建日期：2018/1/7 on 15:56
 * 描述:
 * 1.反射动态创建 Model
 * 2.通过注解解决多个 Presenter，泛型保留，方便只有一个 Presenter 的情况
 */

public abstract class BaseMvpActivity<V extends BaseMvpView, P extends BaseMvpPresenter> extends AppCompatActivity implements BaseMvpView {

    private P mPresenter;
    private List<BaseMvpPresenter> mBasePresenters;

    public P getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        initView();
        initData();
        createAndAttachView();
    }

    private void createAndAttachView() {
        mBasePresenters = new ArrayList<>();
        mPresenter = createPresenter();
        Utils.checkNotNull(mPresenter, "mPresenter 不能为 null");

        // @InjectPresenter
        // LoginPresenter mLoginPresenter
        Field[] declaredFields = this.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            InjectPresenter annotation = field.getAnnotation(InjectPresenter.class);
            if (annotation != null) {
                Class<?> fieldClazz = field.getType();
                // 要判断一下类型  获取父类，如果不是 BasePresenter 的子类 抛异常
                if (!BaseMvpPresenter.class.isAssignableFrom(fieldClazz)) {
                    throw new RuntimeException("InjectPresenter 注解的属性应该是 BaseMvpPresenter 的子类");
                }
                try {
                    BaseMvpPresenter basePresenter = (BaseMvpPresenter) fieldClazz.newInstance();
                    field.setAccessible(true);
                    field.set(this, basePresenter);
                    basePresenter.attachView(this);
                    mBasePresenters.add(basePresenter);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected abstract P createPresenter();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void setContentView();


    @Override
    protected void onDestroy() {
        // 解绑
        if (mBasePresenters != null) {
            for (BaseMvpPresenter presenter : mBasePresenters) {
                presenter.detachView();
            }
        }
        mPresenter.detachView();
        super.onDestroy();
    }
}
