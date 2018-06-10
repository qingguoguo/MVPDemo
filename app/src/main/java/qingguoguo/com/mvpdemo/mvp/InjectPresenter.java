package qingguoguo.com.mvpdemo.mvp;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author :qingguoguo
 * @datetime ：2018/6/10 11:22
 * @Describe :用来解决一个View 对应多个 P 的问题
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectPresenter {
}
