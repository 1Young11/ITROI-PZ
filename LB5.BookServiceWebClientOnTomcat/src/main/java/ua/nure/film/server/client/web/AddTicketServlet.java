package ua.nure.film.server.client.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.film.entity.Film;
import ua.nure.film.entity.Ticket;
import ua.nure.film.entity.Viewer;
import ua.nure.film.service.FilmService;

import java.io.IOException;

public class AddTicketServlet extends HttpServlet {
    private static final String DEBUG_ERROR_MSG = "Set errorMsg to the session";
    private static final long serialVersionUID = 1L;
    private final transient Logger log = LoggerFactory.getLogger(AddFilmServlet.class);

    private transient FilmService service;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext ctx = getServletContext();
        service = (FilmService) ctx.getAttribute("FilmService");
        log.trace("Get attribute FilmService : {}",service);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String errMsg = null;
        try {
            int filmId = Integer.parseInt(request.getParameter("filmId"));
            String seatNumber = request.getParameter("seatNumber");
            String purchaseDate = request.getParameter("purchaseDate");
            String viewerName = request.getParameter("viewerName"); // Added for viewer's name
            String viewerSurname = request.getParameter("viewerSurname"); // Added for viewer's surname
            String ticketNumber = request.getParameter("ticketNumber"); // Added for viewer's surname

            // Create a Ticket object and set its properties
            Ticket ticket = new Ticket();
            ticket.setTicketNumber(ticketNumber);
            ticket.setSeatNumber(seatNumber);
            ticket.setPurchaseDate(purchaseDate);

            // Create a Viewer object and set its properties
            Viewer viewer = new Viewer();
            viewer.setName(viewerName);
            viewer.setSurname(viewerSurname);

            // Set the Viewer for the Ticket
            ticket.setViewer(viewer);

            log.debug("Get ticket from request : {}", ticket);

            // ----------------------------
            // TO DO: Validate ticket and viewer
            // ----------------------------

            // Send the request to the web-service to add the ticket
            service.addTicket(filmId, ticket);
            log.debug("Ticket added for film with ID: {}", filmId);
            Film film1;
            var films = service.listFilms();
            for (var film : films) {
                if (film.getId() == filmId) {
                    film1 = film;
                    session.setAttribute("film", film1);
                    break;
                }
            }
            // Redirect to viewfilm.jsp after adding the ticket
            response.sendRedirect("viewfilm.jsp");
            log.debug("Redirect to viewfilm.jsp");
            return; // Exit the method
        } catch (NumberFormatException e) {
            errMsg = "Error: Invalid input for Film ID";
            log.debug(DEBUG_ERROR_MSG, e);
        } catch (Exception e) {
            // Any other exceptions
            errMsg = "Error: Cannot communicate with the film service";
            log.debug(DEBUG_ERROR_MSG, e);
        }

        // If an error occurred, set the error message and redirect back to addTicket.jsp
        session.setAttribute("errorMsg", errMsg);
        response.sendRedirect("addTicket.jsp");
        log.debug("Redirect to addTicket.jsp");
    }
}
