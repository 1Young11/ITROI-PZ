
package ua.nure.film.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 3.0.0
 * Generated source version: 3.0
 * 
 */
@WebServiceClient(name = "Film", targetNamespace = "http://film.nure.ua/service", wsdlLocation = "http://localhost:9000/films?wsdl")
public class Film
    extends Service
{

    private final static URL FILM_WSDL_LOCATION;
    private final static WebServiceException FILM_EXCEPTION;
    private final static QName FILM_QNAME = new QName("http://film.nure.ua/service", "Film");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9000/films?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        FILM_WSDL_LOCATION = url;
        FILM_EXCEPTION = e;
    }

    public Film() {
        super(__getWsdlLocation(), FILM_QNAME);
    }

    public Film(WebServiceFeature... features) {
        super(__getWsdlLocation(), FILM_QNAME, features);
    }

    public Film(URL wsdlLocation) {
        super(wsdlLocation, FILM_QNAME);
    }

    public Film(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FILM_QNAME, features);
    }

    public Film(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Film(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns FilmService
     */
    @WebEndpoint(name = "FilmPort")
    public FilmService getFilmPort() {
        return super.getPort(new QName("http://film.nure.ua/service", "FilmPort"), FilmService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FilmService
     */
    @WebEndpoint(name = "FilmPort")
    public FilmService getFilmPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://film.nure.ua/service", "FilmPort"), FilmService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FILM_EXCEPTION!= null) {
            throw FILM_EXCEPTION;
        }
        return FILM_WSDL_LOCATION;
    }

}
