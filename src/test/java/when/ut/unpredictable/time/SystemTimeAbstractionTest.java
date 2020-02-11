package when.ut.unpredictable.time;

import org.junit.After;
import org.junit.Test;
import when.ut.unpredictable.time.SystemTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Abstract system time.
 * long time = SystemTime.asMillis();
 * Calendar calendar = SystemTime.asCalendar();
 * Date date = SystemTime.asDate();
 */
public class SystemTimeAbstractionTest {

    @After
    public void resetTimeSource() {
        SystemTime.reset();
    }

    @Test
    public void clockReturnsValidTimeMilliseconds() {
        long before = System.currentTimeMillis();
        long clock = SystemTime.asMillis();
        long after = System.currentTimeMillis();
        assertBetween(before, clock, after);
    }

    @Test
    public void clockReturnsFakeTimeMilliseconds() {
        final long fakeTime = 1234567890L;
        SystemTime.setTimeSource(() -> fakeTime);

        long clock = SystemTime.asMillis();
        assertEquals(fakeTime, clock);
    }

    private void assertBetween(long before, long clock, long after) {
        assertTrue(before <= clock && clock <= after);
    }
}