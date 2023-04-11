package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/get")
public class GetAttribute extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8;");
		
		PrintWriter w = response.getWriter();
		
		ServletContext ctx = this.getServletContext();
		HttpSession session = request.getSession();
		
		w.print("context값 : " + ctx.getAttribute("context") + "<br>");
		w.print("session값 : " + session.getAttribute("session") + "<br>");
		w.print("request값 : " + request.getAttribute("request") + "<br>");
		
	}
}
