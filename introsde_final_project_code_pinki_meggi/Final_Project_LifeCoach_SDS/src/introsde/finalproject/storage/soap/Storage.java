package introsde.finalproject.storage.soap;

import java.util.List;

import introsde.finalproject.soap.GoalType;
import introsde.finalproject.soap.Goal;
import introsde.finalproject.soap.MeasureHistory;
import introsde.finalproject.soap.Person;
import introsde.finalproject.soap.Reminder;
import introsde.finalproject.soap.MeasureType;




import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebResult;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface Storage {
    
	/**** PERSON ********/
	
	@WebMethod(operationName="registerPerson")
	@WebResult(name="person") 
	public Person registerPerson(@WebParam(name="person_i") Person person);
   	
	@WebMethod(operationName="readPersonInfo")
    @WebResult(name="person") 
    public Person readPersonInfo(@WebParam(name="personId") Long id);
	
	/**** PERSON-MEASUREMENT ********/
	
	@WebMethod(operationName="registerPersonMeasure")
	@WebResult(name="measure") 
	public MeasureHistory registerPersonMeasurement(@WebParam(name="personId")Long id, @WebParam(name="measureType") String measure, @WebParam(name="measure_i") MeasureHistory m);
	
	@WebMethod(operationName="readPersonMeasurement")
    @WebResult(name="measurehistory")
    public MeasureHistory readPersonMeasurement(@WebParam(name="personId") Long id, 
    												  @WebParam(name="measureType") String measure,
    												  @WebParam(name="measureId") Long mid);

	
	@WebMethod(operationName="editPersonMeasurement")
    @WebResult(name="measurehistory")
    public MeasureHistory editPersonMeasurement(@WebParam(name="personId") Long id, 
    												  @WebParam(name="measureType") String measure,
    												  @WebParam(name="measurehistory_u") MeasureHistory mh);

	@WebMethod(operationName="removePersonMeasurement")
    @WebResult(name="result")
    public int removePersonMeasurement(@WebParam(name="measureId") Long mid);

	@WebMethod(operationName="readPersonMeasureHistory")
    @WebResult(name="healthProfile-History")
    public List<MeasureHistory> readPersonMeasureHistory(@WebParam(name="personId") Long id, @WebParam(name="measureType") String measure);

		
	/**** PERSON-GOALS ********/
	
	@WebMethod(operationName="registerPersonGoal")
	@WebResult(name="goal") 
	public Goal registerPersonGoal(@WebParam(name="personId")Long id, @WebParam(name="measure") String measure,@WebParam(name="type") String type,@WebParam(name="goal_i") Goal g);
	
	@WebMethod(operationName="readPersonGoal")
    @WebResult(name="goal")
    public Goal readPersonGoal(@WebParam(name="personId") Long id, 
    		 										  @WebParam(name="goalId") Long gid);

	@WebMethod(operationName="readPersonGoals")
    @WebResult(name="goal-history")
    public List<Goal> readPersonGoalHistory(@WebParam(name="personId") Long id);
	
	@WebMethod(operationName="editPersonGoal")
    @WebResult(name="goal")
    public Goal editPersonGoal(@WebParam(name="personId") Long id, @WebParam(name="measure") String measure,@WebParam(name="type") String type,
    		 										  @WebParam(name="goal_u") Goal g);
	
	@WebMethod(operationName="removePersonGoal")
    @WebResult(name="result")
    public int removePersonGoal(@WebParam(name="goalId") Long gid);



	/**** PERSON-REMINDERS ********/
	
	@WebMethod(operationName="registerPersonReminder")
	@WebResult(name="reminder") 
	public Reminder registerPersonReminder(@WebParam(name="personId")Long id,@WebParam(name="reminder_i") Reminder r);
	
	@WebMethod(operationName="readPersonReminder")
    @WebResult(name="reminder")
    public Reminder readPersonReminder(@WebParam(name="personId") Long id, 
    												  @WebParam(name="reminderId") Long rid);
	
	@WebMethod(operationName="editPersonReminder")
    @WebResult(name="reminder")
    public Reminder editPersonReminder(@WebParam(name="personId") Long id, 
    		 										  @WebParam(name="reminder_u") Reminder r);
	
	@WebMethod(operationName="removePersonReminder")
    @WebResult(name="result")
    public int removePersonReminder(@WebParam(name="reminderId") Long rid);

	@WebMethod(operationName="readPersonReminders")
    @WebResult(name="reminders-history")
    public List<Reminder> readPersonReminders(@WebParam(name="personId") Long id);
	
	

		
	/**** MEASURETYPE ***/
	@WebMethod(operationName="readMeasureTypes")
	@WebResult(name="mTypes")
	public List<String> readMeasureTypes();
	
	@WebMethod(operationName="readMeasureType")
    @WebResult(name="mType")
    public MeasureType readMeasureType(@WebParam(name="measure") String measure);
	
	/**** GOALTYPE ***/

	@WebMethod(operationName="readGoalTypes")
	@WebResult(name="goalType")
	public List<GoalType> readGoalTypes();

	
	@WebMethod(operationName="readPersonRemindersByDate")
    @WebResult(name="reminder")
    public List<Reminder> readPersonRemindersByDate(@WebParam(name="personId") Long id, 
    												  @WebParam(name="date") String date);
    
    @WebMethod(operationName="readPersonMeasurementByDate")
    @WebResult(name="measurehistory")
    public MeasureHistory readPersonMeasurementByDate(@WebParam(name="personId") Long id, 
    												  @WebParam(name="measureType") String measure,
    												  @WebParam(name="date") String date);
	
    /**** TRACKING ***/
    @WebMethod(operationName="sendPersonEmail")
	@WebResult(name="result") 
	public int sendPersonEmail(@WebParam(name="email") String email,@WebParam(name="subject") String subject, @WebParam(name="content") String content);

    @WebMethod(operationName="getRandomQuote")
	@WebResult(name="result") 
	public String getRandomQuote();

}

		


