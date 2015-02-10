package introsde.finalproject.task.model;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "reminder")	
@XmlType(propOrder = { "reminderId", "description", "type", "wDay", "mDay","sDate", "status","created"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Reminder1{
	private String created;	
	private String status;		
	private String sDate;		
	private String mDay;
	private String wDay;
	private String type;
	private String description;
	private Long reminderId;
	
	public Reminder1(Long reminderId, String description, String type, String wDay, String mDay, String sDate, String status, String created) {
		this.setReminderId(reminderId);
		this.setDescription(description);
		this.setType(type);
		this.setWDay(wDay);
		this.setMDay(mDay);
		this.setSDate(sDate);
		this.setStatus(status);
		this.setCreated(created);
	
	}
	
	public Reminder1() {
	}

	public Long getReminderId() {
		return this.reminderId;
	}

	public void setReminderId(Long reminderId) {
		this.reminderId = reminderId;
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

	public String getWDay() {
		return this.wDay;
	}

	public void setWDay(String wDay) {
		this.wDay = wDay;
	}

	public String getMDay() {
		return this.mDay;
	}

	public void setMDay(String mDay) {
		this.mDay = mDay;
	}

	public String getSDate() {
		return this.sDate;
	}
	
	public void setSDate(String sDate) {
		this.sDate = sDate;
	}
	
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	public String getCreated() {
		return this.created;
	}

	public void setCreated(String date) {
		this.created = date;
	}
	public String toString() {
		return "{"+this.reminderId+","+this.description+","+this.type+","+this.wDay+","+this.mDay+","+this.sDate+","+this.status+","+this.created+"}";
	}
}
