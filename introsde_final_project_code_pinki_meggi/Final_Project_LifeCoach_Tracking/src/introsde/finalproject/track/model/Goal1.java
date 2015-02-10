package introsde.finalproject.track.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "goal")	
@XmlType(propOrder = { "goalId", "value","measure","type","created","status"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Goal1{
	private String status;		
	private String created;		
	private String measure;
	private String type;
	private String value;
	private Long goalId;
	
	public Goal1(Long goalId, String goalValue, String measure, String type, String created, String status) {
		this.setGoalId(goalId);
		this.setValue(goalValue);
		this.setMeasure(measure);
		this.setType(type);
		this.setCreated(created);
		this.setStatus(status);
	}
	
	public Goal1() {
	}

	public Long getGoalId() {
		return this.goalId;
	}
	public void setGoalId(Long goalId) {
		this.goalId = goalId;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getMeasure() {
		return this.measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}
	
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getCreated() {
		return this.created;
	}

	public void setCreated(String date) {
		this.created = date;
	}


	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public String toString() {
		return "{"+this.goalId+","+this.value+","+this.measure+","+this.type+","+this.created+this.status+"}";
	}
}
