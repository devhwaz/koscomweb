package kr.co.koscom.web.exam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cookieName = request.getParameter("cookieName");
		String cookieValue = request.getParameter("cookieValue");
		HttpSession session = request.getSession();
		session.setAttribute(cookieName, cookieValue);
	}

}
