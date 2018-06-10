package qingguoguo.com.mvpdemo.mvp_final.mvp.proxy;

import qingguoguo.com.mvpdemo.mvp_final.mvp.base.BaseMvpView;

/**
 * @author :qingguoguo
 * @datetime ：2018/6/10
 * @describe :
 */
public class FragmentMvpImpl<V extends BaseMvpView> extends MvpProxyImpl<V> implements IFragmentMvpProxy{

    public FragmentMvpImpl(V view) {
        super(view);
    }
}
