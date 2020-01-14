package when.ut.servlet;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import when.ut.servlet.auth.AuthenticationService;
import when.ut.servlet.auth.FakeAuthenticationService;

import static org.junit.Assert.assertEquals;

public class LoginServletTest {
    private static final String USERNAME = "valid_user";
    private static final String PASSWORD = "correct_password";

    private LoginServlet loginServlet;
    private FakeAuthenticationService authenticator;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @Before
    public void setUp() {
        authenticator = new FakeAuthenticationService();
        authenticator.addUser(USERNAME, PASSWORD);

        loginServlet = new LoginServlet() {
            @Override
            protected AuthenticationService getAuthenticationService() {
                return authenticator;
            }
        };
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Test
    public void wrongPasswordShouldRedirectToErrorPage() throws Exception {
        request.addParameter("username", USERNAME);
        request.addParameter("password", "wrong_password");

        loginServlet.service(request, response);

        assertEquals("/invalid", response.getRedirectedUrl());
    }

    @Test
    public void validLoginForwardsToFrontPageAndStoresUsername() throws Exception {
        request.addParameter("username", "valid_user");
        request.addParameter("password", "correct_password");

        loginServlet.service(request, response);

        assertEquals("/index", response.getRedirectedUrl());
        assertEquals("valid_user", request.getSession().getAttribute("username"));
    }
}