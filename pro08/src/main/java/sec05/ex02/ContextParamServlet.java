package sec05.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/initMenu")
public class ContextParamServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		response.setContentType("text/html;charset=utf-8");
		PrintWriter w = response.getWriter();
		ServletContext context = getServletContext();

		String menuMember = context.getInitParameter("menu_member");
		String menuOrder = context.getInitParameter("menu_order");
		String menuGoods = context.getInitParameter("menu_goods");

		w.print("<html><body>");
		w.print("<table border=1 cellspacing=0><tr>메뉴 이름</tr>");
		w.print("<tr><td>" + menuMember + "</td></tr>");
		w.print("<tr><td>" + menuOrder + "</td></tr>");
		w.print("<tr><td>" + menuGoods + "</td></tr>");
		w.print("</tr></table></body></html>");
	}

}
