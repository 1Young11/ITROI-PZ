
package ua.nure.film.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import ua.nure.film.entity.Ticket;


/**
 * <p>Java class for addTicket complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addTicket"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="filmId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element ref="{http://film.nure.ua/entity}Ticket" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addTicket", propOrder = {
    "filmId",
    "ticket"
})
public class AddTicket {

    @XmlElement(namespace = "")
    protected int filmId;
    @XmlElement(name = "Ticket", namespace = "http://film.nure.ua/entity")
    protected Ticket ticket;

    /**
     * Gets the value of the filmId property.
     * 
     */
    public int getFilmId() {
        return filmId;
    }

    /**
     * Sets the value of the filmId property.
     * 
     */
    public void setFilmId(int value) {
        this.filmId = value;
    }

    /**
     * Gets the value of the ticket property.
     * 
     * @return
     *     possible object is
     *     {@link Ticket }
     *     
     */
    public Ticket getTicket() {
        return ticket;
    }

    /**
     * Sets the value of the ticket property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ticket }
     *     
     */
    public void setTicket(Ticket value) {
        this.ticket = value;
    }

}
