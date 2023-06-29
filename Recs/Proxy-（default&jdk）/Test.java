package ProxyPractice;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Show s = new ShowImpl();
        System.out.println(s.showfunction("Test"));
        System.out.println("----------------");
        ShowProxy showProxy = new ShowProxy(s);
        System.out.println(showProxy.showfunction("1234"));
        System.out.println("***********************************");

        Show d = (Show)Proxy.newProxyInstance(
                s.getClass().getClassLoader(),
                s.getClass().getInterfaces(),
                new DebugInvocationHandler(s)
        );
        d.showfunction("DebugInvocationHandler");
    }
}
