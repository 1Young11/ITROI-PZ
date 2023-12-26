package film.dao;



import film.entity.Film;
import film.entity.Ticket;

import java.sql.SQLException;
import java.util.Collection;

public interface FilmDAO {
    public Collection<Film> listFilms();
    public void addTicket(Ticket ticket) ;
    public int addFilm(Film film) ;
    public Ticket getTicket(String ticketNumber);
    public void removeFilm(int filmId);

}