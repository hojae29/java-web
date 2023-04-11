package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutTest extends HttpServlet{
	
	ServletContext context = null;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		context = getServletContext();
		
		PrintWriter w = response.getWriter();
		HttpSession session = request.getSession();
		
		String userId = request.getParameter("user_id");
		session.invalidate();
		
		List user_list = (ArrayList) context.getAttribute("user_list");
		user_list.remove(userId);
		context.removeAttribute("user_list");
		context.setAttribute("user_list",  user_list);
		
		w.println("<br>로그아웃했습니다.");
	}
}
