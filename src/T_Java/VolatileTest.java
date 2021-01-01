package T_Java;

public class VolatileTest {
    private static volatile int race = 0;

    private static void increase() {
        race++;
    }

    public static void main(String[] args) {
        int threadCount = 20;

        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increase();
                    }
                }
            });

            threads[i].start();
        }

        // 等待所有线程都结束
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        System.out.println(race);
    }
}
