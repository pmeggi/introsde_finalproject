
package introsde.finalproject.storage.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import introsde.finalproject.soap.MeasureHistory;


/**
 * <p>Java class for editPersonMeasurementResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="editPersonMeasurementResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="measurehistory" type="{http://soap.finalproject.introsde/}measureHistory" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "editPersonMeasurementResponse", propOrder = {
    "measurehistory"
})
public class EditPersonMeasurementResponse {

    protected MeasureHistory measurehistory;

    /**
     * Gets the value of the measurehistory property.
     * 
     * @return
     *     possible object is
     *     {@link MeasureHistory }
     *     
     */
    public MeasureHistory getMeasurehistory() {
        return measurehistory;
    }

    /**
     * Sets the value of the measurehistory property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureHistory }
     *     
     */
    public void setMeasurehistory(MeasureHistory value) {
        this.measurehistory = value;
    }

}
