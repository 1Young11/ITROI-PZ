package ua.nure.parser;

import org.example.xml.entity.cinema.Film;
import org.example.xml.entity.cinema.Ticket;
import org.example.xml.entity.cinema.Viewer;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ua.nure.film.entity.article.*;

import javax.xml.XMLConstants;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SAXParser extends DefaultHandler {
    private static final boolean LOG_ENABLED = false;

    public static void log(Object o) {
        if (LOG_ENABLED) {
            System.out.println(o);
        }
    }

    private String current;
    private List<Film> films;
    private Ticket ticket;
    private Viewer viewer;
    private Film film;

    public List<Film> getFilms() {
        return films;
    }

    @Override
    public void error(org.xml.sax.SAXParseException e) throws SAXException {
//		throw e; // throw exception if xml not valid
        System.err.println(e.getMessage());
    }

    public List<Film> parse(InputStream in, Schema schema) throws ParserConfigurationException, SAXException, IOException {

        /**
         * SAXParserFactory factory = SAXParserFactory.newInstance();
         *
         * // to be compliant, completely disable DOCTYPE declaration:
         * factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
         *
         * // or completely disable external entities declarations:
         * factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
         * factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
         *
         * // or prohibit the use of all protocols by external entities:
         * SAXParser parser = factory.newSAXParser(); // Noncompliant
         * parser.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
         * parser.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
         *
         */
        // XML parsers should not be vulnerable to XXE attacks
        // Fix by yourself
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);

        // make parser validating
//		factory.setFeature(Const.FEATURE__TURN_VALIDATION_ON, true);
//		factory.setFeature(Const.FEATURE__TURN_SCHEMA_VALIDATION_ON, true);

        factory.setSchema(schema);
        javax.xml.parsers.SAXParser parser = factory.newSAXParser();
        parser.parse(in, this);

        return this.films;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        this.current = localName;

        if (Const.TAG_FILMS.equals(this.current)) {
            this.films = new ArrayList<>();
        } else if (Const.TAG_FILM.equals(this.current)) {
            this.film = new Film();
            if (attributes.getLength() > 0) {
                this.film.setId(Integer.parseInt(attributes.getValue("Id")));
            }
        } else if (Const.TAG_TICKET.equals(this.current)) {
            this.ticket = new Ticket();
            if (attributes.getLength() > 0) {
                this.ticket.setId(Integer.parseInt(attributes.getValue("Id")));
            }
        } else if (Const.TAG_VIEWER.equals(this.current)) {
            this.viewer = new Viewer();
            if (attributes.getLength() > 0) {
                this.viewer.setId(Integer.parseInt(attributes.getValue("Id")));
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String value = new String(ch, start, length);
        if (value.isBlank()) {
            return;
        }
        if (Const.TAG_FILMTITLE.equals(this.current)) {
            this.film.setFilmTitle(value);
        } else if (Const.TAG_DURATION.equals(this.current)) {
            this.film.setDuration(value);
        } else if (Const.TAG_SHOWTYPE.equals(this.current)) {
            this.film.setShowType(value);
        } else if (Const.TAG_TICKETNUMBER.equals(this.current)) {
            this.ticket.setTicketNumber(value);
        } else if (Const.TAG_SEATNUMBER.equals(this.current)) {
            this.ticket.setSeatNumber(value);
        } else if (Const.TAG_PURCHASEDATE.equals(this.current)) {
            this.ticket.setPurchaseDate(value);
        } else if (Const.TAG_NAME.equals(this.current)) {
            this.viewer.setName(value);
        } else if (Const.TAG_SURNAME.equals(this.current)) {
            this.viewer.setSurname(value);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (Const.TAG_FILM.equals(localName)) {
            this.films.add(this.film);
            log(this.current + " " + this.film);
        } else if (Const.TAG_TICKET.equals(localName)) {
            this.film.getTicket().add(this.ticket);
            log(this.current + " " + this.ticket);
        } else if (Const.TAG_VIEWER.equals(localName)) {
            this.ticket.setViewer(this.viewer);
            log(this.current + " " + this.viewer);
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // Create against validation schema
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File(Const.XSD_FILE));

        System.out.println("--== SAX Parser ==--");
        SAXParser parser = new SAXParser();
        parser.parse(new FileInputStream("xml/films.xml"), schema);
        List<Film> films = parser.getFilms();
        System.out.println("====================================");
        System.out.println("Here is the films: \n" + films);
        System.out.println("====================================");
        parser.parse(new FileInputStream(Const.INVALID_XML_FILE), schema);
        films = parser.getFilms();
        System.out.println("====================================");
        System.out.println("Here is the invalid films: \n" + films);
        System.out.println("====================================");
    }
}


