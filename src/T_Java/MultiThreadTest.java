package T_Java;

public class MultiThreadTest {
    static int i = 0;
    static int j = 0;

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> i = 1);

        Thread threadB = new Thread(() -> j = i);

        Thread threadC = new Thread(() -> i = 2);
        System.out.println("---> " + j);
    }
}
