
package introsde.finalproject.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for deletePersonMeasurement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deletePersonMeasurement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mhId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deletePersonMeasurement", propOrder = {
    "mhId"
})
public class DeletePersonMeasurement {

    protected Long mhId;

    /**
     * Gets the value of the mhId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMhId() {
        return mhId;
    }

    /**
     * Sets the value of the mhId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMhId(Long value) {
        this.mhId = value;
    }

}
