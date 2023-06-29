package ProxyPractice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DebugInvocationHandler implements InvocationHandler {
    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(target, args);
        System.out.println(result);
        System.out.println("after");
        return result;
    }
}
