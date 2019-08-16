package servlet;

import bean.Hero;
import dao.HeroDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HeroListServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = (String) request.getSession().getAttribute("userName");
        if (null == userName) {
            response.sendRedirect("login.html");
            return;
        }
        response.setContentType("text/html; charset=UTF-8");
        int start = 0;
        int count = 5;
        try {
            start = Integer.parseInt(request.getParameter("start"));
        } catch (NumberFormatException e) {

        }
        int next = start + count;
        int pre = start - count;
        List<Hero> heros = new HeroDAO().list(start, count);
        request.setAttribute("next", next);
        request.setAttribute("pre", pre);
        request.setAttribute("heros", heros);
        request.getRequestDispatcher("listHero.jsp").forward(request, response);
        /*StringBuffer sb = new StringBuffer();
        sb.append("<table align='center' border='1' cellspacing='0'>\r\n");
        sb.append("<tr><td>id</td><td>name</td><td>hp</td><td>damage</td></tr>\r\n");

        String trFormat = "<tr><td>%d</td><td>%s</td><td>%f</td><td>%d</td><td><a href='editHero?id=%d'>edit</a></td><td><a href='deleteHero?id=%d'>delete</a></td></tr>\r\n";

        for (Hero hero : heros) {
            String tr = String.format(trFormat, hero.getId(), hero.getName(), hero.getHp(), hero.getDamage(),hero.getId(),hero.getId());
            sb.append(tr);
        }

        sb.append("</table>");

        response.getWriter().write(sb.toString());*/

    }
}