
package introsde.finalproject.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createPersonMeasurementResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createPersonMeasurementResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="measureHistory" type="{http://soap.finalproject.introsde/}measureHistory" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createPersonMeasurementResponse", propOrder = {
    "measureHistory"
})
public class CreatePersonMeasurementResponse {

    protected MeasureHistory measureHistory;

    /**
     * Gets the value of the measureHistory property.
     * 
     * @return
     *     possible object is
     *     {@link MeasureHistory }
     *     
     */
    public MeasureHistory getMeasureHistory() {
        return measureHistory;
    }

    /**
     * Sets the value of the measureHistory property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureHistory }
     *     
     */
    public void setMeasureHistory(MeasureHistory value) {
        this.measureHistory = value;
    }

}
