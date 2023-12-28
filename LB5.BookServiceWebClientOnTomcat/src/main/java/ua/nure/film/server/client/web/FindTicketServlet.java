package ua.nure.film.server.client.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.film.service.FilmService;

import java.io.IOException;

/**
 * Servlet implementation class FindArticleByTag
 */
public class FindTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final transient Logger log = LoggerFactory.getLogger(FindTicketServlet.class);

	private FilmService service;

	@Override
	public void init() throws ServletException {
		super.init();
		ServletContext ctx = getServletContext();
		service = (FilmService) ctx.getAttribute("FilmService");
		log.trace("Get attribute FilmService: {}", service);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pattern = request.getParameter("ticketId");
		log.debug("Get find pattern from request : {}",pattern);

		var ticket = service.getTicket(pattern);
		log.debug("Get ticket from FilmService : {}", ticket);
		request.setAttribute("ticket", ticket);
		log.trace("Set ticket to the session : {}",ticket);
		request.getRequestDispatcher("viewticket.jsp").forward(request, response);
		log.trace("Redirect to ticket.jsp");
	}
}
