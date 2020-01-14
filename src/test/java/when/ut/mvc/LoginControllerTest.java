package when.ut.mvc;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import when.ut.servlet.auth.FakeAuthenticationService;

import static org.junit.Assert.assertEquals;

public class LoginControllerTest {
    private static final String USERNAME = "valid_user";
    private static final String PASSWORD = "correct_password";

    private LoginController controller;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @Before
    public void setUp() {
        FakeAuthenticationService fakeAuthenticator = new FakeAuthenticationService();
        fakeAuthenticator.addUser(USERNAME, PASSWORD);
        controller = new LoginController();
        controller.setAuthenticationService(fakeAuthenticator);

        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Test
    public void wrongPasswordShouldRedirectToErrorPage() throws Exception {
        request.addParameter("username", USERNAME);
        request.addParameter("password", "wrong_password");

        ModelAndView modelAndView = controller.handleRequest(request, response);

        assertEquals("wrongpassword", modelAndView.getViewName());
    }

    @Test
    public void validLoginForwardsToIndex() throws Exception {
        request.addParameter("username", USERNAME);
        request.addParameter("password", PASSWORD);

        ModelAndView modelAndView = controller.handleRequest(request, response);

        assertEquals("index", modelAndView.getViewName());
    }
}