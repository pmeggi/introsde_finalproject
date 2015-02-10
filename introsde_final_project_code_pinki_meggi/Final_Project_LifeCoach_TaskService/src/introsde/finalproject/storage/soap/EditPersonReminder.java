
package introsde.finalproject.storage.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import introsde.finalproject.soap.Reminder;


/**
 * <p>Java class for editPersonReminder complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="editPersonReminder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="personId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="reminder_u" type="{http://soap.finalproject.introsde/}reminder" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "editPersonReminder", propOrder = {
    "personId",
    "reminderU"
})
public class EditPersonReminder {

    protected Long personId;
    @XmlElement(name = "reminder_u")
    protected Reminder reminderU;

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
     * Gets the value of the reminderU property.
     * 
     * @return
     *     possible object is
     *     {@link Reminder }
     *     
     */
    public Reminder getReminderU() {
        return reminderU;
    }

    /**
     * Sets the value of the reminderU property.
     * 
     * @param value
     *     allowed object is
     *     {@link Reminder }
     *     
     */
    public void setReminderU(Reminder value) {
        this.reminderU = value;
    }

}
