package ua.nure.film.dao;

import ua.nure.dbtable.DBTable;
import ua.nure.dbtable.DBTableFactory;
import ua.nure.dbtable.Filter;
import ua.nure.film.entity.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

public class FilmDAOInMemoryImpl implements FilmDAO {
    DBTable<Film> films = DBTableFactory.instance();

    private static FilmDAOInMemoryImpl instance;


    private FilmDAOInMemoryImpl() {
        initFilms();
    }

    public static synchronized FilmDAOInMemoryImpl instance() {
        if (instance == null) {
            instance = new FilmDAOInMemoryImpl();
        }
        return instance;
    }

    private Film newFilm(String filmTitle, String duration, String showType, Collection<Ticket> tickets) {
        var film = new Film();
        film.setFilmTitle(filmTitle);
        film.setDuration(duration);
        film.setShowType(showType);
        film.getTicket().addAll(tickets);

        return film;
    }

    private Ticket newTicket(int id, String ticketNumber, String purchaseDate, String seatNumber, Viewer viewer) {
        Ticket ticket = new Ticket();
        ticket.setId(id);
        ticket.setTicketNumber(ticketNumber);
        ticket.setPurchaseDate(purchaseDate);
        ticket.setSeatNumber(seatNumber);
        ticket.setViewer(viewer);
        return ticket;
    }

    private Viewer newViewer(int id, String name, String surName) {
        var viewer = new Viewer();
        viewer.setName(name);
        viewer.setSurname(surName);
        viewer.setId(id);

        return viewer;
    }

    private void initFilms() {
        Film[] films = new Film[] {
                newFilm("SuperHero",
                        "02:00:00",
                        "3d",
                        Arrays.asList(newTicket(1, "dfg", "dfg", "dfg", newViewer(1, "sdf", "sdf")))
                        ),
                newFilm("sdfg",
                        "asdf",
                        "asdfasdf",
                        Arrays.asList(newTicket(1, "dfg", "dfg", "dfg", newViewer(1, "sdf", "sdf")))
                ),
                newFilm("sdfg",
                        "asdf",
                        "asdfasdf",
                        Arrays.asList(newTicket(1, "dfg", "dfg", "dfg", newViewer(1, "sdf", "sdf")))
                ),
                newFilm("sdfg",
                        "asdf",
                        "asdfasdf",
                        Arrays.asList(newTicket(1, "dfg", "dfg", "dfg", newViewer(1, "sdf", "sdf")))
                ),
        };
        for (int i = 0; i < films.length; i++) {
            addFilm(films[i]);
        }
    }

    @Override
    public Collection<Film> listFilms() { return this.films.selectAll(); }

    @Override
    public void addTicket(int filmId, Ticket ticket) {
        Film film = null;
        try {
            film = this.films.get(filmId);
            film.getTicket().add(ticket);
            this.films.update(filmId, film);
        } catch (SQLException e) {
            //
        }
    }

    @Override
    public int addFilm(Film film)  {
        int id = this.films.insert(film);
        film.setId(id);
        try {
            this.films.update(id, film);
        } catch (SQLException e) {

        }
        return id;
    }

    @Override
    public Ticket getTicket(String ticketNumber) {
        for (var film : this.films.selectAll()) {
            for(var ticket : film.getTicket()) {
                if(ticket.getTicketNumber().equals(ticketNumber)) {
                    return ticket;
                }
            }
        }

        return null;
    }

    Filter<Film> filmById = new Filter<>() {
        @Override
        public boolean accept(Film item, Object pattern) {
            int p = (int) pattern;
            if(item.getId() == p) {
                return true;
            }

            return false;
        }
    };
    @Override
    public void removeFilm(int filmId) {
        for (Film film : this.films.selectAll()) {
            if (film.getId() == filmId) {
                try {
                    this.films.delete(filmId);
                } catch (SQLException e) {
                    //
                }
                return;
            }
        }
    }
}
