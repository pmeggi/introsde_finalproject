package introsde.finalproject.model;

import introsde.finalproject.dao.HealthProfileDao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the "MeasureType" database table.
 * 
 */
@Entity
@Table(name="MeasureType")
@NamedQueries({
@NamedQuery(name="MeasureType.findAll", query="SELECT m FROM MeasureType m"),
@NamedQuery(name="MeasureType.findByName", query="SELECT m FROM MeasureType m where m.measureType= :measure"),
})
public class MeasureType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="sqlite_measuretype")
	@TableGenerator(name="sqlite_measuretype", table="sqlite_sequence",
	    pkColumnName="name", valueColumnName="seq",
	    pkColumnValue="MeasureType")
	@Column(name="idMeasureType")
	private int idMeasureType;

	@Column(name="measureType")
	private String measureType;
	
	@OneToMany(mappedBy="measureType")
	private List<MeasureHistory> measureHistories;
	
	@OneToMany(mappedBy="measureType")
	private List<GoalType> goalTypes;

	public MeasureType() {
	}

	@XmlElement
	public int getIdMeasureType() {
		return this.idMeasureType;
	}

	public void setIdMeasureType(int idMeasureType) {
		this.idMeasureType = idMeasureType;
	}

	@XmlElement(name="measure")
	public String getMeasureType() {
		return this.measureType;
	}

	public void setMeasureType(String measureType) {
		this.measureType = measureType;
	}

	@XmlTransient
	public List<MeasureHistory> getMeasureHistories() {
		return this.measureHistories;
	}

	public void setMeasureHistories(List<MeasureHistory> measureHistories) {
		this.measureHistories = measureHistories;
	}
	
	@XmlTransient
	public List<GoalType> getMeasureGoalTypes() {
		return this.goalTypes;
	}

	public void setMeasureGoalTypes(List<GoalType> measureGoalTypes) {
		this.goalTypes = measureGoalTypes;
	}

	/* Database QUERY Operations*/
	public static MeasureType getMeasureTypeById(int measureTypeId) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		MeasureType p = em.find(MeasureType.class, measureTypeId);
		HealthProfileDao.instance.closeConnections(em);
		return p;
	}
	
	public static int getMeasureTypeIdByName(String measure) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		MeasureType m = em.createNamedQuery("MeasureType.findByName", MeasureType.class).setParameter("measure",measure).getSingleResult();
	    HealthProfileDao.instance.closeConnections(em);
	    if (m==null)
	    	return 0;
		return m.getIdMeasureType();
	}
	
	public static MeasureType getMeasureTypeByName(String measure) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		MeasureType m = em.createNamedQuery("MeasureType.findByName", MeasureType.class).setParameter("measure",measure).getSingleResult();
	    HealthProfileDao.instance.closeConnections(em);
		return m;
	}
		
	public static List<MeasureType> getAll() {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
	    List<MeasureType> list = em.createNamedQuery("MeasureType.findAll", MeasureType.class).getResultList();
	    HealthProfileDao.instance.closeConnections(em);
	    return list;
	}
	
	/* Database TRANSACTIONS operations - CRUD*/
	
	public static MeasureType saveMeasureType(MeasureType p) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(p);
		tx.commit();
	    HealthProfileDao.instance.closeConnections(em);
	    return p;
	}
	
	public static MeasureType updateMeasureType(MeasureType p) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		p=em.merge(p);
		tx.commit();
	    HealthProfileDao.instance.closeConnections(em);
	    return p;
	}
	
	public static void removeMeasureType(MeasureType p) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
	    p=em.merge(p);
	    em.remove(p);
	    tx.commit();
	    HealthProfileDao.instance.closeConnections(em);
	}
}
