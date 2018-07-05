package kr.co.koscom.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.koscom.dao.MemberDAO;
import kr.co.koscom.dao.MemberDAOImpl;
import kr.co.koscom.dto.MemberDTO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		MemberDAO dao = new MemberDAOImpl();
		MemberDTO member = dao.getMember(id);
		
		if(member != null & member.getId() != null) {
			if(member.getPassword().equals(password)) {
				//로그인에 성공한 경우
				//쿠키를 이용한 상태정보 유지
				Cookie cookie = new Cookie("loginOK", id);
				cookie.setPath("/");
				cookie.setMaxAge(-1);
				response.addCookie(cookie);
				
				response.sendRedirect("memberList");
			}else {
				response.sendRedirect("loginForm.html");			
			}
		}else {
			response.sendRedirect("memberInput.html");
		}
	}

}
