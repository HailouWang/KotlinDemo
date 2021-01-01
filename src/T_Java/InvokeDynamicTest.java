package T_Java;

import java.lang.invoke.CallSite;
import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class InvokeDynamicTest {
    public static void main(String[] args) {

    }

    public static void testMethod(String s) {
        System.out.println("testMethod --> " + s);
    }

    public static CallSite bootstrapMethod(MethodHandles.Lookup lookup, String name, MethodType mt) throws Throwable {
        return new ConstantCallSite(lookup.findStatic(InvokeDynamicTest.class, name, mt));
    }

    private static MethodType MT_BootstrapMethod() {
//        return MethodType.fromMethodDescriptorString()
        return null;
    }
}
