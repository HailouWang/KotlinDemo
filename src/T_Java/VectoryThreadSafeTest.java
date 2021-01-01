package T_Java;

import java.util.Vector;
import java.util.concurrent.locks.ReentrantLock;

public class VectoryThreadSafeTest {

    private static Vector<Integer> vectors = new Vector<>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 30; i++) {
                vectors.add(i);
            }

            Thread removeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < vectors.size(); i++) {
                        vectors.remove(i);
                    }
                }
            });

            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < vectors.size(); i++) {
                        System.out.println(vectors.get(i));
                    }
                }
            });

            removeThread.start();
            printThread.start();

            while(Thread.activeCount() > 80);
        }

        new ReentrantLock().lock();
    }
}
