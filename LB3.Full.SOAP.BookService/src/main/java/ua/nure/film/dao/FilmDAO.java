package ua.nure.film.dao;



import ua.nure.film.entity.*;

import java.sql.SQLException;
import java.util.Collection;

public interface FilmDAO {
    public Collection<Film> listFilms();
    public void addTicket(int filmId, Ticket ticket) ;
    public int addFilm(Film film) ;
    public Ticket getTicket(String ticketNumber);
    public void removeFilm(int filmId);
}