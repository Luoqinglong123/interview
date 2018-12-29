package 动态代理.demo1;

/**
 * @author qinglong.luo
 * @version V1.0.0
 * @time 2018/12/13 17:40
 * @description
 */
public interface Hello {
    String sayHello(String str);
}



// 静态代理方式
class StaticProxiedHello implements Hello{
    private Hello hello = new HelloImp();
    @Override
    public String sayHello(String str) {
        System.out.println("You said: " + str);
        return hello.sayHello(str);
    }
}
