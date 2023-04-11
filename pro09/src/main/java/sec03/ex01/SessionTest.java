package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sess")
public class SessionTest extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter w = response.getWriter();
		
		//Tomcat에서 지정한 세션 기본유효시간은 30분
		//최초 요청 시 세션 객체를 생성하거나 기존 세션 반환
		HttpSession session = request.getSession();
		w.println("세션 아이디 : " + session.getId() + "<br>");
		w.println("최초 세션 생성 시각 : " + new Date(session.getCreationTime()) + "<br>");
		w.println("최근 세션 접근 시각 : " + new Date(session.getLastAccessedTime()) + "<br>");
		w.println("세션 유효 시간 : " + session.getMaxInactiveInterval() + "<br>");
		if(session.isNew()) {
			w.print("새 세션이 만들어졌습니다.");
		}
	}
}
