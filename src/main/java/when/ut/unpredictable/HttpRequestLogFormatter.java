package when.ut.unpredictable;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author: when
 * @create: 2020-01-11  10:02
 **/
public class HttpRequestLogFormatter {
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");

    public String format(HttpServletRequest request, int httpStatusCode, int contentLength) {
        StringBuilder line = new StringBuilder();
        line.append(request.getRemoteAddr());
        line.append(" - ");
        line.append(request.getRemoteUser());
        line.append(" [");

        line.append(dateFormat.format(SystemTime.asDate()));

        line.append("] \\").append(request.getMethod());
        line.append(" ").append(request.getRequestURI());
        line.append(" ").append(request.getProtocol());
        line.append("\\ ").append(httpStatusCode);
        line.append(" ").append(contentLength);

        return line.toString();
    }
}
