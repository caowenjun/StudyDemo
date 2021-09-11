package android.example.myapplication.ButterKnife;

import android.app.Activity;
import android.view.View;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ButterKnifeUtils {
    public static void inject(Activity activity) {
        Class<? extends Activity> activityClass = activity.getClass();
        Method[] activityMethods = activityClass.getDeclaredMethods();
        for (Method method : activityMethods) {
            //获得方法上的注解
            Annotation[] annotations = method.getAnnotations();
            //遍历一个方法的所有注解
            for (Annotation annotation : annotations) {
                //获取注解的Class
                Class<? extends Annotation> annotationType = annotation.annotationType();
                //通过注解的Class可以通过反射判断注解上有没有EventType注解
                if (annotationType.isAnnotationPresent(EventType.class)) {
                    //拿到注解上的eventType注解对象
                    EventType eventType = annotationType.getAnnotation(EventType.class);
                    //通过eventType注解对象拿到传递的属性
                    String methodName = eventType.invokeMethodName();
                    Class proxyClass = eventType.ProxyClass();

                    try {
                        //先通过动态代理 实现onclick方法
                        Object proxy = Proxy.newProxyInstance(activity.getClassLoader(),
                                new Class[]{proxyClass}, (o, method1, objects) ->
                                        //代理需要执行加了Click注解的方法
                                        method.invoke(activity,objects));

                        //通过反射拿到annotation对象的value方法，比如click的value方法
                        Method value = annotationType.getDeclaredMethod("value");
                        //通过调用value方法获取click注解上面注册的view的id
                        int[] views = (int[]) value.invoke(annotation);
                        for (int view : views) {
                            View realView = activity.findViewById(view);
                            //找到 setOnclickListener方法 并且invoke执行
                            realView.getClass().getMethod(methodName,proxyClass).invoke(realView,proxy);
                        }

                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }
}
