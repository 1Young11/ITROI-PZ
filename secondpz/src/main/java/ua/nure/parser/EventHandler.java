package ua.nure.parser;

import org.example.xml.entity.cinema.Film;
import org.example.xml.entity.cinema.Ticket;
import org.example.xml.entity.cinema.Viewer;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.stream.events.*;
import java.util.ArrayList;
import java.util.List;

public class EventHandler {
    private static final boolean LOG_ENABLED = true;

    private String current;
    private Ticket ticket;
    private Film film;
    private Viewer viewer;
    private List<Film> films;

    private static void log(Object o) {
        if (LOG_ENABLED) {
            System.out.println(o);
        }
    }

    public void endElement(XMLEvent event) {
        EndElement endElement = event.asEndElement();
        String localName = endElement.getName().getLocalPart();
        if (Const.TAG_FILM.equals(localName)) {
            this.films.add(this.film);
            log("film add");
        } else if (Const.TAG_TICKET.equals(localName)) {
            this.film.getTicket().add(this.ticket);
            log("ticket add" + this.ticket.getTicketNumber());
        } else if (Const.TAG_VIEWER.equals(localName)) {
            this.ticket.setViewer(this.viewer);
            log("viewer add" + this.viewer.getName());
        }
    }

    public void characters(XMLEvent event) {
        Characters characters = event.asCharacters();
        String value = characters.getData();
        log("Characters: " + this.current);
        if (Const.TAG_FILMTITLE.equals(this.current)) {
            this.film.setFilmTitle(value);
            log("film-title add: " + this.film.getFilmTitle());
        } else if (Const.TAG_DURATION.equals(this.current)) {
            this.film.setDuration(value);
            log("film-duration add: " + this.film.getDuration());
        } else if (Const.TAG_SHOWTYPE.equals(this.current)) {
            this.film.setShowType(value);
            log("film-showtype add: " + this.film.getShowType());
        } else if (Const.TAG_TICKETNUMBER.equals(this.current)) {
            this.ticket.setTicketNumber(value);
            log("ticket-number add: " + this.ticket.getTicketNumber());
        } else if (Const.TAG_SEATNUMBER.equals(this.current)) {
            this.ticket.setSeatNumber(value);
            log("ticket-seatnumber add: " + this.ticket.getSeatNumber());
        } else if (Const.TAG_PURCHASEDATE.equals(this.current)) {
            this.ticket.setPurchaseDate(value);
            log("ticket-seatnumber add: " + this.ticket.getPurchaseDate());
        } else if (Const.TAG_NAME.equals(this.current)) {
            this.viewer.setName(value);
            log("viewer-name add: " + this.viewer.getName());
        } else if (Const.TAG_SURNAME.equals(this.current)) {
            this.viewer.setSurname(value);
            log("viewer-surname add: " + this.viewer.getSurname());
        }
    }

    public void startElement(XMLEvent event) {
        StartElement startElement = event.asStartElement();
        this.current = startElement.getName().getLocalPart();
        log("StartElement: " + startElement.getName());
        Attribute attr = startElement.getAttributeByName(new QName(Const.ATTRIBUTE_ID));

        if (Const.TAG_FILMS.equals(this.current)) {
            this.films = new ArrayList<>();
        } else if (Const.TAG_FILM.equals(this.current)) {
            this.film = new Film();
            if (attr != null) {
                this.film.setId(Integer.parseInt(attr.getValue()));
            }
        } else if (Const.TAG_TICKET.equals(this.current)) {
            this.ticket = new Ticket();
            if (attr != null) {
                this.ticket.setId(Integer.parseInt(attr.getValue()));
            }
        } else if (Const.TAG_VIEWER.equals(this.current)) {
            this.viewer = new Viewer();
            if (attr != null) {
                this.viewer.setId(Integer.parseInt(attr.getValue()));
            }
        }
    }

    public List<Film> getFilms() {
        return films;
    }
}
