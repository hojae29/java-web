package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginTest extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter w = response.getWriter();
		
		HttpSession session = request.getSession();
		
		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		
		LoginImpl loginUser = new LoginImpl(userId, userPw);
		
		if(session.isNew()) {
			session.setAttribute("loginUser", loginUser);
		}
		
		w.print("<head>");
		w.print("<script>setTimeout('history.go(0)', 5000)</script>");
		w.print("</head>");
		w.println("<html><body>");
		w.println("아이디는 " + loginUser.user_id + "<br>");
		w.println("총 접속자 수는 " + loginUser.total_user + "<br>");
		w.println("</body></html>");
	}

}
