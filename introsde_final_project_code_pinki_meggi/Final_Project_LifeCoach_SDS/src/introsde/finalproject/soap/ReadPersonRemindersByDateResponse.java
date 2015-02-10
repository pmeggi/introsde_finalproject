
package introsde.finalproject.soap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for readPersonRemindersByDateResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="readPersonRemindersByDateResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reminder" type="{http://soap.finalproject.introsde/}reminder" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readPersonRemindersByDateResponse", propOrder = {
    "reminder"
})
public class ReadPersonRemindersByDateResponse {

    protected List<Reminder> reminder;

    /**
     * Gets the value of the reminder property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reminder property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReminder().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Reminder }
     * 
     * 
     */
    public List<Reminder> getReminder() {
        if (reminder == null) {
            reminder = new ArrayList<Reminder>();
        }
        return this.reminder;
    }

}
