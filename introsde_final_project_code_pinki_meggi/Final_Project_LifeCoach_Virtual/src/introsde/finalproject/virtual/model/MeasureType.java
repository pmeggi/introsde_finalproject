package introsde.finalproject.virtual.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "measuretype")	
@XmlType(propOrder = { "measure"})
@XmlAccessorType(XmlAccessType.FIELD)
public class MeasureType{
	private String measure;
	
	public MeasureType(String measure) {
		this.setMeasure(measure);
	}
	
	public MeasureType() {
	}

	public String getMeasure() {
		return this.measure;
	}
	public void setMeasure(String measure) {
		this.measure= measure;
	}
	
	public String toString() {
		return "{"+this.measure+"}";
	}
}
