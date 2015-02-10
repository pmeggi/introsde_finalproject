
package introsde.finalproject.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createGoalType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createGoalType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="gType_i" type="{http://soap.finalproject.introsde/}goalType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createGoalType", propOrder = {
    "gTypeI"
})
public class CreateGoalType {

    @XmlElement(name = "gType_i")
    protected GoalType gTypeI;

    /**
     * Gets the value of the gTypeI property.
     * 
     * @return
     *     possible object is
     *     {@link GoalType }
     *     
     */
    public GoalType getGTypeI() {
        return gTypeI;
    }

    /**
     * Sets the value of the gTypeI property.
     * 
     * @param value
     *     allowed object is
     *     {@link GoalType }
     *     
     */
    public void setGTypeI(GoalType value) {
        this.gTypeI = value;
    }

}
