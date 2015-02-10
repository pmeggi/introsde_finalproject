package introsde.finalproject.model;

import introsde.finalproject.dao.HealthProfileDao;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.util.List;


/**
 * The persistent class for the "Person" database table.
 * 
 */

@Entity
@Table(name="\"Person\"")
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
@XmlType(propOrder = { "idPerson" ,"firstname", "lastname", "birthdate","email", "username", "password"})
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	// For sqlite in particular, you need to use the following @GeneratedValue annotation
	// This holds also for the other tables
	// SQLITE implements auto increment ids through named sequences that are stored in a 
	// special table named "sqlite_sequence"
	@GeneratedValue(generator="sqlite_person")
	@TableGenerator(name="sqlite_person", table="sqlite_sequence",
	pkColumnName="name", valueColumnName="seq",
	pkColumnValue="Person")
	@Column(name="idPerson")
	@Id
	private Long idPerson;

	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;

	//@Temporal(TemporalType.DATE)
	//@Type(type="java.util.Date")
	//@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name="birthdate")
	//@XmlJavaTypeAdapter(DateAdapter.class)
	private String birthdate;

	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	/*@Column(name="birthdate")
	private String birthdate;
*/
	@OneToMany(mappedBy="person",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<MeasureHistory> measureHistory;
	
	@OneToMany(mappedBy="goalPerson",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Goal> goals;
	
	@OneToMany(mappedBy="person",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Reminder> reminders;
	
	public Person() {
	}
	
	@XmlElement
	public Long getIdPerson() {
		return this.idPerson;
	}

	public void setIdPerson(Long idPerson) {
		this.idPerson = idPerson;
	}

	@XmlElement
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@XmlElement
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@XmlElement
	public String getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	@XmlElement
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@XmlElement
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@XmlElement
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@XmlTransient
	public List<MeasureHistory> getMeasureHistorty() {
	    return measureHistory;
	}
	
	public void setMeasureHistory(List<MeasureHistory> mh) {
	    this.measureHistory = mh;
	}
	
	@XmlTransient
	public List<Goal> getPersonGoals() {
	    return goals;
	}

	public void setPersonGoals(List<Goal> personGoals) {
	    this.goals = personGoals;
	}
	
	@XmlTransient
	public List<Reminder> getPersonReminders() {
	    return reminders;
	}

	public void setPersonReminders(List<Reminder> personReminders) {
	    this.reminders = personReminders;
	}
	
	
	
	/* Database QUERY Operations */
	public static Person getPersonById(Long personId) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		Person p = em.find(Person.class, personId);
		HealthProfileDao.instance.closeConnections(em);
		return p;
	}
	
	public static List<Person> getAll() {
		System.out.println("--> Initializing Entity manager...");
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		System.out.println("--> Querying the database for all the people...");
	    List<Person> list = em.createNamedQuery("Person.findAll", Person.class).getResultList();
		System.out.println("--> Closing connections of entity manager...");
	    HealthProfileDao.instance.closeConnections(em);
	    return list;
	}

	/* Database TRANSACTIONS operations - CRUD*/
	public static Person savePerson(Person p) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(p);
		tx.commit();
	    HealthProfileDao.instance.closeConnections(em);
	    return p;
	}
	
	public static Person updatePerson(Person p) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		p=em.merge(p);
		tx.commit();
	    HealthProfileDao.instance.closeConnections(em);
	    return p;
	}
	
	public static void removePerson(Person p) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
	    p=em.merge(p);
	    em.remove(p);
	    tx.commit();
	    HealthProfileDao.instance.closeConnections(em);
	}
}