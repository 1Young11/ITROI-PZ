package film.service;

import com.sun.research.ws.wadl.Application;
import film.additions.ReturnsAtomic;
import film.dao.DAOException;
import film.dao.FilmDAO;
import film.dao.FilmDAOInMemoryImpl;
import film.entity.Film;
import film.entity.Ticket;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Path(Constants.FILMS_SERVICE_PATH)
public class FilmServiceRestImpl extends Application {

    private static final long LONG_WORK_WAIT_TIMEOUT = 1000;

    private static final int DEFAULT_THREAD_POOL_SIZE = 10;

    private FilmDAO store;

    ExecutorService executor = Executors.newFixedThreadPool(DEFAULT_THREAD_POOL_SIZE);

    private void log(String msg) {
        System.out.println(this.getClass().getSimpleName() + ": " + msg);
    }

    @PostConstruct
    public void init() {
        log("init");
        store = FilmDAOInMemoryImpl.instance();
    }

    @PreDestroy
    public void destroy() {
        log("destroy");
        store = null;
        executor.shutdown();
    }

    @Path("listFilms")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response listFilms() {
        log("all");
        var films = this.store.listFilms();
        System.out.println("getting all");
        return Response.ok(films).build();
    }

    @Path("addFilm")
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ReturnsAtomic<Integer> addArticle(Film film) throws DAOException {
        log("add film");
        var id = store.addFilm(film);
        return new ReturnsAtomic<Integer>(id);
    }

    @Path("addTicket")
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addTicket(Ticket ticket) throws DAOException {
        log("add ticket");
        store.addTicket(ticket);
    }

    @Path("getTicket")
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Ticket getTicket(String ticketNumber) throws DAOException {
        log("get ticket");
        return store.getTicket(ticketNumber);
    }

    @Path("removeFilm")
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void removeFilm(int filmId) throws DAOException {
        log("delete ticket");
        store.removeFilm(filmId);
    }
}
