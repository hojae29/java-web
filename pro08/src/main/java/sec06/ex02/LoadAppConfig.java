package sec06.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "loadConfig", urlPatterns = "/loadConfig", loadOnStartup = 1)
public class LoadAppConfig extends HttpServlet {
	
	private ServletContext context;
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LoadAppConfig의 init 메서드 호출");
		context = config.getServletContext();
		
		String menuMember = context.getInitParameter("menu_member");
		String menuOrder = context.getInitParameter("menu_order");
		String menuGoods = context.getInitParameter("menu_goods");
		
		context.setAttribute("menu_member", menuMember);
		context.setAttribute("menu_order", menuOrder);
		context.setAttribute("menu_goods", menuGoods);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter w = response.getWriter();
		
		String menuMember = (String) context.getAttribute("menu_member");
		String menuOrder = (String) context.getAttribute("menu_order");
		String menuGoods = (String) context.getAttribute("menu_goods");
		
		w.print("<html><body>");
		w.print("<table border=1 cellspacing=0><tr>메뉴 이름</tr>");
		w.print("<tr><td>" + menuMember + "</td></tr>");
		w.print("<tr><td>" + menuOrder + "</td></tr>");
		w.print("<tr><td>" + menuGoods + "</td></tr>");
		w.print("</table></body></html>");
	}

}
