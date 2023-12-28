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

public class AddFilmServlet extends HttpServlet {
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
            Film film = new Film();
            film.setFilmTitle(request.getParameter("filmTitle"));
            film.setDuration(request.getParameter("durationFilm"));
            film.setShowType(request.getParameter("showTypeFilm"));

            int numTickets = Integer.parseInt(request.getParameter("numTickets"));

            for (int i = 1; i <= numTickets; i++) {
                Ticket ticket = new Ticket();
                ticket.setTicketNumber(request.getParameter("ticketNumber" + i)); // Assuming you have a "ticketNumber" field
                ticket.setSeatNumber(request.getParameter("seatNumber" + i)); // Assuming you have a "seatNumber" field
                ticket.setPurchaseDate(request.getParameter("purchaseDate" + i)); // Assuming you have a "purchaseDate" field

                Viewer viewer = new Viewer();
                viewer.setName(request.getParameter("viewerName" + i));
                viewer.setSurname(request.getParameter("viewerSurname" + i));

                ticket.setViewer(viewer);

                film.getTicket().add(ticket);
            }

            // Perform any necessary validation on the film object here.

            // Send the film object to your service to add it.
            int id = service.addFilm(film);

            // Set the film object into the session attribute.
            session.setAttribute("film", film);

            // Redirect to a success page or display a success message.
            response.sendRedirect("viewfilm.jsp");
        } catch (Exception e) {
            // Handle any exceptions, such as validation errors or communication errors.
            errMsg = "Error: " + e.getMessage();
            log.error("Error processing film data: " + e.getMessage(), e);
        }

        if (errMsg != null) {
            session.setAttribute("errorMsg", errMsg);
            response.sendRedirect("addfilm.jsp"); // Redirect back to the form with an error message.
        }
    }

}
