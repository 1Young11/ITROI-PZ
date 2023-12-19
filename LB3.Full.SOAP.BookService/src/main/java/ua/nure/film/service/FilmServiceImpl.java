package ua.nure.film.service;

import jakarta.jws.WebService;
import ua.nure.film.entity.Film;
import ua.nure.film.dao.DAOException;
import ua.nure.film.dao.FilmDAO;
import ua.nure.film.dao.FilmDAOInMemoryImpl;
import ua.nure.film.entity.Film;
import ua.nure.film.entity.Ticket;

import java.sql.SQLException;
import java.util.Collection;

@WebService(serviceName="Film",
        portName="FilmPort",
        endpointInterface="ua.nure.film.service.FilmService",
        targetNamespace="http://film.nure.ua/service")
public class FilmServiceImpl implements FilmService {

    private static FilmDAO filmDAO = FilmDAOInMemoryImpl.instance();

    @Override
    public int addFilm(Film film) {
        return filmDAO.addFilm(film);
    }

    @Override
    public void addTicket(int filmId, Ticket ticket) {
        filmDAO.addTicket(filmId, ticket);
    }

    @Override
    public Collection<Film> listFilms() {
        return filmDAO.listFilms();
    }

    @Override
    public Ticket getTicket(String ticketNumber) {
        return filmDAO.getTicket(ticketNumber);
    }

    @Override
    public void removeFilm(int filmId) {
        filmDAO.removeFilm(filmId);
    }

}
