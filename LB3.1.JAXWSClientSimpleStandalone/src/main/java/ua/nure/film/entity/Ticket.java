
package ua.nure.film.entity;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Ticket complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Ticket"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://film.nure.ua/entity}EntityBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Ticket_Number" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Seat_Number" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Purchase_Date" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Viewer" type="{http://film.nure.ua/entity}Viewer"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ticket", propOrder = {
    "ticketNumber",
    "seatNumber",
    "purchaseDate",
    "viewer"
})
public class Ticket
    extends EntityBase
{

    @XmlElement(name = "Ticket_Number", required = true)
    protected String ticketNumber;
    @XmlElement(name = "Seat_Number", required = true)
    protected String seatNumber;
    @XmlElement(name = "Purchase_Date", required = true)
    protected String purchaseDate;
    @XmlElement(name = "Viewer", required = true)
    protected Viewer viewer;

    /**
     * Gets the value of the ticketNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketNumber() {
        return ticketNumber;
    }

    /**
     * Sets the value of the ticketNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketNumber(String value) {
        this.ticketNumber = value;
    }

    /**
     * Gets the value of the seatNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeatNumber() {
        return seatNumber;
    }

    /**
     * Sets the value of the seatNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeatNumber(String value) {
        this.seatNumber = value;
    }

    /**
     * Gets the value of the purchaseDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * Sets the value of the purchaseDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaseDate(String value) {
        this.purchaseDate = value;
    }

    /**
     * Gets the value of the viewer property.
     * 
     * @return
     *     possible object is
     *     {@link Viewer }
     *     
     */
    public Viewer getViewer() {
        return viewer;
    }

    /**
     * Sets the value of the viewer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Viewer }
     *     
     */
    public void setViewer(Viewer value) {
        this.viewer = value;
    }

}
