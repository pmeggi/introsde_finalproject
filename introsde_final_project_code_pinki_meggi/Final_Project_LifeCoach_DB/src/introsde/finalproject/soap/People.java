package introsde.finalproject.soap;

import introsde.finalproject.model.Goal;
import introsde.finalproject.model.GoalType;
import introsde.finalproject.model.MeasureHistory;
import introsde.finalproject.model.MeasureType;
import introsde.finalproject.model.Person;
import introsde.finalproject.model.Reminder;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebResult;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface People {
    
/**** 1- PERSON ***/
	
	@WebMethod(operationName="createPerson")
	@WebResult(name="person") 
	public Person createPerson(@WebParam(name="person_i") Person person);
   
	@WebMethod(operationName="readPerson")
    @WebResult(name="person") 
    public Person readPerson(@WebParam(name="personId") Long id);

	@WebMethod(operationName="updatePerson")
    @WebResult(name="person") 
    public Person updatePerson(@WebParam(name="person_i") Person person);

	@WebMethod(operationName="deletePerson")
	@WebResult(name="res") 
	public int deletePerson(@WebParam(name="personId") Long id);
	 
	@WebMethod(operationName="readPersonList")
	@WebResult(name="people") 
	public List<Person> readPersonList();
	
	@WebMethod(operationName="readPersonMeasureHistory")
    @WebResult(name="healthProfile-History")
    public List<MeasureHistory> readPersonMeasureHistory(@WebParam(name="personId") Long id, @WebParam(name="measureType") String measure);

	@WebMethod(operationName="readPersonGoals")
    @WebResult(name="goal-history")
    public List<Goal> readPersonGoalHistory(@WebParam(name="personId") Long id);

	@WebMethod(operationName="readPersonReminders")
    @WebResult(name="reminders-history")
    public List<Reminder> readPersonReminders(@WebParam(name="personId") Long id);

   
/**** 2- MEASURE TYPE ****/

	@WebMethod(operationName="createMeasureType")
	@WebResult(name="mType") 
	public MeasureType createMeasureType(@WebParam(name="mType_i") MeasureType mType);
   
	@WebMethod(operationName="readMeasureType")
    @WebResult(name="mType") 
    public MeasureType readMeasureType(@WebParam(name="measure") String measure);

	@WebMethod(operationName="updateMeasureType")
    @WebResult(name="mtype") 
    public MeasureType updateMeasureType(@WebParam(name="mType_i") MeasureType mType);

	@WebMethod(operationName="deleteMeasureType")
	@WebResult(name="res") 
	public int deleteMeasureType(@WebParam(name="mTypeId") Long id);

	@WebMethod(operationName="readMeasureTypes")
	@WebResult(name="measureType")
	public List<String> readMeasureTypes();

/**** 3- PERSON MEASURE HISTORY ****/
   
	@WebMethod(operationName="createPersonMeasurement")
    @WebResult(name="measureHistory")
    public MeasureHistory createPersonMeasurement(@WebParam(name="personId") Long id,
    		 @WebParam(name="measureType") String measure,
    		 @WebParam(name="measureHistory_i") MeasureHistory mh);

	@WebMethod(operationName="readPersonMeasurement")
    @WebResult(name="measurehistory")
    public MeasureHistory readPersonMeasurement(@WebParam(name="personId") Long id, 
    												  @WebParam(name="measureType") String measure,
    												  @WebParam(name="measureId") Long mid);

    @WebMethod(operationName="updatePersonMeasurement")
    @WebResult(name="measureHistory")
    public MeasureHistory updatePersonMeasurement(@WebParam(name="personId") Long id,
    		  @WebParam(name="measureType") String measure,
			  @WebParam(name="measureHistory_u") MeasureHistory mh);
    
    @WebMethod(operationName="deletePersonMeasurement")
    @WebResult(name="res")
    public int deletePersonMeasurement(@WebParam(name="mhId") Long mid);
    
    @WebMethod(operationName="readPersonMeasurementByDate")
    @WebResult(name="measurehistory")
    public MeasureHistory readPersonMeasurementByDate(@WebParam(name="personId") Long id, 
    												  @WebParam(name="measureType") String measure,
    												  @WebParam(name="date") String date);
    

/**** 4- PERSON GOAL ****/
    
    @WebMethod(operationName="createPersonGoal")
    @WebResult(name="goal")
    public Goal createPersonGoal(@WebParam(name="personId") Long id,  @WebParam(name="measureType") String measure,
    		 @WebParam(name="goalType") String type, @WebParam(name="goal_i") Goal g);

	@WebMethod(operationName="readPersonGoal")
    @WebResult(name="goal")
    public Goal readPersonGoal(@WebParam(name="personId") Long id, 
    												  @WebParam(name="goalId") Long gid);

    @WebMethod(operationName="updatePersonGoal")
    @WebResult(name="goal")
    public Goal updatePersonGoal(@WebParam(name="personId") Long id,  @WebParam(name="measureType") String measure,
    		@WebParam(name="goalType") String type, @WebParam(name="goal_u") Goal g);
    
    @WebMethod(operationName="deletePersonGoal")
    @WebResult(name="res")
    public int deletePersonGoal(@WebParam(name="goalId") Long gid);
    
/**** 5- PERSON REMINDER ****/
    
    @WebMethod(operationName="createPersonReminder")
    @WebResult(name="reminder")
    public Reminder createPersonReminder(@WebParam(name="personId") Long id,  
    												  @WebParam(name="reminder_i") Reminder r);

	@WebMethod(operationName="readPersonReminder")
    @WebResult(name="reminder")
    public Reminder readPersonReminder(@WebParam(name="personId") Long id, 
    												  @WebParam(name="reminderId") Long rid);

    @WebMethod(operationName="updatePersonReminder")
    @WebResult(name="reminder")
    public Reminder updatePersonReminder(@WebParam(name="personId") Long id,
    												  @WebParam(name="reminder_u") Reminder r);
    
    @WebMethod(operationName="deletePersonReminder")
    @WebResult(name="res")
    public int deletePersonReminder(@WebParam(name="reminderId") Long rid);
    
    @WebMethod(operationName="readPersonRemindersByDate")
    @WebResult(name="reminder")
    public List<Reminder> readPersonRemindersByDate(@WebParam(name="personId") Long id, 
    												  @WebParam(name="date") String date);
    
    
/**** 6- GOAL TYPE ****/

	@WebMethod(operationName="createGoalType")
	@WebResult(name="gType") 
	public GoalType createGoalType(@WebParam(name="gType_i") GoalType gType);

	@WebMethod(operationName="readGoalType")
	@WebResult(name="gType") 
	public GoalType readGoalType(@WebParam(name="gTypeId") Long id);

	@WebMethod(operationName="updateGoalType")
	@WebResult(name="gtype") 
	public GoalType updateGoalType(@WebParam(name="gType_i") GoalType gType);

	@WebMethod(operationName="deleteGoalType")
	@WebResult(name="res") 
	public int deleteGoalType(@WebParam(name="gTypeId") Long id);

	@WebMethod(operationName="readGoalTypes")
	@WebResult(name="goalType")
	public List<GoalType> readGoalTypes();

}
		


