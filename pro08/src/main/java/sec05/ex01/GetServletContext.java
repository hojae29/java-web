package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cget")
public class GetServletContext extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter w = response.getWriter();
		
		ServletContext context = getServletContext();
		List member = (List) context.getAttribute("member");
		String name = (String) member.get(0);
		int age = (int) member.get(1);
		
		w.print("<html><body>");
		w.print(name + "<br>");
		w.print(age + "<br>");
		w.print("</body></html>");
	}

}
