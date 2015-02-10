
package introsde.finalproject.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for readGoalTypeResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="readGoalTypeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="gType" type="{http://soap.finalproject.introsde/}goalType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readGoalTypeResponse", propOrder = {
    "gType"
})
public class ReadGoalTypeResponse {

    protected GoalType gType;

    /**
     * Gets the value of the gType property.
     * 
     * @return
     *     possible object is
     *     {@link GoalType }
     *     
     */
    public GoalType getGType() {
        return gType;
    }

    /**
     * Sets the value of the gType property.
     * 
     * @param value
     *     allowed object is
     *     {@link GoalType }
     *     
     */
    public void setGType(GoalType value) {
        this.gType = value;
    }

}
