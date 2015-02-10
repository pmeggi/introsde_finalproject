
package introsde.finalproject.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for goal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="goal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idGoal" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="goalValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateRegistered" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="goalType" type="{http://soap.finalproject.introsde/}goalType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "goal", propOrder = {
    "idGoal",
    "goalValue",
    "status",
    "dateRegistered",
    "goalType"
})
public class Goal {

    protected Long idGoal;
    protected String goalValue;
    protected String status;
    protected String dateRegistered;
    protected GoalType goalType;

    /**
     * Gets the value of the idGoal property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdGoal() {
        return idGoal;
    }

    /**
     * Sets the value of the idGoal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdGoal(Long value) {
        this.idGoal = value;
    }

    /**
     * Gets the value of the goalValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGoalValue() {
        return goalValue;
    }

    /**
     * Sets the value of the goalValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGoalValue(String value) {
        this.goalValue = value;
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

    /**
     * Gets the value of the goalType property.
     * 
     * @return
     *     possible object is
     *     {@link GoalType }
     *     
     */
    public GoalType getGoalType() {
        return goalType;
    }

    /**
     * Sets the value of the goalType property.
     * 
     * @param value
     *     allowed object is
     *     {@link GoalType }
     *     
     */
    public void setGoalType(GoalType value) {
        this.goalType = value;
    }

}
