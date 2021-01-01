package T_Java;

public class ClassArrayInitTest {
    public static void main(String[] args) {
        SuperClass[] superClasseArray = new SuperClass[10];
    }

    static class SuperClass {
        public static int SuperClassIntValue = 123;

        static {
            System.out.println("SuperClass init!");
        }
    }
}