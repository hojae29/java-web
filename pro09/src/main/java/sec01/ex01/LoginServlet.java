package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		
		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		String userAddress = request.getParameter("user_address");
		String userEmail = request.getParameter("user_email");
		String userHp = request.getParameter("user_hp");
		
		String data = "안녕하세요!<br> 로그인하셨습니다.<br><br>";
		data += "<html><body>";
		data += "아이디 : " + userId;
		data += "<br>";
		data += "비밀번호 : " + userPw;
		data += "<br>";
		data += "주소 : " + userAddress;
		data += "<br>";
		data += "email : " + userEmail;
		data += "<br>";
		data += "휴대 전화 : " + userHp;
		data += "</html></body>";
		
		PrintWriter out = response.getWriter();
		out.print(data);
	}
}
