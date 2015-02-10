package introsde.finalproject.storage.soap;

import java.util.List;

import introsde.finalproject.soap.ExternalAPI;
import introsde.finalproject.soap.ExternalAPIService;
import introsde.finalproject.soap.Goal;
import introsde.finalproject.soap.GoalType;
import introsde.finalproject.soap.MeasureHistory;
import introsde.finalproject.soap.MeasureType;
import introsde.finalproject.soap.Person;
import introsde.finalproject.soap.People;
import introsde.finalproject.soap.PeopleService;
import introsde.finalproject.soap.Reminder;
import javax.jws.WebService;



//Service Implementation

@WebService(endpointInterface = "introsde.finalproject.storage.soap.Storage",
    serviceName="StorageService")
public class StorageImpl implements Storage {

	/**** PERSON ********/
		
	@Override
    public Person registerPerson(Person p)
    {
		PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();
        
        Person newPersonCreated = people.createPerson(p);
        
        if (newPersonCreated!=null)
        {
        	System.out.println("ID:"+ newPersonCreated.getIdPerson());
           	System.out.println("Full Name: "+newPersonCreated.getFirstname()+" "+newPersonCreated.getLastname());
           	System.out.println("BirthDate: "+newPersonCreated.getBirthdate());
           	System.out.println("Email: "+newPersonCreated.getEmail());
           	System.out.println("Username: "+newPersonCreated.getUsername());
           	System.out.println("Password: "+newPersonCreated.getPassword());
            }
		return newPersonCreated;
    }
	
	@Override
    public Person readPersonInfo(Long id){
		PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();
        
        Person p = people.readPerson(id);
        if (p!=null)
        {
        	System.out.println("ID:"+ p.getIdPerson());
           	System.out.println("Full Name: "+p.getFirstname()+" "+p.getLastname());
           	System.out.println("BirthDate: "+p.getBirthdate());
           	System.out.println("Email: "+p.getEmail());
           	System.out.println("Username: "+p.getUsername());
           	System.out.println("Password: "+p.getPassword());
         }
        
        return p;   
	}
	
	/**** PERSON-MEASUREMENT ********/
	@Override
    public MeasureHistory registerPersonMeasurement(Long id, String measure, MeasureHistory m){
		PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();
        
        MeasureHistory newMHCreated = people.createPersonMeasurement(id, measure, m);
        
        if (newMHCreated!=null)
        {
        	System.out.println("MID:"+ newMHCreated.getMid());
           	System.out.println("MeasureType: "+newMHCreated.getMeasureType().getMeasure());
           	System.out.println("Value: "+newMHCreated.getMeasureValue());
           	System.out.println("Date Registered: "+newMHCreated.getDateRegistered());
        }
		return newMHCreated;
     	
	}
	
	@Override
    public MeasureHistory readPersonMeasurement(Long id,String measure, Long mid){
		PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();
        
        MeasureHistory m = people.readPersonMeasurement(id, measure, mid);
        if (m!=null)
        {
        	System.out.println("MID:"+ m.getMid());
           	System.out.println("MeasureType: "+m.getMeasureType().getMeasure());
           	System.out.println("Value: "+m.getMeasureValue());
           	System.out.println("Date Registered: "+m.getDateRegistered());
         }
        
        return m;   
	}
	
	@Override
    public MeasureHistory readPersonMeasurementByDate(Long id,String measure, String date){
		PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();
        
        MeasureHistory m = people.readPersonMeasurementByDate(id, measure, date);
        if (m!=null)
        {
        	System.out.println("MID:"+ m.getMid());
           	System.out.println("MeasureType: "+m.getMeasureType().getMeasure());
           	System.out.println("Value: "+m.getMeasureValue());
           	System.out.println("Date Registered: "+m.getDateRegistered());
         }
        
        return m;   
	}
	
	
	@Override
    public MeasureHistory editPersonMeasurement(Long id, String measure, MeasureHistory mh){
		PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();
        
        MeasureHistory m = people.updatePersonMeasurement(id,measure,mh);
        if (m!=null)
        {
        	System.out.println("MID:"+ m.getMid());
           	System.out.println("MeasureType: "+m.getMeasureType().getMeasure());
           	System.out.println("Value: "+m.getMeasureValue());
           	System.out.println("Date Registered: "+m.getDateRegistered());
         }
        
        return m;   
	}
	
	@Override
    public int removePersonMeasurement(Long mid){
		PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();
        
        int res = people.deletePersonMeasurement(mid);
        
        return res;   
	}
	
	@Override
    public List<MeasureHistory> readPersonMeasureHistory(Long id, String measure){
		PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();
	        
        return people.readPersonMeasureHistory(id, measure);
	}

	/**** PERSON-GOALS ********/
	
	@Override
	public Goal registerPersonGoal(Long id, String measure, String type, Goal g){
		PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();
        
        Goal newGoalCreated = people.createPersonGoal(id, measure, type, g);
        
        if (newGoalCreated!=null)
        {
        	System.out.println("	GID:"+ newGoalCreated.getIdGoal());
         	GoalType t = newGoalCreated.getGoalType();
         	System.out.println("	Date Registerd:"+ newGoalCreated.getDateRegistered());
         	System.out.println("	Measure Type:"+ t.getMeasureType().getMeasure());
         	System.out.println("	Description:"+ t.getDescription());
         	System.out.println("	Goal Type:"+ t.getType());
         	System.out.println("	Goal Value:"+ newGoalCreated.getGoalValue());
        }
		return newGoalCreated;
     	
	}
	
