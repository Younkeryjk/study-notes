import bean.Hero;
import net.sf.json.JSONSerializer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetManyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Hero hero = new Hero();
            hero.setName("name"+i);
            hero.setHp(500+i);
            heroes.add(hero);
        }
        String result = JSONSerializer.toJSON(heroes).toString();
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().print(result);
    }
}
