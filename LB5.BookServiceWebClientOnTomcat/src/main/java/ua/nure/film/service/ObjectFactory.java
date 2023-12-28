
package ua.nure.film.service;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;

import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ua.nure.film.service package. 
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

    private final static QName _DAOException_QNAME = new QName("http://film.nure.ua/service", "DAOException");
    private final static QName _AddFilm_QNAME = new QName("http://film.nure.ua/service", "addFilm");
    private final static QName _AddFilmResponse_QNAME = new QName("http://film.nure.ua/service", "addFilmResponse");
    private final static QName _AddTicket_QNAME = new QName("http://film.nure.ua/service", "addTicket");
    private final static QName _AddTicketResponse_QNAME = new QName("http://film.nure.ua/service", "addTicketResponse");
    private final static QName _GetTicket_QNAME = new QName("http://film.nure.ua/service", "getTicket");
    private final static QName _GetTicketResponse_QNAME = new QName("http://film.nure.ua/service", "getTicketResponse");
    private final static QName _ListFilms_QNAME = new QName("http://film.nure.ua/service", "listFilms");
    private final static QName _ListFilmsResponse_QNAME = new QName("http://film.nure.ua/service", "listFilmsResponse");
    private final static QName _RemoveFilm_QNAME = new QName("http://film.nure.ua/service", "removeFilm");
    private final static QName _RemoveFilmResponse_QNAME = new QName("http://film.nure.ua/service", "removeFilmResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ua.nure.film.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DAOException }
     * 
     */
    public DAOException createDAOException() {
        return new DAOException();
    }

    /**
     * Create an instance of {@link AddFilm }
     * 
     */
    public AddFilm createAddFilm() {
        return new AddFilm();
    }

    /**
     * Create an instance of {@link AddFilmResponse }
     * 
     */
    public AddFilmResponse createAddFilmResponse() {
        return new AddFilmResponse();
    }

    /**
     * Create an instance of {@link AddTicket }
     * 
     */
    public AddTicket createAddTicket() {
        return new AddTicket();
    }

    /**
     * Create an instance of {@link AddTicketResponse }
     * 
     */
    public AddTicketResponse createAddTicketResponse() {
        return new AddTicketResponse();
    }

    /**
     * Create an instance of {@link GetTicket }
     * 
     */
    public GetTicket createGetTicket() {
        return new GetTicket();
    }

    /**
     * Create an instance of {@link GetTicketResponse }
     * 
     */
    public GetTicketResponse createGetTicketResponse() {
        return new GetTicketResponse();
    }

    /**
     * Create an instance of {@link ListFilms }
     * 
     */
    public ListFilms createListFilms() {
        return new ListFilms();
    }

    /**
     * Create an instance of {@link ListFilmsResponse }
     * 
     */
    public ListFilmsResponse createListFilmsResponse() {
        return new ListFilmsResponse();
    }

    /**
     * Create an instance of {@link RemoveFilm }
     * 
     */
    public RemoveFilm createRemoveFilm() {
        return new RemoveFilm();
    }

    /**
     * Create an instance of {@link RemoveFilmResponse }
     * 
     */
    public RemoveFilmResponse createRemoveFilmResponse() {
        return new RemoveFilmResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DAOException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DAOException }{@code >}
     */
    @XmlElementDecl(namespace = "http://film.nure.ua/service", name = "DAOException")
    public JAXBElement<DAOException> createDAOException(DAOException value) {
        return new JAXBElement<DAOException>(_DAOException_QNAME, DAOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddFilm }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddFilm }{@code >}
     */
    @XmlElementDecl(namespace = "http://film.nure.ua/service", name = "addFilm")
    public JAXBElement<AddFilm> createAddFilm(AddFilm value) {
        return new JAXBElement<AddFilm>(_AddFilm_QNAME, AddFilm.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddFilmResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddFilmResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://film.nure.ua/service", name = "addFilmResponse")
    public JAXBElement<AddFilmResponse> createAddFilmResponse(AddFilmResponse value) {
        return new JAXBElement<AddFilmResponse>(_AddFilmResponse_QNAME, AddFilmResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddTicket }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddTicket }{@code >}
     */
    @XmlElementDecl(namespace = "http://film.nure.ua/service", name = "addTicket")
    public JAXBElement<AddTicket> createAddTicket(AddTicket value) {
        return new JAXBElement<AddTicket>(_AddTicket_QNAME, AddTicket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddTicketResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddTicketResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://film.nure.ua/service", name = "addTicketResponse")
    public JAXBElement<AddTicketResponse> createAddTicketResponse(AddTicketResponse value) {
        return new JAXBElement<AddTicketResponse>(_AddTicketResponse_QNAME, AddTicketResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTicket }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetTicket }{@code >}
     */
    @XmlElementDecl(namespace = "http://film.nure.ua/service", name = "getTicket")
    public JAXBElement<GetTicket> createGetTicket(GetTicket value) {
        return new JAXBElement<GetTicket>(_GetTicket_QNAME, GetTicket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTicketResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetTicketResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://film.nure.ua/service", name = "getTicketResponse")
    public JAXBElement<GetTicketResponse> createGetTicketResponse(GetTicketResponse value) {
        return new JAXBElement<GetTicketResponse>(_GetTicketResponse_QNAME, GetTicketResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListFilms }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListFilms }{@code >}
     */
    @XmlElementDecl(namespace = "http://film.nure.ua/service", name = "listFilms")
    public JAXBElement<ListFilms> createListFilms(ListFilms value) {
        return new JAXBElement<ListFilms>(_ListFilms_QNAME, ListFilms.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListFilmsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListFilmsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://film.nure.ua/service", name = "listFilmsResponse")
    public JAXBElement<ListFilmsResponse> createListFilmsResponse(ListFilmsResponse value) {
        return new JAXBElement<ListFilmsResponse>(_ListFilmsResponse_QNAME, ListFilmsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveFilm }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveFilm }{@code >}
     */
    @XmlElementDecl(namespace = "http://film.nure.ua/service", name = "removeFilm")
    public JAXBElement<RemoveFilm> createRemoveFilm(RemoveFilm value) {
        return new JAXBElement<RemoveFilm>(_RemoveFilm_QNAME, RemoveFilm.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveFilmResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveFilmResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://film.nure.ua/service", name = "removeFilmResponse")
    public JAXBElement<RemoveFilmResponse> createRemoveFilmResponse(RemoveFilmResponse value) {
        return new JAXBElement<RemoveFilmResponse>(_RemoveFilmResponse_QNAME, RemoveFilmResponse.class, null, value);
    }

}
