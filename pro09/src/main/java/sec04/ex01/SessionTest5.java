package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/login")
public class SessionTest5 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter w = response.getWriter();
		
		HttpSession session = request.getSession();
		
		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		
		if(session.isNew()) {
			if(userId != null) {
				session.setAttribute("user_id",  userId);
				String url = response.encodeURL("login");
				w.println("<a href='" + url + "'>로그인 상태 확인 </a>");
			}else {
				w.print("<a href='login2.html'>다시 로그인하세요!!</a>");
				session.invalidate();
			}
		}else {
			userId = (String) session.getAttribute("user_id");
			if(userId != null && userId.length() != 0) {
				w.print("안녕하세요 " + userId + "님");
			}else {
				w.print("<a href='login2.html'>다시 로그인하세요!!</a>");
				session.invalidate();
			}
		}
	}
}
