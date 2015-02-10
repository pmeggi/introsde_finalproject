package introsde.finalproject.soap;

import introsde.finalproject.model.Goal;
import introsde.finalproject.model.GoalType;
import introsde.finalproject.model.Person;
import introsde.finalproject.model.MeasureHistory;
import introsde.finalproject.model.MeasureType;
import introsde.finalproject.model.Reminder;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;


//Service Implementation

@WebService(endpointInterface = "introsde.finalproject.soap.People",
    serviceName="PeopleService")
public class PeopleImpl implements People {

	
/**** 1- PERSON ***/
	@Override
    public Person createPerson(Person person) {
        
    	System.out.println("Creating new person...");
    	Person savedPerson = new Person();
    	if (person==null){
        	System.out.println("Received null person");
        }
        else{
         	System.out.println(person.getFirstname()+" "+person.getLastname());           	
         	savedPerson =Person.savePerson(person);
        }
        return savedPerson;   
    }

	@Override
    public Person readPerson(Long id) {
        System.out.println("---> Reading Person by id = "+id);
        Person p = Person.getPersonById(id);
        if (p!=null) {
            System.out.println("---> Found Person by id = "+id+" => "+p.getFirstname());
        } else {
            System.out.println("---> Didn't find any Person with  id = "+id);
        }
        return p;
    }

    @Override
    public Person updatePerson(Person person) {
    	Person updatedPerson = new Person();
    	
    	if (person==null){
    		System.out.println("RECEIVED NULL PARAMETER");
    	}
    	else
    	{
    	Person existing = Person.getPersonById(person.getIdPerson());
    	
        if (existing != null) {
        	System.out.println("--> Existing Person... " +person.getFirstname()+ " "+ person.getLastname());
            updatedPerson = Person.updatePerson(person);
        }
    	}
        return updatedPerson;
    }

    @Override
	public int deletePerson(Long id) {
		if (id==null) return 0;
  		Person person = Person.getPersonById(id);
        if (person == null)
        {
            System.out.println("DELETE: Person with " + id + " not found");
            return 0;
        }
        else
        {
        	System.out.println("Deleting person... " + person.getIdPerson());
        	MeasureHistory.removeAllPersonMeasureHistory(id);
        	Goal.removeAllPersonGoal(id);
        	Reminder.removeAllPersonReminder(id);
            Person.removePerson(person);          
            return 1;
        }
	}
  	
  	@Override
	public List<Person> readPersonList() {
        return Person.getAll();
    }

  	@Override
	public List<MeasureHistory> readPersonMeasureHistory(Long id, String measure){
  		List<MeasureHistory> measureH= new ArrayList<MeasureHistory>();
    	int measureId = MeasureType.getMeasureTypeIdByName(measure);
		if (measureId==0){
			System.out.println("Get: Measure ("+measure+") not found");
		}
		else{	
			measureH = MeasureHistory.getPersonMeasureHistory(id, measureId);
            if (measureH == null){
            	System.out.println("Get: Measure History ("+measure+") of Person with ID=" + id + " not found");
    		}
    	}
    	return measureH;
    }

  	@Override
	public List<Goal> readPersonGoalHistory(Long id){
  		List<Goal> goals= new ArrayList<Goal>();
    	//Person p = Person.getPersonById(id);
    	goals = Goal.getPersonAllGoals(id);
    	if (goals == null){
            	System.out.println("Get: Goal History of Person with ID=" + id + " not found");
    		}
    	return goals;
	}
  	
  	@Override
	public List<Reminder> readPersonReminders(Long id){
  		List<Reminder> reminders= new ArrayList<Reminder>();
    	//Person p = Person.getPersonById(id);
    	reminders = Reminder.getPersonAllReminders(id);
    	if (reminders == null){
        	System.out.println("Get: Reminder History of Person with ID=" + id + " not found");
		}
    	return reminders;
  	}
  	
