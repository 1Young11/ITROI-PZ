
package ua.nure.film.entity;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ua.nure.film.entity package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Film_QNAME = new QName("http://film.nure.ua/entity", "Film");
    private final static QName _Ticket_QNAME = new QName("http://film.nure.ua/entity", "Ticket");
    private final static QName _ListFilms_QNAME = new QName("http://film.nure.ua/entity", "listFilms");
    private final static QName _Return_QNAME = new QName("http://film.nure.ua/entity", "return");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ua.nure.film.entity
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Film }
     * 
     */
    public Film createFilm() {
        return new Film();
    }

    /**
     * Create an instance of {@link Ticket }
     * 
     */
    public Ticket createTicket() {
        return new Ticket();
    }

    /**
     * Create an instance of {@link EntityBase }
     * 
     */
    public EntityBase createEntityBase() {
        return new EntityBase();
    }

    /**
     * Create an instance of {@link Viewer }
     * 
     */
    public Viewer createViewer() {
        return new Viewer();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Film }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Film }{@code >}
     */
    @XmlElementDecl(namespace = "http://film.nure.ua/entity", name = "Film")
    public JAXBElement<Film> createFilm(Film value) {
        return new JAXBElement<Film>(_Film_QNAME, Film.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ticket }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Ticket }{@code >}
     */
    @XmlElementDecl(namespace = "http://film.nure.ua/entity", name = "Ticket")
    public JAXBElement<Ticket> createTicket(Ticket value) {
        return new JAXBElement<Ticket>(_Ticket_QNAME, Ticket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Film }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Film }{@code >}
     */
    @XmlElementDecl(namespace = "http://film.nure.ua/entity", name = "listFilms")
    public JAXBElement<Film> createListFilms(Film value) {
        return new JAXBElement<Film>(_ListFilms_QNAME, Film.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://film.nure.ua/entity", name = "return")
    public JAXBElement<Integer> createReturn(Integer value) {
        return new JAXBElement<Integer>(_Return_QNAME, Integer.class, null, value);
    }

}
