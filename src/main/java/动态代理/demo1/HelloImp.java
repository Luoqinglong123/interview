package 动态代理.demo1;

// 实现
public class HelloImp implements Hello{
    @Override
    public String sayHello(String str) {
        return "HelloImp: " + str;
    }
}