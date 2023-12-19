
package ua.nure.film.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Film complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Film"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://film.nure.ua/entity}EntityBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Film_Title" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Duration" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Show_Type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Ticket" type="{http://film.nure.ua/entity}Ticket" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Film", propOrder = {
    "filmTitle",
    "duration",
    "showType",
    "ticket"
})
public class Film
    extends EntityBase
{

    @XmlElement(name = "Film_Title", required = true)
    protected String filmTitle;
    @XmlElement(name = "Duration", required = true)
    protected String duration;
    @XmlElement(name = "Show_Type", required = true)
    protected String showType;
    @XmlElement(name = "Ticket")
    protected List<Ticket> ticket;

    /**
     * Gets the value of the filmTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilmTitle() {
        return filmTitle;
    }

    /**
     * Sets the value of the filmTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilmTitle(String value) {
        this.filmTitle = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDuration(String value) {
        this.duration = value;
    }

    /**
     * Gets the value of the showType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShowType() {
        return showType;
    }

    /**
     * Sets the value of the showType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShowType(String value) {
        this.showType = value;
    }

    /**
     * Gets the value of the ticket property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the ticket property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTicket().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ticket }
     * 
     * 
     */
    public List<Ticket> getTicket() {
        if (ticket == null) {
            ticket = new ArrayList<Ticket>();
        }
        return this.ticket;
    }

}
