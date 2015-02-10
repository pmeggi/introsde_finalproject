package introsde.finalproject.virtual.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "goalType")	
@XmlType(propOrder = { "goalTypeId", "description", "measureType", "valueType", "type"})
@XmlAccessorType(XmlAccessType.FIELD)
public class GoalType1{
	
	private String measureType;
	private String valueType;
	private String type;
	private String description;
	private Long goalTypeId;
	
	public GoalType1(Long goalTypeId, String description, String measureType, String type, String valueType) {
		this.setGoalTypeId(goalTypeId);
		this.setDescription(description);
		this.setMeasureType(measureType);
		this.setType(type);
		this.setValueType(valueType);
	}
	
	public GoalType1() {
	}

	public Long getGoalTypeId() {
		return this.goalTypeId;
	}

	public void setGoalTypeId(Long idGoalType) {
		this.goalTypeId = idGoalType;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	public String getValueType() {
		return this.valueType;
	}

	public void setValueType(String vtype) {
		this.valueType = vtype;
	}
	

	public String getMeasureType() {
	    return this.measureType;
	}

	public void setMeasureType(String m) {
	    this.measureType = m;
	}

	public String toString() {
		return "{"+this.goalTypeId+","+this.description+","+this.measureType+","+this.valueType+this.type+"}";
	}
}