package dp.servlets.concordancer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dp.concordancer.ConcFacade.ConcFacadeImpl;
import dp.concordancer.ConcFacade.ConcordancerFacade;

import dp.model.concordancer.*;

/**
 * Servlet implementation class KWICServlet to handle requests for kwic lines.
 */
@WebServlet("/KWICServlet")
public class KWICServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KWICServlet() {
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

		doGet(request, response);
	}

	public void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			HttpSession session = request.getSession(true);
			
			String word = request.getParameter("keyword");
			//word = word.trim();
			//System.out.println(word);

			if (word.length() == 0) // check validity

			{
				
				response.getWriter().write("False");

			}

			else {

				UserInterface user = (UserInterface) session.getAttribute("currentSessionUser");
				ProjectInterface project = (ProjectInterface) session.getAttribute("currentproject");
				ConcordancerFacade service = new ConcFacadeImpl();
			
				List<KWICInterface> conc = service.getConcordances(user, project, word);
				

				if (conc.isEmpty()) {
				response.getWriter().write("False");
				}

				else {
					System.out.println("fetched");
					session.setAttribute("concordances", conc);
					response.getWriter().write("True");
					
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
