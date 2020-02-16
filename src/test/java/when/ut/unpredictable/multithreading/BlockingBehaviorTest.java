package when.ut.unpredictable.multithreading;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author: when
 * @create: 2020-02-11  19:28
 **/
public class BlockingBehaviorTest {
    @Test
    public void testBlockingBehavior() throws Exception {
        final AtomicBoolean blocked = new AtomicBoolean(true);

        Thread buyer = new Thread(() -> {
            try {
                new BlackMarket().buyTicket();
                blocked.set(false);
            } catch (InterruptedException e) {
            }
        });

        buyer.start();
        Thread.sleep(1000);
        buyer.interrupt();
        buyer.join(1000);

        assertFalse("Thread didn't interrupted!", buyer.isAlive());
        assertTrue("Method didn't block!", blocked.get());
    }
}
