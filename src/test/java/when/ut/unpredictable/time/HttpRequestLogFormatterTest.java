package when.ut.unpredictable.time;

import org.junit.After;
import org.junit.Test;
import when.ut.unpredictable.time.HttpRequestLogFormatter;
import when.ut.unpredictable.time.SystemTime;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author: when
 * @create: 2020-01-11  09:55
 **/
public class HttpRequestLogFormatterTest {

    @After
    public void tearDown() {
        SystemTime.reset();
    }

    @Test
    public void testCommonLogFormat() {
        final long time = SystemTime.asMillis();
        SystemTime.setTimeSource(() -> time);

        DateFormat dateFormat = HttpRequestLogFormatter.dateFormat;
        String timestamp = dateFormat.format(SystemTime.asDate());
        String expected = "1.2.3.4 - bob [" + timestamp + "] \\GET /ctx/resource HTTP/1.1\\ 200 2326";
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getRemoteAddr()).thenReturn("1.2.3.4");
        when(request.getRemoteUser()).thenReturn("bob");
        when(request.getMethod()).thenReturn("GET");
        when(request.getRequestURI()).thenReturn("/ctx/resource");
        when(request.getProtocol()).thenReturn("HTTP/1.1");
        HttpRequestLogFormatter formatter = new HttpRequestLogFormatter();

        String formattedLog = formatter.format(request, 200, 2326);

        assertEquals(expected, formattedLog);
    }

    @Test
    public void testTimestampFormat() {
        String date = "\\d{4}-\\d{2}-\\d{2}";
        String time = "\\d{2}:\\d{2}:\\d{2}";
//        String timezone = "(-|\\+)\\d{4}";
        String regex = date + " " + time;
//        + " " + timezone;

        DateFormat dateFormat = HttpRequestLogFormatter.dateFormat;
        String timestamp = dateFormat.format(new Date());

        assertTrue("DateFormat should be \"yyyy-MM-dd HH:mm:ss\"", timestamp.matches(regex));
    }
}
