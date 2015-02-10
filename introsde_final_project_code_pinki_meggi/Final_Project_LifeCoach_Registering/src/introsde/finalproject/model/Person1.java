package introsde.finalproject.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "person")	
@XmlType(propOrder = { "personId", "firstname", "lastname", "birthdate", "email","username", "password"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Person1{
	private String firstname;		
	private String lastname;		
	private String birthdate;
	private String email;
	private String username;
	private String password;
	private Long personId;
	
	public Person1(Long personId, String fname, String lname, String birthdate, String email, String username, String passwd) {
		this.setPersonId(personId); 	
		this.setFirstname(fname);
		this.setLastname(lname);
		this.setBirthdate(birthdate); 	
		this.setUsername(username);
		this.setPassword(passwd);
		this.setEmail(email);		
	}
	
	public Person1() {
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String passwd) {
		this.password = passwd;
	}
	
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String toString() {
		return "{"+this.personId+","+this.firstname+","+this.lastname+","+this.birthdate+this.username+this.password+"}";
	}
}
