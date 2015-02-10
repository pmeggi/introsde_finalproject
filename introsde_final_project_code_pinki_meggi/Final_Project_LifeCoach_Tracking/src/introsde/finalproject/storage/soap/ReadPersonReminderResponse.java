
package introsde.finalproject.storage.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import introsde.finalproject.soap.Reminder;


/**
 * <p>Java class for readPersonReminderResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="readPersonReminderResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reminder" type="{http://soap.finalproject.introsde/}reminder" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readPersonReminderResponse", propOrder = {
    "reminder"
})
public class ReadPersonReminderResponse {

    protected Reminder reminder;

    /**
     * Gets the value of the reminder property.
     * 
     * @return
     *     possible object is
     *     {@link Reminder }
     *     
     */
    public Reminder getReminder() {
        return reminder;
    }

    /**
     * Sets the value of the reminder property.
     * 
     * @param value
     *     allowed object is
     *     {@link Reminder }
     *     
     */
    public void setReminder(Reminder value) {
        this.reminder = value;
    }

}
