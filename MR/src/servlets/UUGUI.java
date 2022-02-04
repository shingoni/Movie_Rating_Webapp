package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.MRApplication;


/**
 * Contains GUI for Unregistered User
 * 
 * @author swe.uni-due.de
 *
 */
public class UUGUI extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * doGet contains the register form
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		
		// set pagetitle und navtype
		request.setAttribute("pagetitle", "register");
		request.setAttribute("navtype", "UUser");

		// Dispatch request to template engine
		try {
			request.getRequestDispatcher("/templates/defaultWebpageuu.ftl").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Contains handling of Register call
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		

		// Check wether the call is registerUser or not
		if (request.getParameter("action").equals("registerUser")) {

			// Append parameter of request
			String name =  request.getParameter("name");
			String email =  request.getParameter("email");
			int age=Integer.parseInt(request.getParameter("age"));

			// Call application to register user
			boolean result = MRApplication.getInstance().RegisterUser(name, email, age);
			
			if(result)
			{
			// Dispatch message to template engine
			try {
				
				response.setContentType("text/html");
				request.setAttribute("pagetitle", "Register");
				request.setAttribute("navtype", "User");
				request.getRequestDispatcher("/templates/index.ftl").forward(request, response);

			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
			}
			 //Call doGet if request is not equal to registerUser
		} else
			
			doGet(request, response);

	}
}