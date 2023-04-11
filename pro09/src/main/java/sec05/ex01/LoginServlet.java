package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

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
		
		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		
		MemberVO member = new MemberVO();
		member.setId(userId);
		member.setPwd(userPw);
		
		MemberDao dao = new MemberDao();
		boolean result = dao.isExisted(member);
		
		if(result) {
			HttpSession session = request.getSession();
			session.setAttribute("isLogon",  true);
			session.setAttribute("login.id", userId);
			session.setAttribute("login.pw", userPw);
			
			w.print("<html><body>");
			w.print("안녕하세요 " + userId + "님!!!<br>");
			w.print("<a href='show'>회원정보 보기</a>");
			w.print("</body></html>");
		} else {
			w.print("<html><body><center>회원 아이디가 틀립니다.");
			w.print("<a href='login3.html'>다시 로그인하기</a>");
			w.print("</body></html>");
		}
	}
}
