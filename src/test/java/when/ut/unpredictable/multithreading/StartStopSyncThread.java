package when.ut.unpredictable.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * @author: when
 * @create: 2020-02-11  19:31
 **/
public class StartStopSyncThread extends Thread {
    private CountDownLatch threadStarted;
    private CountDownLatch threadStopped;

    public StartStopSyncThread(Runnable task) {
        super(task);
        threadStarted = new CountDownLatch(1);
        threadStopped = new CountDownLatch(1);
    }

    @Override
    public void run() {
        threadStarted.countDown();
        super.run();
        threadStopped.countDown();
    }

    public void waitForStarted(long timeout, TimeUnit unit) throws InterruptedException {
        assertTrue("Thread not started within timeout.", threadStarted.await(timeout, unit));
    }

    public void waitForStopped(long timeout, TimeUnit unit) throws InterruptedException {
        assertTrue("Thread not stopped within timeout.", threadStopped.await(timeout, unit));
    }
}
