package com.pankz;

import jakarta.servlet.RequestDispatcher;
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
			request.setAttribute("user", user);
		//	response.sendRedirect("success.jsp");
		//	Now,instead of passing the instruction to browser inorder to access diff URL,we need to redirect on the server side itself
			//Browser doesn't know that redirection is actually happening to another URL or another servlet/JSP
			RequestDispatcher dispatcher=request.getRequestDispatcher("success.jsp");
			dispatcher.forward(request, response);
			return;
		}
		else
		{
			response.sendRedirect("login.jsp");
			return;
		}
		
	}

}
//Their is a way in which we can take the flow of control from one servlet or jsp to another servlet or jsp