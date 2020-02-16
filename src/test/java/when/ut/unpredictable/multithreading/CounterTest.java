package when.ut.unpredictable.multithreading;

import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.CyclicBarrier;

import static org.junit.Assert.assertEquals;

public class CounterTest {
    @Test
    public void testBasicFunctionality() {
        Counter counter = new Counter();

        counter.increment();

        assertEquals(1, counter.value());

        counter.increment();

        assertEquals(2, counter.value());
    }

    @Ignore("Ensure the test will fail.")
    @Test
    public void testForThreadSafety() throws Exception {
        final Counter counter = new Counter();
        final int numsOfThread = 20;
        final int incrementsPerThread = 1000000;

        CyclicBarrier entryBarrier = new CyclicBarrier(numsOfThread + 1);
        CyclicBarrier exitBarrier = new CyclicBarrier(numsOfThread + 1);

        Runnable runnable = () -> {
            for (int i = 0; i < incrementsPerThread; i++) {
                counter.increment();
            }
        };

        for (int i = 0; i < numsOfThread; i++) {
            new SyncedThread(runnable, entryBarrier, exitBarrier).start();
        }

        assertEquals(0, counter.value());
        entryBarrier.await();
        exitBarrier.await();
        assertEquals(numsOfThread * incrementsPerThread, counter.value());
    }

}