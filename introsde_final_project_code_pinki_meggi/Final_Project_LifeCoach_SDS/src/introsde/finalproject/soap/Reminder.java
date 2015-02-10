
package introsde.finalproject.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for reminder complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="reminder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idReminder" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="typeReminder" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WDay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MDay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateRegistered" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reminder", propOrder = {
    "idReminder",
    "description",
    "typeReminder",
    "wDay",
    "mDay",
    "sDate",
    "status",
    "dateRegistered"
})
public class Reminder {

    protected Long idReminder;
    protected String description;
    protected String typeReminder;
    @XmlElement(name = "WDay")
    protected String wDay;
    @XmlElement(name = "MDay")
    protected String mDay;
    @XmlElement(name = "SDate")
    protected String sDate;
    protected String status;
    protected String dateRegistered;

    /**
     * Gets the value of the idReminder property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdReminder() {
        return idReminder;
    }

    /**
     * Sets the value of the idReminder property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdReminder(Long value) {
        this.idReminder = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the typeReminder property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeReminder() {
        return typeReminder;
    }

    /**
     * Sets the value of the typeReminder property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeReminder(String value) {
        this.typeReminder = value;
    }

    /**
     * Gets the value of the wDay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWDay() {
        return wDay;
    }

    /**
     * Sets the value of the wDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWDay(String value) {
        this.wDay = value;
    }

    /**
     * Gets the value of the mDay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMDay() {
        return mDay;
    }

    /**
     * Sets the value of the mDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMDay(String value) {
        this.mDay = value;
    }

    /**
     * Gets the value of the sDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSDate() {
        return sDate;
    }

    /**
     * Sets the value of the sDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSDate(String value) {
        this.sDate = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the dateRegistered property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateRegistered() {
        return dateRegistered;
    }

    /**
     * Sets the value of the dateRegistered property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateRegistered(String value) {
        this.dateRegistered = value;
    }

}
