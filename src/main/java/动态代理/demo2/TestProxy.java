package 动态代理.demo2;


import 动态代理.demo1.Hello;
import 动态代理.demo1.HelloImp;

import java.lang.reflect.Proxy;

/**
 * @author qinglong.luo
 * @version V1.0.0
 * @time 2018/12/13 17:46
 * @description
 */
public class TestProxy {
    public static void main(String[] args){
        Hello hello = (Hello) Proxy.newProxyInstance(TestProxy.class.getClassLoader(),new Class[]{Hello.class},new LogInvocationHandler(new HelloImp()));
        String hello1 = hello.sayHello("test");
        System.out.println("真正做的事情："+hello1);
    }

}
