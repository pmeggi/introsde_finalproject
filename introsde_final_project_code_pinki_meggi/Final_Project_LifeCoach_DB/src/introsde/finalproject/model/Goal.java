package introsde.finalproject.model;

import introsde.finalproject.dao.HealthProfileDao;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import java.util.List;


/**
 * The persistent class for the "Goal" database table.
 * 
 */

@Entity
@Table(name="\"Goal\"")
@NamedQueries({
	@NamedQuery(name="Goal.findAll", query="SELECT g FROM Goal g"),
	@NamedQuery(name="PersonGoal.findAll", query="Select g FROM Goal g where g.goalPerson.idPerson= :idPerson"),
	@NamedQuery(name="PersonGoal.removeAll", query="DELETE FROM Goal g where g.goalPerson.idPerson= :idPerson"),
	@NamedQuery(name="GoalTypeGoal.removeAll", query="DELETE FROM Goal g where g.goalType.idGoalType= :idGoalType"),
	@NamedQuery(name="MeasureTypeGoal.removeAll", query="DELETE FROM Goal g where g.goalType.measureType.idMeasureType= :id"),
	@NamedQuery(name="PersonGoal.findByGoalId", query="SELECT g FROM Goal g where g.idGoal= :idGoal and g.goalPerson.idPerson= :idPerson")
})
@XmlType(propOrder = { "idGoal" ,"goalValue", "status", "dateRegistered", "goalType"})
public class Goal implements Serializable {
	private static final long serialVersionUID = 1L;

	// For sqlite in particular, you need to use the following @GeneratedValue annotation
	// This holds also for the other tables
	// SQLITE implements auto increment ids through named sequences that are stored in a 
	// special table named "sqlite_sequence"
	@GeneratedValue(generator="sqlite_goal")
	@TableGenerator(name="sqlite_goal", table="sqlite_sequence",
	pkColumnName="name", valueColumnName="seq",
	pkColumnValue="Goal")
	@Column(name="idGoal")
	@Id
	private Long idGoal;

	@Column(name="goalValue")
	private String goalValue;
	
	@Column(name="status")
	private String status;
	
	@Column(name="date")
	private String dateRegistered;
	
	@ManyToOne
	@JoinColumn(name = "idPerson", referencedColumnName = "idPerson")
	private Person goalPerson;
	
	@ManyToOne
	@JoinColumn(name = "idGoalType", referencedColumnName = "idGoalType")
	private GoalType goalType;
	
	public Goal() {
	}
	
	@XmlElement
	public Long getIdGoal() {
		return this.idGoal;
	}

	public void setIdGoal(Long idGoal) {
		this.idGoal = idGoal;
	}

	@XmlElement
	public String getGoalValue() {
		return this.goalValue;
	}

	public void setGoalValue(String goalValue) {
		this.goalValue = goalValue;
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
	public Person getGoalPerson() {
	    return goalPerson;
	}

	public void setGoalPerson(Person p) {
	    this.goalPerson = p;
	}
	
	
	@XmlElement
	public GoalType getGoalType() {
	    return goalType;
	}

	public void setGoalType(GoalType g) {
	    this.goalType = g;
	}
	
	/* Database QUERY Operations */
	public static Goal getGoalById(Long goalId) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		Goal g = em.find(Goal.class, goalId);
		HealthProfileDao.instance.closeConnections(em);
		return g;
	}
	
	public static List<Goal> getAll() {
		System.out.println("--> Initializing Entity manager...");
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		System.out.println("--> Querying the database for all the goals...");
	    List<Goal> list = em.createNamedQuery("Goal.findAll", Goal.class).getResultList();
		System.out.println("--> Closing connections of entity manager...");
	    HealthProfileDao.instance.closeConnections(em);
	    return list;
	}

	public static List<Goal> getPersonAllGoals(Long id) {
		System.out.println("--> Initializing Entity manager...");
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		System.out.println("--> Querying the database for all the person goals...");
	    List<Goal> list = em.createNamedQuery("PersonGoal.findAll", Goal.class).setParameter("idPerson",id).getResultList();
		System.out.println("--> Closing connections of entity manager...");
	    HealthProfileDao.instance.closeConnections(em);
	    return list;
	}
	public static Goal getPersonGoalById(Long personId, Long goalId) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		System.out.println(" Querying GOAL with GID="+goalId+" for Person="+personId);
		List<Goal> list = em.createNamedQuery("PersonGoal.findByGoalId", Goal.class)
				.setParameter("idPerson", personId)
				.setParameter("idGoal", goalId)
				.getResultList();
		HealthProfileDao.instance.closeConnections(em);
		if (list.size()>0)
			return list.get(0);
		return null;
	}
	/* Database TRANSACTIONS operations - CRUD*/
	public static Goal saveGoal(Goal g) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(g);
		tx.commit();
	    HealthProfileDao.instance.closeConnections(em);
	    return g;
	}
	
	public static Goal updateGoal(Goal g) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		g=em.merge(g);
		tx.commit();
	    HealthProfileDao.instance.closeConnections(em);
	    return g;
	}
	
	public static void removeGoal(Goal g) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
	    g=em.merge(g);
	    em.remove(g);
	    tx.commit();
	    HealthProfileDao.instance.closeConnections(em);
	}

	public static void removeAllPersonGoal(Long personId) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		System.out.println("Deleting Person Goals: "+personId);
		em.getTransaction().begin();
		int deletedCount=em.createNamedQuery("PersonGoal.removeAll", Goal.class).setParameter("idPerson", personId).executeUpdate();
		em.getTransaction().commit();
		System.out.println("Deleted Goal records:"+deletedCount);
		HealthProfileDao.instance.closeConnections(em);
	}
	
	public static void removeAllMeasureTypeGoal(int id) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		System.out.println("Deleting Measure Type Goals: "+id);
		em.getTransaction().begin();
		int deletedCount=em.createNamedQuery("MeasureTypeGoal.removeAll", Goal.class).setParameter("id", id).executeUpdate();
		em.getTransaction().commit();
		System.out.println("Deleted Goal records:"+deletedCount);
		HealthProfileDao.instance.closeConnections(em);
	}
	
	public static void removeAllGoalTypeGoal(Long id) {
		EntityManager em = HealthProfileDao.instance.createEntityManager();
		System.out.println("Deleting GoalTType Goals: "+ id);
		em.getTransaction().begin();
		int deletedCount=em.createNamedQuery("GoalTypeGoal.removeAll", Goal.class).setParameter("idGoalType", id).executeUpdate();
		em.getTransaction().commit();
		System.out.println("Deleted Goal records:"+deletedCount);
		HealthProfileDao.instance.closeConnections(em);
	}
	
	
}