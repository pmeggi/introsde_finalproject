package introsde.finalproject.model;

import introsde.finalproject.dao.HealthProfileDao;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import java.util.List;


/**
 * The persistent class for the "GoalType" database table.
 * 
 */

@Entity
@Table(name="\"GoalType\"")
@NamedQueries({
	@NamedQuery(name="GoalType.findAll", query="SELECT g FROM GoalType g"),
	@NamedQuery(name="GoalType.findByMeasureName", query="SELECT g FROM GoalType g where g.measureType.measureType= :measure"),
	@NamedQuery(name="GoalType.findByTypeMeasureName", query="SELECT g FROM GoalType g where g.type= :type and g.measureType.measureType= :measure"),	
	@NamedQuery(name="MeasureTypeGoalType.removeAll", query="DELETE FROM GoalType g where g.measureType.idMeasureType= :id")
})
@XmlType(propOrder = { "idGoalType" ,"description", "type", "valueType", "measureType"})
public class GoalType implements Serializable {
	private static final long serialVersionUID = 1L;

	// For sqlite in particular, you need to use the following @GeneratedValue annotation
	// This holds also for the other tables
	// SQLITE implements auto increment ids through named sequences that are stored in a 
	// special table named "sqlite_sequence"
	@GeneratedValue(generator="sqlite_goalType")
	@TableGenerator(name="sqlite_goalType", table="sqlite_sequence",
	pkColumnName="name", valueColumnName="seq",
	pkColumnValue="GoalType")
	@Column(name="idGoalType")
	@Id
	private Long idGoalType;

	@Column(name="description")
	private String description;
	
	@Column(name="type")
	private String type; //by default weekly, daily, monthly goals

	@Column(name="valueType")
	private String valueType; //by default minimum and maximum defined in DB
	
	@ManyToOne
	@JoinColumn(name = "idMeasureType", referencedColumnName = "idMeasureType")
	private MeasureType measureType;
	
	public GoalType() {
	}
	
	@XmlElement
	public Long getIdGoalType() {
		return this.idGoalType;
	}

	public void setIdGoalType(Long idGoalType) {
		this.idGoalType = idGoalType;
	}

	@XmlElement
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@XmlElement
	public String getValueType() {
		return this.valueType;
	}

	public void setValyeType(String vtype) {
		this.valueType = vtype;
	}
	
		
	@XmlElement
	public MeasureType getMeasureType() {
	    return measureType;
	}

	public void setMeasureType(MeasureType m) {
	    this.measureType = m;
	}
	
	/* Database QUERY Operations */
	public static GoalType getGoalTypeById(Long goalTypeId) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		GoalType g = em.find(GoalType.class, goalTypeId);
		HealthProfileDao.instance.closeConnections(em);
		return g;
	}
	
	public static List<GoalType> getAll() {
		System.out.println("--> Initializing Entity manager...");
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		System.out.println("--> Querying the database for all the goals...");
	    List<GoalType> list = em.createNamedQuery("GoalType.findAll", GoalType.class).getResultList();
		System.out.println("--> Closing connections of entity manager...");
	    HealthProfileDao.instance.closeConnections(em);
	    return list;
	}

	public static List<GoalType> getGoalTypeByMeasureName(String measure) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
	    List<GoalType> list = em.createNamedQuery("GoalType.findByMeasureName", GoalType.class).setParameter("measure",measure).getResultList();
	    HealthProfileDao.instance.closeConnections(em);
		return list;
	}
	
	public static GoalType getGoalTypeByTypeMeasureName(String type, String measure) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		GoalType m = em.createNamedQuery("GoalType.findByTypeMeasureName", GoalType.class).setParameter("type",type).setParameter("measure",measure).getSingleResult();
	    HealthProfileDao.instance.closeConnections(em);
	    return m;
	}
	
	/* Database TRANSACTIONS operations - CRUD*/
	public static GoalType saveGoalType(GoalType g) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(g);
		tx.commit();
	    HealthProfileDao.instance.closeConnections(em);
	    return g;
	}
	
	public static GoalType updateGoalType(GoalType g) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		g=em.merge(g);
		tx.commit();
	    HealthProfileDao.instance.closeConnections(em);
	    return g;
	}
	
	public static void removeGoalType(GoalType g) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
	    g=em.merge(g);
	    em.remove(g);
	    tx.commit();
	    HealthProfileDao.instance.closeConnections(em);
	}

	public static void removeAllMeasureTypeGoalType(int id) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		System.out.println("Deleting Measure Type Goal Types: "+id);
		em.getTransaction().begin();
		int deletedCount=em.createNamedQuery("MeasureTypeGoalType.removeAll", GoalType.class).setParameter("id", id).executeUpdate();
		em.getTransaction().commit();
		System.out.println("Deleted GoalType records:"+deletedCount);
		HealthProfileDao.instance.closeConnections(em);
	}
}