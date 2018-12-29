package 动态代理.demo2;


import 动态代理.demo1.HelloImp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author qinglong.luo
 * @version V1.0.0
 * @time 2018/12/13 17:44
 * @description
 */
public class LogInvocationHandler implements InvocationHandler{

    private HelloImp hello;

    public LogInvocationHandler(HelloImp hello) {
        this.hello = hello;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("sayHello")){
            System.out.println("执行sayhello之前调用的代理方法");
        }
        return method.invoke(hello,args);
    }
}
