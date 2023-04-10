package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/second")
public class SecondServlet extends HttpServlet { 

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter w = response.getWriter();
		String address = (String) request.getAttribute("address");
		
		w.println("<html><body>");
		w.println("주소 : " + address);
		w.println("<br>");
		w.println("redirect를 이용한 바인딩 실습");
		w.println("</body></html>");
	}
}