	@Override
    public Goal readPersonGoal(Long id,Long gid){
		PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();
        
        Goal g = people.readPersonGoal(id,gid);
        if (g!=null)
        {
        	System.out.println("	GID:"+ g.getIdGoal());
         	GoalType t = g.getGoalType();
         	System.out.println("	Date Registerd:"+ g.getDateRegistered());
         	System.out.println("	Measure Type:"+ t.getMeasureType().getMeasure());
         	System.out.println("	Description:"+ t.getDescription());
         	System.out.println("	Goal Type:"+ t.getType());
         	System.out.println("	Goal Value:"+ g.getGoalValue());
         }
        
        return g;   	
	}

	@Override
    public Goal editPersonGoal(Long id, String measure, String type,Goal g){
		PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();
        
        Goal updated = people.updatePersonGoal(id,measure, type,g);
        if (updated!=null)
        {
        	System.out.println("GID:"+ updated.getGoalValue());
        }
        
        return updated;   
	}
	
	@Override
    public int removePersonGoal(Long gid){
		PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();
        
        int res = people.deletePersonGoal(gid);
        
        return res;   
	}
	
	@Override
    public List<Goal> readPersonGoalHistory(Long id){
		PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();
        
        return people.readPersonGoals(id);
		
	}
	
	/**** PERSON-REMINDERS ********/
	@Override
    public Reminder registerPersonReminder(Long id,Reminder r){
		PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();
        
        Reminder newReminderCreated = people.createPersonReminder(id, r);
        
        if (newReminderCreated!=null)
        {
        	System.out.println("	RID:"+ newReminderCreated.getIdReminder());
         	System.out.println("	Date Registerd:"+ newReminderCreated.getDateRegistered());
         	System.out.println("	Description:"+ newReminderCreated.getDescription());
         	System.out.println("	Type:"+ newReminderCreated.getTypeReminder());
         	System.out.println("	WDay:"+ newReminderCreated.getWDay());
         	System.out.println("	MDay:"+ newReminderCreated.getMDay());
         	System.out.println("	SDate:"+ newReminderCreated.getSDate());
        }
		return newReminderCreated;	
	}
	

	@Override
    public Reminder readPersonReminder(Long id, Long rid){
		PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();
        
        Reminder r = people.readPersonReminder(id, rid);
        if (r!=null)
        {
        	System.out.println("	RID:"+ r.getIdReminder());
         	System.out.println("	Date Registerd:"+ r.getDateRegistered());
         	System.out.println("	Description:"+ r.getDescription());
         	System.out.println("	Type:"+ r.getTypeReminder());
         	System.out.println("	WDay:"+ r.getWDay());
         	System.out.println("	MDay:"+ r.getMDay());
         	System.out.println("	SDate:"+ r.getSDate());
         }
        
        return r;
	}
	

	@Override
    public Reminder editPersonReminder(Long id,Reminder r){
		PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();
        
        Reminder updated = people.updatePersonReminder(id,r);
        if (updated!=null)
        {
        	System.out.println("GID:"+ updated.getIdReminder());
        }
        
        return updated;   
	}
	
	@Override
    public int removePersonReminder(Long rid){
		PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();
        
        int res = people.deletePersonReminder(rid);
        
        return res;   
	}
	
	@Override
    public List<Reminder> readPersonReminders(Long id){
		PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();
        
        return people.readPersonReminders(id);
	}
	

	@Override
    public List<Reminder> readPersonRemindersByDate(Long id,String date){
		PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();
        
        return people.readPersonRemindersByDate(id,date);
	}
	
	
	/**** MEASURETYPE ***/
	@Override
    public List<String> readMeasureTypes(){
		PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();
        
        return people.readMeasureTypes();
		
	}
	
	@Override
    public MeasureType readMeasureType(String measure){
		PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();
        
        MeasureType m = people.readMeasureType(measure);
        if (m!=null)
        {
        	System.out.println("	ID:"+ m.getIdMeasureType());
         	System.out.println("	MeasureType:"+m.getMeasure());
        }
        
        return m;
	}
	
	/**** GOALTYPE ***/
	@Override
    public List<GoalType> readGoalTypes(){
		PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();
        
        return people.readGoalTypes();	
	}
	
	
	/**** EXTERNAL API***/
	@Override
	public int sendPersonEmail(String email, String subject, String content)
	{
		ExternalAPIService service = new ExternalAPIService();
		ExternalAPI ex = service.getExternalAPIImplPort();
        
        return ex.sendEmail(email, subject, content);	
       
     }
	
	@Override
	public String getRandomQuote()
	{
		ExternalAPIService service = new ExternalAPIService();
		ExternalAPI ex = service.getExternalAPIImplPort();
        
        return ex.getRandomQuote();	
       
     }
}