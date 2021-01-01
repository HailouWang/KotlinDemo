package T_Java;

public class ClassInitTest {
    public static void main(String[] args) {
        System.out.println(SubClass.SuperClassIntValue);
    }

    static class SuperClass {
        public static int SuperClassIntValue = 123;

        static {
            System.out.println("SuperClass init!");
        }
    }

    static class SubClass extends SuperClass {
        static {
            System.out.println("SubClass init!");
        }
    }
}