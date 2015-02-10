
package introsde.finalproject.storage.soap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import introsde.finalproject.soap.GoalType;


/**
 * <p>Java class for readGoalTypesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="readGoalTypesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="goalType" type="{http://soap.finalproject.introsde/}goalType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readGoalTypesResponse", propOrder = {
    "goalType"
})
public class ReadGoalTypesResponse {

    protected List<GoalType> goalType;

    /**
     * Gets the value of the goalType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the goalType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGoalType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GoalType }
     * 
     * 
     */
    public List<GoalType> getGoalType() {
        if (goalType == null) {
            goalType = new ArrayList<GoalType>();
        }
        return this.goalType;
    }

}
