package introsde.finalproject.model;

import introsde.finalproject.dao.HealthProfileDao;

import introsde.finalproject.model.MeasureType;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


/**
 * The persistent class for the "MeasureHistory" database table.
 * 
 */

@Entity
@Table(name="MeasureHistory")
@NamedQueries({
	@NamedQuery(name="MeasureHistory.findAll", query="SELECT h FROM MeasureHistory h"),
	@NamedQuery(name="PersonMeasureHistory.findByMeasure", query="SELECT h FROM MeasureHistory h where h.measureType.idMeasureType= :idMeasureType and h.person.idPerson= :idPerson"),
	@NamedQuery(name="PersonMeasureHistory.removeAll", query="DELETE FROM MeasureHistory h where h.person.idPerson= :idPerson"),
	@NamedQuery(name="MeasureTypeHistory.removeAll", query="DELETE FROM MeasureHistory h where h.measureType.idMeasureType= :id"),
	@NamedQuery(name="PersonMeasureHistory.findBetweenDates", query="SELECT h FROM MeasureHistory h where h.measureType.idMeasureType= :idMeasureType and h.person.idPerson= :idPerson and substring(h.dateRegistered,1,10)>= :beforeDate and substring(h.dateRegistered,1,10)<= :afterDate "),
	@NamedQuery(name="PersonMeasure.findByMeasureId", query="SELECT h FROM MeasureHistory h where h.mid= :idMeasure and h.measureType.idMeasureType= :idMeasureType and h.person.idPerson= :idPerson"),
	@NamedQuery(name="PersonMeasure.findByMeasureDate", query="SELECT h FROM MeasureHistory h where h.measureType.idMeasureType= :idMeasureType and h.person.idPerson= :idPerson and h.dateRegistered= :date")
	})
