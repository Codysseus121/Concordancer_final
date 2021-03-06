package dp.servlets.concordancer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.MultipartConfig;

import java.io.IOException;


/**
 * Servlet implementation class FrontController
 * Takes incoming requests and dispatches them accordingly.
 * 
 */
@WebServlet(name = "/FrontControllerServlet", urlPatterns = "/concordancer")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)//Accept files up to 10MB.

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processrequest(request, response);
	}

	protected void processrequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		RequestDispatcher dispatcher = null;
		String base = "/jsp/";
		String url = base+ "/home.jsp";
		

		if (action != null) {
			System.out.println(action);
			switch (action) {

			case "login":

				url = "/LoginServlet";
				break;
				
			case "register":
				url = "/RegisterServlet";
				break;
				
			case "projectdelete":
				url = "/ProjectDeleteServlet";
				break;
				
			case "useproject":
				url = "/UseProjectServlet";
				break;
				
			case "allprojects":
				url = "/ProjectsServlet";
				break;
				
			case "newproject":
				url = "/UploadServlet";
				break;
				
			case "kwic":
				url = "/KWICServlet";
				break;
				
			case "context":
				url = "/ContextServlet";
				break;
				
			case "collocate":
				url = "/CollocateServlet";
				break;	
				
			case "paginate":
				url = "/PaginateServlet";
				break;	
				
				
			case "logout":
				 HttpSession session=request.getSession(true);  
				 session.invalidate();

			}

		}
		dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
		return;

	}
}
