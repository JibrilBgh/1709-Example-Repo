package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.BankUser;
import com.revature.services.AppService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Login Servlet -Get");
		request.getRequestDispatcher("login.html").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("LoginServlet Post");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");		
		System.out.print(username + " " + password);
		
		BankUser clientUser = new BankUser(username, password);
		clientUser = new AppService().validateUser(clientUser);
		
		if(clientUser != null) {
			
			//Store the valid user into the session
			HttpSession session = request.getSession();
			session.setAttribute("user", clientUser);

			//validate user set to app.html
			request.getRequestDispatcher("app.html").forward(request, response);
		} else {
			doGet(request, response);
		}

	}

}
