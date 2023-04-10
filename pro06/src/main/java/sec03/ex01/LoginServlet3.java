package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet3 extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		System.out.println("init 메서드 호출");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		
		System.out.println("아이디 : " + userId);
		System.out.println("비밀번호 : " + userPw);
	}

	@Override
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}
}
