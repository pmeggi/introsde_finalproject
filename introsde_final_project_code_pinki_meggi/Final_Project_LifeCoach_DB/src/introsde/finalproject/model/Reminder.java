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
@Table(name="\"Reminder\"")
@NamedQueries({
	@NamedQuery(name="Reminder.findAll", query="SELECT r FROM Reminder r"),
	@NamedQuery(name="PersonReminder.findAll", query="Select r FROM Reminder r where r.person.idPerson= :idPerson"),
	@NamedQuery(name="PersonReminder.removeAll", query="DELETE FROM Reminder r where r.person.idPerson= :idPerson"),
	@NamedQuery(name="PersonReminder.findByReminderId", query="SELECT r FROM Reminder r where r.idReminder= :idReminder and r.person.idPerson= :idPerson"),
	@NamedQuery(name="PersonReminder.findByReminderDate", query="SELECT r FROM Reminder r where r.sDate= :date and r.person.idPerson= :idPerson")	
})
@XmlType(propOrder = { "idReminder" ,"description", "typeReminder", "WDay","MDay","SDate", "status","dateRegistered"})
public class Reminder implements Serializable {
	private static final long serialVersionUID = 1L;

	// For sqlite in particular, you need to use the following @GeneratedValue annotation
	// This holds also for the other tables
	// SQLITE implements auto increment ids through named sequences that are stored in a 
	// special table named "sqlite_sequence"
	@GeneratedValue(generator="sqlite_reminder")
	@TableGenerator(name="sqlite_reminder", table="sqlite_sequence",
	pkColumnName="name", valueColumnName="seq",
	pkColumnValue="Reminder")
	@Column(name="idReminder")
	@Id
	private Long idReminder;

	@Column(name="description")
	private String description;
	
	@Column(name="typeReminder")
	private String typeReminder;

	@Column(name="wDay")
	private String wDay;

	@Column(name="mDay")
	private String mDay;

	@Column(name="sDate")
	private String sDate;

	@Column(name="status")
	private String status;
	
	@Column(name="date")
	private String dateRegistered;
	
	@ManyToOne
	@JoinColumn(name = "idPerson", referencedColumnName = "idPerson")
	private Person person;
	
	public Reminder() {
	}
	
	@XmlElement
	public Long getIdReminder() {
		return this.idReminder;
	}

	public void setIdReminder(Long idReminder) {
		this.idReminder = idReminder;
	}

	@XmlElement
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement
	public String getTypeReminder() {
		return this.typeReminder;
	}

	public void setTypeReminder(String typeReminder) {
		this.typeReminder = typeReminder;
	}

	@XmlElement
	public String getWDay() {
		return this.wDay;
	}

	public void setWDay(String wDay) {
		this.wDay = wDay;
	}

	@XmlElement
	public String getMDay() {
		return this.mDay;
	}

	public void setMDay(String mDay) {
		this.mDay = mDay;
	}

	@XmlElement
	public String getSDate() {
		return this.sDate;
	}
	
	public void setSDate(String sDate) {
		this.sDate = sDate;
	}
	
	@XmlElement
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@XmlElement
	public String getDateRegistered() {
		return this.dateRegistered;
	}

	public void setDateRegistered(String date) {
		this.dateRegistered = date;
	}
	
	@XmlTransient
	public Person getPerson() {
	    return person;
	}

	public void setPerson(Person p) {
	    this.person = p;
	}
	
	
	/* Database QUERY Operations */
	public static Reminder getReminderById(Long reminderId) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		Reminder p = em.find(Reminder.class, reminderId);
		HealthProfileDao.instance.closeConnections(em);
		return p;
	}
	
	public static Reminder getPersonReminderById(Long personId, Long rId) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		System.out.println(" Querying REMINDER with RID="+rId+" for Person="+personId);
		List<Reminder> list = em.createNamedQuery("PersonReminder.findByReminderId", Reminder.class)
				.setParameter("idPerson", personId)
				.setParameter("idReminder", rId)
				.getResultList();
		HealthProfileDao.instance.closeConnections(em);
		if (list.size()>0)
			return list.get(0);
		return null;
	}
	
	public static List<Reminder> getAll() {
		System.out.println("--> Initializing Entity manager...");
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		System.out.println("--> Querying the database for all the reminders...");
	    List<Reminder> list = em.createNamedQuery("Reminder.findAll", Reminder.class).getResultList();
		System.out.println("--> Closing connections of entity manager...");
	    HealthProfileDao.instance.closeConnections(em);
	    return list;
	}
	
	public static List<Reminder> getPersonAllReminders(Long id) {
		System.out.println("--> Initializing Entity manager...");
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		System.out.println("--> Querying the database for all the person goals...");
	    List<Reminder> list = em.createNamedQuery("PersonReminder.findAll", Reminder.class).setParameter("idPerson",id).getResultList();
		System.out.println("--> Closing connections of entity manager...");
	    HealthProfileDao.instance.closeConnections(em);
	    return list;
	}

	public static List<Reminder> getPersonAllRemindersByDate(Long id,String date) {
		System.out.println("--> Initializing Entity manager...");
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		System.out.println("--> Querying the database for all the person goals...");
	    List<Reminder> list = em.createNamedQuery("PersonReminder.findByReminderDate", Reminder.class).setParameter("idPerson",id).setParameter("date",date).getResultList();
		System.out.println("--> Closing connections of entity manager...");
	    HealthProfileDao.instance.closeConnections(em);
	    return list;
	}
	
	/* Database TRANSACTIONS operations - CRUD*/
	public static Reminder saveReminder(Reminder r) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(r);
		tx.commit();
	    HealthProfileDao.instance.closeConnections(em);
	    return r;
	}
	
	public static Reminder updateReminder(Reminder r) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		r=em.merge(r);
		tx.commit();
	    HealthProfileDao.instance.closeConnections(em);
	    return r;
	}
	
	public static void removeReminder(Reminder r) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
	    r=em.merge(r);
	    em.remove(r);
	    tx.commit();
	    HealthProfileDao.instance.closeConnections(em);
	}
	
	public static void removeAllPersonReminder(Long personId) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		System.out.println("Deleting Person Reminders: "+personId);
		em.getTransaction().begin();
		int deletedCount=em.createNamedQuery("PersonReminder.removeAll", Reminder.class).setParameter("idPerson", personId).executeUpdate();
		em.getTransaction().commit();
		System.out.println("Deleted Reminders records:"+deletedCount);
		HealthProfileDao.instance.closeConnections(em);
	}
	
	
	
}