package sec05.ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cfile")
public class ContextFileServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter w = response.getWriter();
		
		ServletContext ctx = this.getServletContext();
		InputStream inputStream = ctx.getResourceAsStream("/WEB-INF/bin/init.txt");
		BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));
		
		String menu = null;
		String menuMember = null;
		String menuOrder = null;
		String menuGoods = null;
		
		while((menu = buffer.readLine()) != null) {
			StringTokenizer tokens = new StringTokenizer(menu, ",");
			menuMember = tokens.nextToken();
			menuOrder = tokens.nextToken();
			menuGoods = tokens.nextToken();
		}
		
		w.print("<html><body>");
		w.print(menuMember + "<br>");
		w.print(menuOrder + "<br>");
		w.print(menuGoods + "<br>");
		w.print("</body></html>");
		w.close();
		
	}
}
