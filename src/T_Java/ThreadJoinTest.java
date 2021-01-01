package T_Java;

public class ThreadJoinTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new JoinTask());
        thread.start();

        for (int i = 0; i < 10; i++) {

            System.out.println("主线程第" + i + "此执行！");

            if (i >= 2) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class JoinTask implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("线程JoinTask 第" + i + "次执行");
        }
    }
}