import bean.Hero;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetOneServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Hero hero = new Hero();
        hero.setName("盖伦");
        hero.setHp(353);
        JSONObject json = new JSONObject();
        json.put("hero", JSONObject.fromObject(hero));
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().print(json);
    }
}
