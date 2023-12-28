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
 * Servlet implementation class RemoveFilm
 */
public class RemoveFilmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final transient Logger log = LoggerFactory.getLogger(RemoveFilmServlet.class);

    private FilmService service;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext ctx = getServletContext();
        service = (FilmService) ctx.getAttribute("FilmService");
        log.trace("Get attribute FilmService : {}", service);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int filmId = Integer.parseInt(request.getParameter("filmId"));
        log.debug("Received filmId to remove: {}", filmId);

        try {
            service.removeFilm(filmId);
            log.info("Film with ID {} removed successfully", filmId);

            var films = service.listFilms();
            request.getSession().setAttribute("films", films);
            // Redirect to a success page or list of films
            response.sendRedirect("list.jsp"); // Example redirect
        } catch (Exception e) {
            log.error("Error removing film: {}", e.getMessage());
            // Handle the error gracefully, e.g., display an error message
            request.setAttribute("error", "Failed to remove film");
            request.getRequestDispatcher("error.jsp").forward(request, response); // Example error handling
        }
    }
}