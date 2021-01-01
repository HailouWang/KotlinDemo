package T_Java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    interface IHello {
        void sayHello();
    }

    static class Hello implements IHello {

        @Override
        public void sayHello() {
            System.out.println("HelloWorld");
        }
    }

    static class DynamicProxy implements InvocationHandler {
        Object orignalObject;

        Object bind(Object orignalObject) {
            this.orignalObject = orignalObject;
            return Proxy.newProxyInstance(orignalObject.getClass().getClassLoader(), orignalObject.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Welcome");
            return method.invoke(orignalObject, args);
        }
    }

    public static void main(String[] args) {
        Object helloProxyObject = new DynamicProxy().bind(new Hello());
        if (helloProxyObject instanceof IHello) {
            ((IHello) helloProxyObject).sayHello();
        }
    }
}
