package when.ut.servlet;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class EchoServletTest {
    private EchoServlet echoServlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @Before
    public void setUp() {
        echoServlet = new EchoServlet();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Test
    public void testEchoingParameters() throws ServletException, IOException {
        request.addParameter("one", "壹");
        request.addParameter("two", "贰");
        request.addParameter("three", "叁");
        request.addParameter("four", "肆");

        echoServlet.doGet(request, response);
        String[] lines = response.getContentAsString().split("\n");

        assertEquals("Expected as many lines as we have parameter values", 4, lines.length);
        assertEquals("one=壹", lines[0]);
        assertEquals("two=贰", lines[1]);
        assertEquals("three=叁", lines[2]);
        assertEquals("four=肆", lines[3]);
    }
}