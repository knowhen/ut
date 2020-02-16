package when.ut.unpredictable.multithreading;

import org.junit.Test;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author: when
 * @create: 2020-02-11  19:35
 **/
public class ServerStartsAndStopsThreadTest {
    private StartStopSyncThread thread;

    @Test
    public void testStartingAndStoppingServerThread() throws Exception {
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable task) {
                thread = new StartStopSyncThread(task);
                return thread;
            }
        };

        Server server = new Server();
        server.setThreadFactory(threadFactory);

        server.start();
        thread.waitForStarted(1, TimeUnit.SECONDS);

        server.stop();
        thread.waitForStopped(1, TimeUnit.SECONDS);
    }
}
