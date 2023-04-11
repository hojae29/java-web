package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		
		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		String userAddress = request.getParameter("user_address");
		
		PrintWriter w = response.getWriter();
		w.println("<html><body>");
		
		if(userId != null && userId.length() != 0) {
			w.println("이미 로그인 상태입니다!<br><br>");
			w.println("첫 번째 서블릿에서 넘겨준 아이디 : " + userId + "<br>");
			w.println("첫 번째 서블릿에서 넘겨준 비밀번호 : " + userPw + "<br>");
			w.println("첫 번째 서블릿에서 넘겨준 주소 : " + userAddress + "<br>");
			w.println("</body></html>");
		}else {
			w.println("로그인 하지 않았습니다!<br><br>");
			w.println("다시 로그인 하세요! <br>");
			w.println("<a href='/pro09/login.html'>로그인창으로 이동하기</a>");
		}
	}
}
