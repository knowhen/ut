package when.ut.unpredictable.multithreading;

import java.util.concurrent.CyclicBarrier;

/**
 * @author: when
 * @create: 2020-02-11  18:49
 **/
public class SyncedThread extends Thread {
    private CyclicBarrier entryBarrier;
    private CyclicBarrier exitBarrier;

    public SyncedThread(Runnable target, CyclicBarrier entryBarrier, CyclicBarrier exitBarrier) {
        super(target);
        this.entryBarrier = entryBarrier;
        this.exitBarrier = exitBarrier;
    }

    @Override
    public void run() {
        try {
            entryBarrier.await();
            super.run();
            exitBarrier.await();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
