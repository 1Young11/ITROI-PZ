package ua.nure.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.example.xml.entity.cinema.Film;
import org.example.xml.entity.cinema.Ticket;
import org.example.xml.entity.cinema.Viewer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class DOMParser {
    private static boolean logEnabled = true;

    private static void log(Object o) {
        if (logEnabled) {
            System.out.println(o);
        }
    }

    private Film parseFilm(Node node) {
        Film film = new Film();
        Integer attrId = this.GetAttributeIdFromNode(node);
        if (attrId != null) {
            film.setId(attrId);
        }
        NodeList nodes = node.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node item = nodes.item(i);
            String localName = item.getLocalName();
            String textContent = item.getTextContent();
            log(localName);
            if (Const.TAG_TICKET.equals(localName)) {
                film.getTicket().add(parseTicket(item));
                log("add ticket" + item);
            } else if (Const.TAG_FILMTITLE.equals(localName)) {
                film.setFilmTitle(textContent);
                log("add filmtitle" + textContent);
            } else if (Const.TAG_DURATION.equals(localName)) {
                film.setDuration(textContent);
                log("add film duration" + textContent);
            } else if (Const.TAG_SHOWTYPE.equals(localName)) {
                film.setShowType(textContent);
                log("add film show type" + textContent);
            }
        }

        return film;
    }

    private Ticket parseTicket(Node node)  {
        Ticket ticket = new Ticket();
        Integer attrId = this.GetAttributeIdFromNode(node);
        if (attrId != null) {
            ticket.setId(attrId);
        }
        NodeList nodes = node.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node item = nodes.item(i);
            String localName = item.getLocalName();
            String textContent = item.getTextContent();
            log(localName);
            if (Const.TAG_TICKETNUMBER.equals(localName)) {
                ticket.setTicketNumber(textContent);
                log("add ticket number" + textContent);
            } else if (Const.TAG_SEATNUMBER.equals(localName)) {
                ticket.setSeatNumber(textContent);
                log("add ticket seat number" + textContent);
            } else if (Const.TAG_PURCHASEDATE.equals(localName)) {
                ticket.setPurchaseDate(textContent);
                log("add ticket purchase date");
            }
            else if (Const.TAG_VIEWER.equals(localName)) {
                ticket.setViewer(parseViewer(item));
                log("add viewer" + item);
            }
        }

        return ticket;
    }

    private Viewer parseViewer(Node node) {
        Viewer viewer = new Viewer();
        Integer attrId = this.GetAttributeIdFromNode(node);
        if (attrId != null) {
            viewer.setId(attrId);
        }

        NodeList nodes = node.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node item = nodes.item(i);
            String localName = item.getLocalName();
            String textContent = item.getTextContent();
            log(localName);

            if (Const.TAG_NAME.equals(localName)) {
                viewer.setName(textContent);
                log("add viewer name" + textContent);
            } else if (Const.TAG_SURNAME.equals(localName)) {
                viewer.setSurname(localName);
                log("add viewer surname" + textContent);
            }
        }

        return viewer;
    }

    private Integer GetAttributeIdFromNode(Node node) {
        if (node.hasAttributes()) {
            NamedNodeMap attrs = node.getAttributes();
            Node item = attrs.getNamedItem(Const.ATTRIBUTE_ID);
            String textContent = item.getTextContent();
            log(item.getLocalName() + "=" + textContent);
            return Integer.parseInt(textContent);
        }

        return null;
    }

    public List<Film> parse(InputStream in, Schema schema)
            throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);

        // to be compliant, completely disable DOCTYPE declaration:
        dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        // or completely disable external entities declarations:
//		dbf.setFeature("http://xml.org/sax/features/external-general-entities", false);
//		dbf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);

        // make parser validating against XSD, which internally referenced in XML doc
        // !!! OLD VULNERABLE FEATURE !!!
//		dbf.setFeature(Const.FEATURE__TURN_VALIDATION_ON, true);
//		dbf.setFeature(Const.FEATURE__TURN_SCHEMA_VALIDATION_ON, true);

        // set the validation against schema
        dbf.setSchema(schema);

        DocumentBuilder db = dbf.newDocumentBuilder();

        // setup validation error handler
        // the preferred way is the throwing an exception
        db.setErrorHandler(new DefaultHandler() {
            @Override
            public void error(SAXParseException e) throws SAXException {
                System.err.println(e.getMessage()); // log error
//				throw e;
            }
        });

        // get the top of the xml tree
        Document root = db.parse(in);

        List<Film> films = new ArrayList<>();

        // get the root element of the xml document
        Element e = root.getDocumentElement();
        NodeList xmlArticles = e.getElementsByTagNameNS(Const.FILMS_NAMESPACE_URI, Const.TAG_FILM);
        for (int i = 0; i < xmlArticles.getLength(); i++) {
            films.add(parseFilm(xmlArticles.item(i)));
        }

        return films;
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // Create against validation schema
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File("xml/Films.xsd"));

        System.out.println("--== DOM Parser ==--");
        DOMParser domParser = new DOMParser();
        InputStream in = new FileInputStream("xml/Films.xml");
        List<Film> films = domParser.parse(in, schema);

        System.out.println("====================================");
        System.out.println("Here is the films: \n" + films);
        System.out.println("====================================");

        in = new FileInputStream("xml/Invalid_films.xml");
        films = domParser.parse(in, schema);
        System.out.println("====================================");
        System.out.println("Here is the films from invalid xml: \n" + films);
        System.out.println("====================================");
    }
}