	@Override
	public List<Reminder> readPersonRemindersByDate(Long id,String date){
  		List<Reminder> reminders= new ArrayList<Reminder>();
    	//Person p = Person.getPersonById(id);
    	reminders = Reminder.getPersonAllRemindersByDate(id,date);
    	if (reminders == null){
        	System.out.println("Get: Reminder History of Person with ID=" + id + " not found");
		}
    	return reminders;
  	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  	
/**** 2- MEASURE TYPE ****/

  	@Override
    public MeasureType createMeasureType(MeasureType mType) {
        
    	System.out.println("Creating new measure type...");
    	MeasureType savedMType = new MeasureType();
    	if (mType==null){
        	System.out.println("Received null object");
        }
        else{
         	savedMType =MeasureType.saveMeasureType(mType);
        }
        return savedMType;   
    }

	@Override
    public MeasureType readMeasureType(String measure) {
        System.out.println("---> Reading Measure Type by name = "+measure);
        MeasureType m = MeasureType.getMeasureTypeByName(measure);
        if (m!=null) {
            System.out.println("---> Found MeasureType by => "+m.getIdMeasureType());
        } else {
            System.out.println("---> Didn't find any MeasureType with  name = "+measure);
        }
        return m;
    }

    @Override
    public MeasureType updateMeasureType(MeasureType mType) {
    	MeasureType updatedMType = new MeasureType();
    	
    	if (mType==null){
    		System.out.println("RECEIVED NULL PARAMETER");
    	}
    	else
    	{
    	MeasureType existing = MeasureType.getMeasureTypeById(updatedMType.getIdMeasureType());
    	
        if (existing != null) {
        	System.out.println("--> Existing MeasureType.. " + existing.getIdMeasureType());
            updatedMType = MeasureType.updateMeasureType(mType);
            }
    	}
        return updatedMType;
    }

    @Override
	public int deleteMeasureType(Long id) {
		if (id==null) return 0;
		MeasureType mType = MeasureType.getMeasureTypeById(Integer.parseInt(id.toString()));
	    if (mType == null)
        {
            System.out.println("DELETE: MeasureType with " + id + " not found");
            return 0;
        }
        else
        {
        	System.out.println("Deleting measure type.. " + mType.getMeasureType());
        	MeasureHistory.removeAllMeasureTypeHistory(Integer.parseInt(id.toString()));
        	Goal.removeAllMeasureTypeGoal(Integer.parseInt(id.toString()));
        	GoalType.removeAllMeasureTypeGoalType(Integer.parseInt(id.toString()));
        	MeasureType.removeMeasureType(mType);          
            return 1;
        }
	}

 	@Override
	public List<String> readMeasureTypes(){
  		System.out.println("Getting list of XML measure type...");
        List<MeasureType> list = MeasureType.getAll();
        List<String> measures = new ArrayList<String>();
  	    for(MeasureType m : list) {
 			    measures.add(m.getMeasureType());
 	    }
        return measures;
    }
 	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  	
 	/**** 3- PERSON MEASURE HISTORY ****/
      	
  	@Override
    public MeasureHistory createPersonMeasurement(Long id, String measure, MeasureHistory m) {
        
    	System.out.println("Creating new measurement for Person ID="+id);
    	MeasureHistory savedMeasure = new MeasureHistory();
    
    	if (m==null){
        	System.out.println("Received null MeasureHistory");
        }
        else{
        	Person p = Person.getPersonById(id);
        	MeasureType t = MeasureType.getMeasureTypeByName(measure);
        	savedMeasure.setPerson(p);
        	savedMeasure.setMeasureType(t);
        	savedMeasure.setDateRegistered(m.getDateRegistered());
        	savedMeasure.setMeasureValue(m.getMeasureValue());
        	System.out.println(savedMeasure.getMeasureType().getMeasureType()+"="+savedMeasure.getMeasureValue());           	
         	savedMeasure=MeasureHistory.saveMeasureHistory(savedMeasure);
        }
        return savedMeasure;   
    }

 	@Override
	public MeasureHistory readPersonMeasurement(Long id, String measure, Long mid){
  		
  		System.out.println("Reading Measure History ("+measure+") from DB for person with id: "+id+" with MID="+ mid);
  		MeasureHistory measureH = new MeasureHistory();
  		int idMeasureType = MeasureType.getMeasureTypeIdByName(measure);
        
        if (idMeasureType==0){
        	System.out.println("Get: Measure ("+measure+") not found");
    	}
        else
        {
        	measureH = MeasureHistory.getPersonMeasureById(id, idMeasureType, mid);
        
        	if (measureH == null){	
        		System.out.println("Get: Measure ("+measure+") with MID="+ mid +" of Person with ID=" + id + " not found");
        	}	
        	
        }
        return measureH;
    }
  	
	 @Override
	 public MeasureHistory updatePersonMeasurement(Long id, String measure, MeasureHistory mh) {
	  	if (mh==null){
	   		System.out.println("RECEIVED NULL PARAMETER");
	   	}
	   	else
	   	{
	   	    Person p = Person.getPersonById(id);
	        MeasureType t = MeasureType.getMeasureTypeByName(measure);
	        MeasureHistory existing = MeasureHistory.getMeasureHistoryById(mh.getMid());
	   	
	   		if (existing != null) {
	   			//System.out.println("--> Existing Person... " +person.getFirstname()+ " "+ person.getLastname());
	   			mh.setPerson(p);
	   			mh.setMeasureType(t);
	   			mh = MeasureHistory.updateMeasureHistory(mh);
	   		}
	   	}
	       return mh;
	 }

	@Override
	public int deletePersonMeasurement(Long mid) {
		if (mid==null) return 0;
		MeasureHistory mh = MeasureHistory.getMeasureHistoryById(mid);
		
	    if (mh == null)
        {
            System.out.println("DELETE: MeasureHistory with " + mid + " not found");
            return 0;
        }
        else
        {
        	System.out.println("Deleting measure history.. " + mh.getMid());
        	MeasureHistory.removeMeasureHistory(mh);         
            return 1;
        }
	}
	
	@Override
	public MeasureHistory readPersonMeasurementByDate(Long id, String measure, String date){
  		
  		System.out.println("Reading Measure History ("+measure+") from DB for person with id: "+id+" with date="+ date);
  		MeasureHistory measureH = new MeasureHistory();
  		int idMeasureType = MeasureType.getMeasureTypeIdByName(measure);
        
        if (idMeasureType==0){
        	System.out.println("Get: Measure ("+measure+") not found");
    	}
        else
        {
        	measureH = MeasureHistory.getPersonMeasureByDate(id, idMeasureType, date);
        
        	if (measureH == null){	
        		System.out.println("Get: Measure ("+measure+") with date="+ date +" of Person with ID=" + id + " not found");
        	}	
        	
        }
        return measureH;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  	
/**** 4- PERSON GOAL ****/
    
  	@Override
    public Goal createPersonGoal(Long id, String measure, String type, Goal g) {
        
    	System.out.println("Creating new goal for Person ID="+id);
    	
    	Goal savedGoal = new Goal();
    
    	if (g==null){
        	System.out.println("Received null Goal");
        }
        else{
        	Person p = Person.getPersonById(id);
        	GoalType t = GoalType.getGoalTypeByTypeMeasureName(type, measure);
        	savedGoal.setGoalPerson(p);
        	savedGoal.setGoalValue(g.getGoalValue());
        	savedGoal.setGoalType(t);
        	savedGoal.setStatus(g.getStatus());
        	savedGoal.setDateRegistered(g.getDateRegistered());
        	savedGoal= Goal.saveGoal(savedGoal);
        }
        return savedGoal;   
    }
	
 	@Override
	public Goal readPersonGoal(Long id, Long gid){
  		
  		System.out.println("Reading Goal from DB for person with id: "+id+" with GID="+ gid);
  		Goal g = Goal.getPersonGoalById(id,gid);
        if (g == null){	
        		System.out.println("Get: GOAL with GID="+ gid +" of Person with ID=" + id + " not found");
        }
        return g;
    }

  
 	@Override
	public Goal updatePersonGoal(Long id, String measure, String type, Goal g) {
	  	if (g==null){
	   		System.out.println("RECEIVED NULL PARAMETER");
	   	}
	   	else
	   	{
	   	    Person p = Person.getPersonById(id);
	   	    GoalType t = GoalType.getGoalTypeByTypeMeasureName(type, measure);
	        
	        Goal existing = Goal.getGoalById(g.getIdGoal());
	   	
	   		if (existing != null) {
	   			//System.out.println("--> Existing Person... " +person.getFirstname()+ " "+ person.getLastname());
	   			g.setGoalPerson(p);
	   			g.setGoalType(t);
	   			g = Goal.updateGoal(g);
	   		}
	   	}
	    return g;
	 }

	
 	@Override
	public int deletePersonGoal(Long gid) {
		if (gid==null) return 0;
		Goal g = Goal.getGoalById(gid);
		
	    if (g == null)
	    {
	    	System.out.println("DELETE: GOAL with " + gid + " not found");
	    	return 0;
	    }
	    else
	    {
	    	System.out.println("Deleting goal.. " + g.getIdGoal());
	    	Goal.removeGoal(g);
	    	return 1;
	    }
	}
 	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  	
	
/**** 5- PERSON REMINDER ****/
 	@Override
    public Reminder createPersonReminder(Long id, Reminder r) {
        
    	System.out.println("Creating new reminder for Person ID="+id);
    	
    	Reminder savedReminder = new Reminder();
    
    	if (r==null){
        	System.out.println("Received null Reminder");
        }
        else{
        	Person p = Person.getPersonById(id);
        	r.setPerson(p);
        	savedReminder= Reminder.saveReminder(r);
        }
        return savedReminder;   
    }
	
 	@Override
	public Reminder readPersonReminder(Long id, Long rid){
  		
  		System.out.println("Reading reminder from DB for person with id: "+id+" with RID="+ rid);
  		Reminder r = new Reminder();
  		
        r = Reminder.getPersonReminderById(id,rid);
        	
        if (r == null){	
        	System.out.println("Get: REMINDER with RID="+ rid +" of Person with ID=" + id + " not found");
        }	    	
        
        return r;
    }
 	
 	  
 	@Override
	public Reminder updatePersonReminder(Long id, Reminder r) {
	  	if (r==null){
	   		System.out.println("RECEIVED NULL PARAMETER");
	   	}
	   	else
	   	{
	   	    Person p = Person.getPersonById(id);
	        Reminder existing = Reminder.getReminderById(r.getIdReminder());
	   	
	   		if (existing != null) {
	   			//System.out.println("--> Existing Person... " +person.getFirstname()+ " "+ person.getLastname());
	   			r.setPerson(p);
	   			r= Reminder.updateReminder(r);
	   		}
	   	}
	    return r;
	 }

	
 	@Override
	public int deletePersonReminder(Long rid) {
		if (rid==null) return 0;
		Reminder r = Reminder.getReminderById(rid);
		
	    if (r == null)
	    {
	    	System.out.println("DELETE: REMINDER with " + rid + " not found");
	    	return 0;
	    }
	    else
	    {
	    	System.out.println("Deleting reminder.. " + r.getIdReminder());
	    	Reminder.removeReminder(r);
	    	return 1;
	    }
	}
 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  	
/**** 6- GOAL TYPE ****/

 	@Override
 	public GoalType createGoalType(GoalType gType) {

 		System.out.println("Creating new goal type...");
 		GoalType savedGType = new GoalType();
 		if (gType==null){
 			System.out.println("Received null object");
 		}
 		else{
 			savedGType = GoalType.saveGoalType(gType);
 		}
 		return savedGType;   
 	}

 	@Override
 	public GoalType readGoalType(Long id) {
 		System.out.println("---> Reading Goal Type by id = "+id);
 		GoalType g = GoalType.getGoalTypeById(id);
 		if (g!=null) {
 			System.out.println("---> Found GoalType by id = "+id+" => "+g.getIdGoalType());
 		} else {
 			System.out.println("---> Didn't find any GoalType with  id = "+id);
 		}
 		return g;
 	}

 	@Override
 	public GoalType updateGoalType(GoalType gType) {
 		GoalType updatedGType = new GoalType();

 		if (gType==null){
 			System.out.println("RECEIVED NULL PARAMETER");
 		}
 		else
 		{
 			GoalType existing = GoalType.getGoalTypeById(updatedGType.getIdGoalType());

 			if (existing != null) {
 				System.out.println("--> Existing MeasureType.. " + existing.getIdGoalType());
 				updatedGType = GoalType.updateGoalType(gType);
 			}
 		}
 		return updatedGType;
 	}

 	@Override
 	public int deleteGoalType(Long id) {
 		if (id==null) return 0;
 		GoalType gType = GoalType.getGoalTypeById(id);
 		if (gType == null)
 		{
 			System.out.println("DELETE: GoalType with " + id + " not found");
 			return 0;
 		}
 		else
 		{
 			System.out.println("Deleting goal type.. " + gType.getDescription());
 			Goal.removeAllGoalTypeGoal(id);
 			GoalType.removeGoalType(gType);          
 			return 1;
 		}
 	}

 	@Override
 	public List<GoalType> readGoalTypes(){
 		System.out.println("Getting list of XML goal type...");
 		List<GoalType> list = GoalType.getAll();
 		return list;
 	}

    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    
}