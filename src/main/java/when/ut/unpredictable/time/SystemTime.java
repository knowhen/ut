package when.ut.unpredictable.time;

import java.util.Date;

/**
 * @author: when
 * @create: 2020-01-11  09:19
 **/
public class SystemTime {
    private static final TimeSource DEFAULT_TIME_SOURCE = () -> System.currentTimeMillis();
    private static TimeSource timeSource = null;

    public static long asMillis() {
        return getTimeSource().millis();
    }

    public static Date asDate() {
        return new Date(asMillis());
    }

    public static void reset() {
        setTimeSource(null);
    }

    private static TimeSource getTimeSource() {
        return timeSource == null ? DEFAULT_TIME_SOURCE : timeSource;
    }

    public static void setTimeSource(TimeSource timeSource) {
        SystemTime.timeSource = timeSource;
    }
}
