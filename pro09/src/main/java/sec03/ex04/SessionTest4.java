package sec03.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class SessionTest4 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter w = response.getWriter();
		HttpSession session = request.getSession();
		
		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		
		if(session.isNew()) {
			if(userId != null) {
				session.setAttribute("user_id", userId);
				w.println("<a href='login'>로그인 상태 확인</a>");
			}else {
				w.print("<a href='login2.html'>다시 로그인 하세요</a>");
				session.invalidate();
			}
		}else {
			userId = (String) session.getAttribute("user_id");
			if(userId != null && userId.length() != 0)
				w.print("안녕하세요 " + userId + "님!!");
			else {
				w.print("<a href='login2.html'>다시 로그인 하세요</a>");
				session.invalidate();
			}
		}
	}
}
