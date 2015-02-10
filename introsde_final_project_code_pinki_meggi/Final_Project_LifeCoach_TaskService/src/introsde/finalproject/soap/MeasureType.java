
package introsde.finalproject.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for measureType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="measureType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idMeasureType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="measure" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "measureType", propOrder = {
    "idMeasureType",
    "measure"
})
public class MeasureType {

    protected int idMeasureType;
    protected String measure;

    /**
     * Gets the value of the idMeasureType property.
     * 
     */
    public int getIdMeasureType() {
        return idMeasureType;
    }

    /**
     * Sets the value of the idMeasureType property.
     * 
     */
    public void setIdMeasureType(int value) {
        this.idMeasureType = value;
    }

    /**
     * Gets the value of the measure property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeasure() {
        return measure;
    }

    /**
     * Sets the value of the measure property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeasure(String value) {
        this.measure = value;
    }

}
