import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class HelloServlet extends HttpServlet {
 
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html; charset=UTF-8");
//          response.setCharacterEncoding("UTF-8");
 
            PrintWriter pw = response.getWriter();
            pw.println("<h1>第一次 使用33 Servlet</h1>");
 
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 
}