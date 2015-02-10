package introsde.finalproject.virtual.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "measure")	
@XmlType(propOrder = { "mid", "measure", "value", "created"})
@XmlAccessorType(XmlAccessType.FIELD)
public class MeasureHistory1{
	private Long mid;
	private String measure;
	private String value;		
	private String created;		
	
	public MeasureHistory1(Long mid, String measure, String value, String created) {
		this.setMid(mid);
		this.setMeasure(measure);
		this.setValue(value);
		this.setCreated(created);
	}
	
	public MeasureHistory1() {
	}

	public String getMeasure() {
		return this.measure;
	}
	public void setMeasure(String measure) {
		this.measure= measure;
	}
	
	public String getValue() {
		return this.value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getCreated() {
		return this.created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	
	public Long getMid() {
		return this.mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
	}

	public String toString() {
		return "{"+this.mid+","+this.measure+","+this.value+","+this.created+"}";
	}
}
