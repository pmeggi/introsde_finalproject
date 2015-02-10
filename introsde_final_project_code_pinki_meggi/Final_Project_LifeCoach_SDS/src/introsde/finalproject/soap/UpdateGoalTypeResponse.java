
package introsde.finalproject.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateGoalTypeResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateGoalTypeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="gtype" type="{http://soap.finalproject.introsde/}goalType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateGoalTypeResponse", propOrder = {
    "gtype"
})
public class UpdateGoalTypeResponse {

    protected GoalType gtype;

    /**
     * Gets the value of the gtype property.
     * 
     * @return
     *     possible object is
     *     {@link GoalType }
     *     
     */
    public GoalType getGtype() {
        return gtype;
    }

    /**
     * Sets the value of the gtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link GoalType }
     *     
     */
    public void setGtype(GoalType value) {
        this.gtype = value;
    }

}
