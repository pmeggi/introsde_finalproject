
package introsde.finalproject.storage.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import introsde.finalproject.soap.Reminder;


/**
 * <p>Java class for registerPersonReminder complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="registerPersonReminder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="personId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="reminder_i" type="{http://soap.finalproject.introsde/}reminder" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registerPersonReminder", propOrder = {
    "personId",
    "reminderI"
})
public class RegisterPersonReminder {

    protected Long personId;
    @XmlElement(name = "reminder_i")
    protected Reminder reminderI;

    /**
     * Gets the value of the personId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPersonId() {
        return personId;
    }

    /**
     * Sets the value of the personId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPersonId(Long value) {
        this.personId = value;
    }

    /**
     * Gets the value of the reminderI property.
     * 
     * @return
     *     possible object is
     *     {@link Reminder }
     *     
     */
    public Reminder getReminderI() {
        return reminderI;
    }

    /**
     * Sets the value of the reminderI property.
     * 
     * @param value
     *     allowed object is
     *     {@link Reminder }
     *     
     */
    public void setReminderI(Reminder value) {
        this.reminderI = value;
    }

}
