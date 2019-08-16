package servlet;

import bean.Hero;
import dao.HeroDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HeroEditServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Hero hero = new HeroDAO().get(id);
        req.setAttribute("hero", hero);
        req.getRequestDispatcher("editHero.jsp").forward(req, resp);
       /* StringBuffer format = new StringBuffer();
        resp.setContentType("text/html; charset=UTF-8");

        format.append("<!DOCTYPE html>");

        format.append("<form action='updateHero' method='post'>");
        format.append("名字 ： <input type='text' name='name' value='%s' > <br>");
        format.append("血量 ： <input type='text' name='hp'  value='%f' > <br>");
        format.append("伤害： <input type='text' name='damage'  value='%d' > <br>");
        format.append("<input type='hidden' name='id' value='%d'>");
        format.append("<input type='submit' value='更新'>");
        format.append("</form>");

        String html = String.format(format.toString(), hero.getName(), hero.getHp(), hero.getDamage(), hero.getId());

        resp.getWriter().write(html);*/
    }
}
