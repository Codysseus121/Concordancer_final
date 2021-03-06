package dp.servlets.concordancer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dp.model.concordancer.Project;
import dp.model.concordancer.UserInterface;
import dp.concordancer.ConcFacade.*;

/**
 * Servlet implementation class ProjectDeleteServlet:
 * handles requests for deletion of Project objects
 * from a User's record and the persistence layer.
 */
@WebServlet("/ProjectDeleteServlet")
public class ProjectDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProjectDeleteServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/*
	 * Method processRequest to process all incoming requests for project deletion.
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		response.setContentType("plain/text");
		
		String pid = request.getParameter("parameter_pid");// get the project's key parameter from the client

		try {

			if (pid.length() > 0) //check param for validity
			
			{ 

				int project_id = Integer.parseInt(pid);// convert it into int.
				UserInterface user = (UserInterface) session.getAttribute("currentSessionUser");// get the session user.
				ConcordancerFacade facade = new ConcFacadeImpl();
				facade.deleteProject(user, project_id);// delete project from the database

				// refresh list of projects after deletion

				
				List<Project> projects = facade.getProjects(user);
				session.setAttribute("projects", projects);
				
				response.getWriter().write("True");
			} else {
				
				response.getWriter().write("False");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
