
package introsde.finalproject.storage.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import introsde.finalproject.soap.MeasureHistory;


/**
 * <p>Java class for editPersonMeasurement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="editPersonMeasurement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="personId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="measureType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="measurehistory_u" type="{http://soap.finalproject.introsde/}measureHistory" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "editPersonMeasurement", propOrder = {
    "personId",
    "measureType",
    "measurehistoryU"
})
public class EditPersonMeasurement {

    protected Long personId;
    protected String measureType;
    @XmlElement(name = "measurehistory_u")
    protected MeasureHistory measurehistoryU;

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
     * Gets the value of the measureType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeasureType() {
        return measureType;
    }

    /**
     * Sets the value of the measureType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeasureType(String value) {
        this.measureType = value;
    }

    /**
     * Gets the value of the measurehistoryU property.
     * 
     * @return
     *     possible object is
     *     {@link MeasureHistory }
     *     
     */
    public MeasureHistory getMeasurehistoryU() {
        return measurehistoryU;
    }

    /**
     * Sets the value of the measurehistoryU property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureHistory }
     *     
     */
    public void setMeasurehistoryU(MeasureHistory value) {
        this.measurehistoryU = value;
    }

}
