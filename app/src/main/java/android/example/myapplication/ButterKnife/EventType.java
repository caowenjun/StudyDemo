package android.example.myapplication.ButterKnife;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface EventType {
    //想通过动态代理来实现的接口的Class
    Class ProxyClass();
    //需要执行的方法名，用于反射调用此方法
    String invokeMethodName();
}
