package ua.nure.film.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import ua.nure.film.dao.DAOException;
import ua.nure.film.entity.Film;
import ua.nure.film.entity.Ticket;

import java.util.Collection;

@WebService(targetNamespace= Const.SERVICE_NS)
    public interface FilmService {
    @WebMethod()
    @WebResult(targetNamespace="http://film.nure.ua/entity")
    public int addFilm(
            @WebParam(name="Film", targetNamespace="http://film.nure.ua/entity")
            Film film) throws DAOException;

    @WebMethod()
    public void addTicket(
            @WebParam(name = "filmId")
            int filmId,
            @WebParam(name="Ticket", targetNamespace="http://film.nure.ua/entity")
            Ticket ticket) throws DAOException;

    @WebMethod()
    @WebResult(name="listFilms", targetNamespace="http://film.nure.ua/entity")
    public Collection<Film> listFilms();

    @WebMethod()
    @WebResult(name = "Ticket", targetNamespace = "http://film.nure.ua/entity")
    public Ticket getTicket(
            @WebParam(name="ticketNumber")
            String ticketNumber);

    @WebMethod()
    public void removeFilm(
            @WebParam(name="filmId")
            int filmId) throws DAOException;
}