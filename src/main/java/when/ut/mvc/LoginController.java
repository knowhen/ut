package when.ut.mvc;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import when.ut.servlet.auth.AuthenticationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: when
 * @create: 2020-01-14  15:59
 **/
public class LoginController implements Controller {
    private AuthenticationService authenticator;

    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (authenticator.auth(username, password)) {
            return new ModelAndView("index");
        } else {
            return new ModelAndView("wrongpassword");
        }
    }

    public void setAuthenticationService(AuthenticationService authenticator) {
        this.authenticator = authenticator;
    }
}
