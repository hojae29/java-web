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

@WebServlet("/login")
public class LoginTest extends HttpServlet{
	
	ServletContext context = null;
	List user_list = new ArrayList();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter w = response.getWriter();
		
		context = getServletContext();
		HttpSession session = request.getSession();
		
		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		
		LoginImpl loginUser = new LoginImpl(userId, userPw);
		
		if(session.isNew()) {
			session.setAttribute("loginUser", loginUser);
			user_list.add(userId);
			context.setAttribute("user_list", user_list);
		}
		
		w.print("<head>");
		w.print("<script>setTimeout('history.go(0)', 5000)</script>");
		w.print("</head>");
		w.println("<html><body>");
		w.println("아이디는 " + loginUser.user_id + "<br>");
		w.println("총 접속자 수는 " + LoginImpl.total_user + "<br>");
		w.println("접속 아이디 : <br>");
		
//		List list = (ArrayList) context.getAttribute("user_list");
		for(int i=0; i<user_list.size(); i++) {
			w.println(user_list.get(i) + "<br>");
		}
		
		w.println("<a href='logout?user_id=" + userId + "'>로그아웃</a>");
		w.println("</body></html>");
	}

}
