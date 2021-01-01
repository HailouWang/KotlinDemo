package T_Java;

public class BlockRunningTest {

    static class BlockRunningObject {
        static {
            if (true) {
                System.out.println(Thread.currentThread() + "初始化 BlockRunningTest");
                while (true) {

                }
            }
        }
    }

    public static void main(String[] args) {
        Runnable runnableTask = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "线程任务 ------> 开始！");
                BlockRunningObject blockRunningObject = new BlockRunningObject();
                System.out.println(Thread.currentThread() + "线程任务 ------> 结束！");
            }
        };

        Thread thread1 = new Thread(runnableTask);
        Thread thread2 = new Thread(runnableTask);

        thread1.start();
        thread2.start();
    }
}
