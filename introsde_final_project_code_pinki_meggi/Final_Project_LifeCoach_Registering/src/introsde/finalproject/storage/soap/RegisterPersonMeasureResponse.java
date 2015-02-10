
package introsde.finalproject.storage.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import introsde.finalproject.soap.MeasureHistory;


/**
 * <p>Java class for registerPersonMeasureResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="registerPersonMeasureResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="measure" type="{http://soap.finalproject.introsde/}measureHistory" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registerPersonMeasureResponse", propOrder = {
    "measure"
})
public class RegisterPersonMeasureResponse {

    protected MeasureHistory measure;

    /**
     * Gets the value of the measure property.
     * 
     * @return
     *     possible object is
     *     {@link MeasureHistory }
     *     
     */
    public MeasureHistory getMeasure() {
        return measure;
    }

    /**
     * Sets the value of the measure property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureHistory }
     *     
     */
    public void setMeasure(MeasureHistory value) {
        this.measure = value;
    }

}
