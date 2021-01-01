package T_Java;

public class ClassStaticFinalInitTest {
    public static void main(String[] args) {
        System.out.println(SuperClass.SuperClassIntValue);
    }

    static class SuperClass {
        public static final int SuperClassIntValue = 123;

        static {
            System.out.println("SuperClass init!");
        }
    }
}