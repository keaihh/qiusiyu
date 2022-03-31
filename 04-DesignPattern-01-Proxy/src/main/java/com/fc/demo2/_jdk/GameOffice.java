package com.fc.demo2._jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//游戏工作室
public class GameOffice implements InvocationHandler {
    //真实对象
    private final Object object;

    public GameOffice(Object object) {
        this.object = object;
    }

    //这个方法会对指定对象的所有执行的方法进行拦截
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       if (method.getName().equals("login")){
           System.out.println("正输入账号和密码~~~");
       }

        //执行真实对象的方法
        Object invoke = method.invoke(object, args);

        if (method.getName().equals("upGrade")){
           System.out.println("增加100点攻击力，100点生命值");
       }
        return invoke;
    }
}
