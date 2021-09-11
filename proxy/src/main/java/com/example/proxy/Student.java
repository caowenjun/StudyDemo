package com.example.proxy;

import com.example.proxy.proxyHandler.ProxyInvokeHandler;

import java.lang.reflect.Proxy;

public class Student {
    public static void main(String[] args) {
        //JAVA动态代理
        /**
         * 1.类加载器
         * 2.需要代理的接口
         * 3.回调
         */
        Ndk lance = new Lance();
        Ndk ndk = (Ndk) Proxy.newProxyInstance(lance.getClass().getClassLoader(), new Class[]{Ndk.class},
                new ProxyInvokeHandler(lance));
        ndk.ndk();

    }
}