@XmlRootElement(name="measure")
@XmlType(propOrder = { "mid","dateRegistered", "measureType", "measureValue"})
public class MeasureHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="sqlite_measurehistory")
	@TableGenerator(name="sqlite_measurehistory", table="sqlite_sequence",
	    pkColumnName="name", valueColumnName="seq",
	    pkColumnValue="MeasureHistory")
	@Column(name="idMeasureHistory")
	private Long mid;

	//@Temporal(TemporalType.DATE)
	@Column(name="date")
	private String dateRegistered;

	@Column(name="value")
	private String measureValue;

	@ManyToOne
	@JoinColumn(name = "idPerson", referencedColumnName = "idPerson")
	private Person person;
	
	@ManyToOne
	@JoinColumn(name = "idMeasureType", referencedColumnName = "idMeasureType")
	private MeasureType measureType;
	
	public MeasureHistory() {
	}

	@XmlElement
	public Long getMid() {
		return this.mid;
	}

	public void setMid(Long idMeasure) {
		this.mid = idMeasure;
	}

	@XmlElement
	public String getDateRegistered() {
		return this.dateRegistered;
	}

	public void setDateRegistered(String date) {
		this.dateRegistered = date;
	}

	@XmlElement
	public String getMeasureValue() {
		return this.measureValue;
	}

	public void setMeasureValue(String value) {
		this.measureValue = value;
	}

	@XmlElement
	public MeasureType getMeasureType() {
	    return measureType;
	}

	public void setMeasureType(MeasureType param) {
	    this.measureType = param;
	}

	@XmlTransient
	public Person getPerson() {
	    return person;
	}

	public void setPerson(Person person) {
	    this.person = person;
	}
	
	/* Database QUERY operations */
	public static MeasureHistory getMeasureHistoryById(Long id) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		MeasureHistory p = em.find(MeasureHistory.class, id);
		HealthProfileDao.instance.closeConnections(em);
		return p;
	}
	
	public static List<MeasureHistory> getPersonMeasureHistory(Long personId, int measureTypeId) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		System.out.println(" Querying Measure History of Measure="+measureTypeId+" for Person="+personId);
		List<MeasureHistory> list = em.createNamedQuery("PersonMeasureHistory.findByMeasure", MeasureHistory.class)
									.setParameter("idPerson", personId)
									.setParameter("idMeasureType", measureTypeId)
									.getResultList();
		System.out.println(" Have found QT="+list.size());
	    HealthProfileDao.instance.closeConnections(em);
		return list;
	}
	
	public static MeasureHistory getPersonMeasureById(Long personId, int measureTypeId, Long measureId) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		System.out.println(" Querying Measure with MID="+measureId+" of Measure="+measureTypeId+" for Person="+personId);
		List<MeasureHistory> list = em.createNamedQuery("PersonMeasure.findByMeasureId", MeasureHistory.class)
				.setParameter("idPerson", personId)
				.setParameter("idMeasureType", measureTypeId)
				.setParameter("idMeasure", measureId)
				.getResultList();
		HealthProfileDao.instance.closeConnections(em);
		if (list.size()>0)
			return list.get(0);
		return null;
	}
	
	public static MeasureHistory getPersonMeasureByDate(Long personId, int measureTypeId, String date) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		System.out.println(" Querying Measure with Date="+date+" of Measure="+measureTypeId+" for Person="+personId);
		List<MeasureHistory> list = em.createNamedQuery("PersonMeasure.findByMeasureDate", MeasureHistory.class)
				.setParameter("idPerson", personId)
				.setParameter("idMeasureType", measureTypeId)
				.setParameter("date", date)
				.getResultList();
		HealthProfileDao.instance.closeConnections(em);
		if (list.size()>0)
			return list.get(0);
		return null;
	}
	
	
	public static List<MeasureHistory> getPersonMeasureHistoryBetweenDate(Long personId, int measureTypeId, String beforeDate, String afterDate) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		System.out.println("Querying Measure History ("+measureTypeId+") between "+beforeDate+" and "+afterDate+" of Person with ID=" + personId);
		List<MeasureHistory> list = em.createNamedQuery("PersonMeasureHistory.findBetweenDates", MeasureHistory.class)
						.setParameter("idPerson", personId)
						.setParameter("idMeasureType", measureTypeId)
						.setParameter("beforeDate", beforeDate)
						.setParameter("afterDate", afterDate)
						.getResultList();
		System.out.println(" Have found QT="+list.size());
	    HealthProfileDao.instance.closeConnections(em);
		return list;
	}
		
	public static void removeAllPersonMeasureHistory(Long personId) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		System.out.println("Deleting Person Measure History: "+personId);
		em.getTransaction().begin();
		int deletedCount=em.createNamedQuery("PersonMeasureHistory.removeAll", MeasureHistory.class).setParameter("idPerson", personId).executeUpdate();
		em.getTransaction().commit();
		System.out.println("Deleted MeasureHistory records:"+deletedCount);
		HealthProfileDao.instance.closeConnections(em);
	}
	
	public static void removeAllMeasureTypeHistory(int id) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		System.out.println("Deleting Measure Type Measure History: "+id);
		em.getTransaction().begin();
		int deletedCount=em.createNamedQuery("MeasureTypeHistory.removeAll", MeasureHistory.class).setParameter("id", id).executeUpdate();
		em.getTransaction().commit();
		System.out.println("Deleted MeasureHistory records:"+deletedCount);
		HealthProfileDao.instance.closeConnections(em);
	}
	
	public static List<MeasureHistory> getAll() {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
	    List<MeasureHistory> list = em.createNamedQuery("MeasureHistory.findAll", MeasureHistory.class).getResultList();
	    HealthProfileDao.instance.closeConnections(em);
	    return list;
	}
	
	
	/* Database TRANSACTIONS operations - CRUD*/
	public static MeasureHistory saveMeasureHistory(MeasureHistory p) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(p);
		tx.commit();
		HealthProfileDao.instance.closeConnections(em);
	    return p;
	}
	
	public static MeasureHistory updateMeasureHistory(MeasureHistory p) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		p=em.merge(p);
		tx.commit();
		HealthProfileDao.instance.closeConnections(em);
	    return p;
	}
	
	public static void removeMeasureHistory(MeasureHistory p) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
	    p=em.merge(p);
	    em.remove(p);
	    tx.commit();
	    HealthProfileDao.instance.closeConnections(em);
	}

}
