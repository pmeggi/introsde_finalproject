
package introsde.finalproject.storage.soap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import introsde.finalproject.soap.Reminder;


/**
 * <p>Java class for readPersonRemindersResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="readPersonRemindersResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reminders-history" type="{http://soap.finalproject.introsde/}reminder" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readPersonRemindersResponse", propOrder = {
    "remindersHistory"
})
public class ReadPersonRemindersResponse {

    @XmlElement(name = "reminders-history")
    protected List<Reminder> remindersHistory;

    /**
     * Gets the value of the remindersHistory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the remindersHistory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRemindersHistory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Reminder }
     * 
     * 
     */
    public List<Reminder> getRemindersHistory() {
        if (remindersHistory == null) {
            remindersHistory = new ArrayList<Reminder>();
        }
        return this.remindersHistory;
    }

}
