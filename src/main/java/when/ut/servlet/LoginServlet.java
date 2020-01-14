package when.ut.servlet;

import when.ut.servlet.auth.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: when
 * @create: 2020-01-14  15:22
 **/
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (getAuthenticationService().auth(username, password)) {
            resp.sendRedirect("/index");
            req.getSession().setAttribute("username", username);
        } else {
            resp.sendRedirect("/invalid");
        }
    }

    protected AuthenticationService getAuthenticationService() {
        return null;
    }
}
