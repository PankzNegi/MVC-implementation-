package com.pankz;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.pankz.dto.User;
import com.pankz.service.LoginService;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId,password;
		userId=request.getParameter("userId");
		password=request.getParameter("password");
		LoginService loginService=new LoginService();
		boolean result=loginService.authenticate(userId, password);
		//Redirection
		if(result==true)
		{
			User user=loginService.getUserDetails(userId);
			request.getSession().setAttribute("user", user);
			response.sendRedirect("success.jsp");
			return;
		}
		else
		{
			response.sendRedirect("login.jsp");
			return;
		}
		
	}

}
