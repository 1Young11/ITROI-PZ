package film.service;

import film.dao.FilmDAO;
import film.dao.FilmDAOInMemoryImpl;
import film.entity.Film;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.util.Collection;

public class FilmSearcher {
    private FilmDAO store = FilmDAOInMemoryImpl.instance();
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void search(@QueryParam("pattern") String pattern) {
        System.out.println("search for Films: " + pattern);
    }
}
