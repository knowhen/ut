package when.ut.unpredictable.multithreading;

import java.util.concurrent.ThreadFactory;

/**
 * @author: when
 * @create: 2020-02-11  19:39
 **/
public class Server extends Thread {
    private ThreadFactory threadFactory;

    public void setThreadFactory(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
    }

    @Override
    public synchronized void start() {
        threadFactory.newThread(null).start();
    }
}
