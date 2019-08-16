import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if ("admin".equals(name) && "123".equals(password)) {
            request.getSession().setAttribute("userName", name);
            response.sendRedirect("/listHero");
        } else {
            response.sendRedirect("login.html");
        }
    }
}
