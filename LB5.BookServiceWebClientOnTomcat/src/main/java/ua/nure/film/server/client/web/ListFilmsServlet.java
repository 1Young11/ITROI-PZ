package ua.nure.film.server.client.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.film.entity.Film;
import ua.nure.film.service.FilmService;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ListArticles
 */
public class ListFilmsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final transient Logger log = LoggerFactory.getLogger(ListFilmsServlet.class);

	private FilmService service;

	@Override
	public void init() throws ServletException {
		super.init();
		ServletContext ctx = getServletContext();
		service = (FilmService) ctx.getAttribute("FilmService");
		log.trace("Get attribute FilmService : {}",service);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Film> films = service.listFilms();
		log.debug("Get film from FilmService : {}", films);
		request.setAttribute("films", films);
		log.trace("Set films to the session : {}", films);
		request.getRequestDispatcher("list.jsp").forward(request, response);
		log.trace("Redirect to list.jsp");
	}

}
