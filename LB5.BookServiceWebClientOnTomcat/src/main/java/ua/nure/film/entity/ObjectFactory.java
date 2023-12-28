//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.12.14 at 09:46:54 PM EET 
//


package ua.nure.film.entity;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example.xml.entity package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.xml.entity
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EntityBase }
     * 
     */
    public EntityBase createEntityBase() {
        return new EntityBase();
    }

    /**
     * Create an instance of {@link org.example.xml.entity.cinema.Films }
     *
     */
    public Films createFilms() {
        return new Films();
    }

    /**
     * Create an instance of {@link org.example.xml.entity.cinema.Film }
     *
     */
    public Film createFilm() {
        return new Film();
    }

    /**
     * Create an instance of {@link org.example.xml.entity.cinema.Viewer }
     *
     */
    public Viewer createViewer() {
        return new Viewer();
    }

    /**
     * Create an instance of {@link org.example.xml.entity.cinema.Ticket }
     *
     */
    public Ticket createTicket() {
        return new Ticket();
    }

}
