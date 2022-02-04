package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.MRApplication;
import dbadapter.MovieData;

/**
 * Class responsible for the GUI of the registered users
 * 
 * @author swe.uni-due.de
 *
 */
public class RUGUI extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * doGet is responsible for add movie form, show movies and rate movie form
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		// Set navtype
		request.setAttribute("navtype", "User");

		String action = (request.getParameter("action") == null) ? "" : request.getParameter("action");

		// Case: Request add movie form
		if (action.equals("addMovie")) {
			// Set request attributes
			request.setAttribute("pagetitle", "Add Movie");

			try {
				request.getRequestDispatcher("/templates/showAddMovieForm.ftl").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		// Case:  show movies list 
		} else if(action.equals("showMovie")) {


			try {
				List<MovieData> movielist = null;
				try {
					movielist = MRApplication.getInstance().showMovieList();

					
					// Dispatch results to template engine
					request.setAttribute("pagetitle", "Show Movies");
					request.setAttribute("movielist", movielist);
					request.getRequestDispatcher("/templates/MovieList.ftl").forward(request, response);
				} catch (Exception e1) {
					try {
						request.setAttribute("errormessage", "Database error: please contact the administator");
						request.getRequestDispatcher("/templates/error.ftl").forward(request, response);
					} catch (Exception e) {
						request.setAttribute("errormessage", "System error: please contact the administrator");
						e.printStackTrace();
					}
					e1.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// Case:  rate movie form
		else if(action.equals("rateMovie"))
				{
			request.setAttribute("pagetitle", "Rate Movie");

			try {
				request.getRequestDispatcher("/templates/showRateMovieForm.ftl").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
				}
		
	}

	/**
	 * doPost manages handling of submitted forms.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		

		// Check wether the call is add movie
		if (request.getParameter("action").equals("addMovie")) {

			// Append parameter of request
			String title =  request.getParameter("title");
			String director =  request.getParameter("director");
			String mainactor =  request.getParameter("mainactor");
			int publishdate=Integer.parseInt(request.getParameter("publishdate"));

			// Call application to add movie
			boolean result = MRApplication.getInstance().addMovie(title, director, mainactor, publishdate);
			
			if(result)
			{
			try {
				request.setAttribute("pagetitle", "welcome page");
				request.setAttribute("navtype", "User");
				request.getRequestDispatcher("/templates/index.ftl").forward(request, response);

			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
			}
			// Check wether the call is rate movie
		} else if(request.getParameter("action").equals("rateMovie"))
		{
			String title =  request.getParameter("title");
			String comment =  request.getParameter("comment");
			int score=Integer.parseInt(request.getParameter("score"));
			
			boolean result = MRApplication.getInstance().rateMovie(title,"1", comment, score);
			
			if(result)
				try {
					request.setAttribute("pagetitle", "welcome page");
					request.setAttribute("navtype", "User");
					request.getRequestDispatcher("/templates/index.ftl").forward(request, response);

				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
		}
		// Call doGet if request otherwise
		else doGet(request, response);
	}
}