package T_Java;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleTest {
    static class ClassA {
        public void println(String s) {
            System.out.println("ClassA println --> " + s);
        }
    }

    public static void main(String[] args) throws Throwable {
//        Object soutObj = System.out;
//        getPrintlnMH(soutObj).invokeExact("HelloWorld!");
        Object classAObj = new ClassA();
        getPrintlnMH(classAObj).invokeExact("HelloWorld!");
    }

    private static MethodHandle getPrintlnMH(Object receiver) throws Throwable {
        MethodType mt = MethodType.methodType(void.class, String.class);

        return MethodHandles.lookup().findVirtual(receiver.getClass(), "println", mt).bindTo(receiver);
    }
}
