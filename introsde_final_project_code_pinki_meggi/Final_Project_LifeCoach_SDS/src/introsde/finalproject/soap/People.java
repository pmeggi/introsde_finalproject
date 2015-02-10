
package introsde.finalproject.soap;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "People", targetNamespace = "http://soap.finalproject.introsde/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface People {


    /**
     * 
     * @param gTypeId
     * @return
     *     returns introsde.finalproject.soap.GoalType
     */
    @WebMethod
    @WebResult(name = "gType", targetNamespace = "")
    @RequestWrapper(localName = "readGoalType", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.ReadGoalType")
    @ResponseWrapper(localName = "readGoalTypeResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.ReadGoalTypeResponse")
    @Action(input = "http://soap.finalproject.introsde/People/readGoalTypeRequest", output = "http://soap.finalproject.introsde/People/readGoalTypeResponse")
    public GoalType readGoalType(
        @WebParam(name = "gTypeId", targetNamespace = "")
        Long gTypeId);

    /**
     * 
     * @param personId
     * @return
     *     returns introsde.finalproject.soap.Person
     */
    @WebMethod
    @WebResult(name = "person", targetNamespace = "")
    @RequestWrapper(localName = "readPerson", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.ReadPerson")
    @ResponseWrapper(localName = "readPersonResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.ReadPersonResponse")
    @Action(input = "http://soap.finalproject.introsde/People/readPersonRequest", output = "http://soap.finalproject.introsde/People/readPersonResponse")
    public Person readPerson(
        @WebParam(name = "personId", targetNamespace = "")
        Long personId);

    /**
     * 
     * @param personI
     * @return
     *     returns introsde.finalproject.soap.Person
     */
    @WebMethod
    @WebResult(name = "person", targetNamespace = "")
    @RequestWrapper(localName = "createPerson", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.CreatePerson")
    @ResponseWrapper(localName = "createPersonResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.CreatePersonResponse")
    @Action(input = "http://soap.finalproject.introsde/People/createPersonRequest", output = "http://soap.finalproject.introsde/People/createPersonResponse")
    public Person createPerson(
        @WebParam(name = "person_i", targetNamespace = "")
        Person personI);

    /**
     * 
     * @param personId
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(name = "res", targetNamespace = "")
    @RequestWrapper(localName = "deletePerson", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.DeletePerson")
    @ResponseWrapper(localName = "deletePersonResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.DeletePersonResponse")
    @Action(input = "http://soap.finalproject.introsde/People/deletePersonRequest", output = "http://soap.finalproject.introsde/People/deletePersonResponse")
    public int deletePerson(
        @WebParam(name = "personId", targetNamespace = "")
        Long personId);

    /**
     * 
     * @param personI
     * @return
     *     returns introsde.finalproject.soap.Person
     */
    @WebMethod
    @WebResult(name = "person", targetNamespace = "")
    @RequestWrapper(localName = "updatePerson", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.UpdatePerson")
    @ResponseWrapper(localName = "updatePersonResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.UpdatePersonResponse")
    @Action(input = "http://soap.finalproject.introsde/People/updatePersonRequest", output = "http://soap.finalproject.introsde/People/updatePersonResponse")
    public Person updatePerson(
        @WebParam(name = "person_i", targetNamespace = "")
        Person personI);

    /**
     * 
     * @param personId
     * @return
     *     returns java.util.List<introsde.finalproject.soap.Goal>
     */
    @WebMethod
    @WebResult(name = "goal-history", targetNamespace = "")
    @RequestWrapper(localName = "readPersonGoals", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.ReadPersonGoals")
    @ResponseWrapper(localName = "readPersonGoalsResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.ReadPersonGoalsResponse")
    @Action(input = "http://soap.finalproject.introsde/People/readPersonGoalsRequest", output = "http://soap.finalproject.introsde/People/readPersonGoalsResponse")
    public List<Goal> readPersonGoals(
        @WebParam(name = "personId", targetNamespace = "")
        Long personId);

    /**
     * 
     * @param measure
     * @return
     *     returns introsde.finalproject.soap.MeasureType
     */
    @WebMethod
    @WebResult(name = "mType", targetNamespace = "")
    @RequestWrapper(localName = "readMeasureType", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.ReadMeasureType")
    @ResponseWrapper(localName = "readMeasureTypeResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.ReadMeasureTypeResponse")
    @Action(input = "http://soap.finalproject.introsde/People/readMeasureTypeRequest", output = "http://soap.finalproject.introsde/People/readMeasureTypeResponse")
    public MeasureType readMeasureType(
        @WebParam(name = "measure", targetNamespace = "")
        String measure);

    /**
     * 
     * @param mTypeI
     * @return
     *     returns introsde.finalproject.soap.MeasureType
     */
    @WebMethod
    @WebResult(name = "mType", targetNamespace = "")
    @RequestWrapper(localName = "createMeasureType", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.CreateMeasureType")
    @ResponseWrapper(localName = "createMeasureTypeResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.CreateMeasureTypeResponse")
    @Action(input = "http://soap.finalproject.introsde/People/createMeasureTypeRequest", output = "http://soap.finalproject.introsde/People/createMeasureTypeResponse")
    public MeasureType createMeasureType(
        @WebParam(name = "mType_i", targetNamespace = "")
        MeasureType mTypeI);

    /**
     * 
     * @param mTypeI
     * @return
     *     returns introsde.finalproject.soap.MeasureType
     */
    @WebMethod
    @WebResult(name = "mtype", targetNamespace = "")
    @RequestWrapper(localName = "updateMeasureType", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.UpdateMeasureType")
    @ResponseWrapper(localName = "updateMeasureTypeResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.UpdateMeasureTypeResponse")
    @Action(input = "http://soap.finalproject.introsde/People/updateMeasureTypeRequest", output = "http://soap.finalproject.introsde/People/updateMeasureTypeResponse")
    public MeasureType updateMeasureType(
        @WebParam(name = "mType_i", targetNamespace = "")
        MeasureType mTypeI);

    /**
     * 
     * @param measureType
     * @param personId
     * @return
     *     returns java.util.List<introsde.finalproject.soap.MeasureHistory>
     */
    @WebMethod
    @WebResult(name = "healthProfile-History", targetNamespace = "")
    @RequestWrapper(localName = "readPersonMeasureHistory", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.ReadPersonMeasureHistory")
    @ResponseWrapper(localName = "readPersonMeasureHistoryResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.ReadPersonMeasureHistoryResponse")
    @Action(input = "http://soap.finalproject.introsde/People/readPersonMeasureHistoryRequest", output = "http://soap.finalproject.introsde/People/readPersonMeasureHistoryResponse")
    public List<MeasureHistory> readPersonMeasureHistory(
        @WebParam(name = "personId", targetNamespace = "")
        Long personId,
        @WebParam(name = "measureType", targetNamespace = "")
        String measureType);

    /**
     * 
     * @return
     *     returns java.util.List<introsde.finalproject.soap.Person>
     */
    @WebMethod
    @WebResult(name = "people", targetNamespace = "")
    @RequestWrapper(localName = "readPersonList", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.ReadPersonList")
    @ResponseWrapper(localName = "readPersonListResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.ReadPersonListResponse")
    @Action(input = "http://soap.finalproject.introsde/People/readPersonListRequest", output = "http://soap.finalproject.introsde/People/readPersonListResponse")
    public List<Person> readPersonList();

    /**
     * 
     * @param personId
     * @param date
     * @return
     *     returns java.util.List<introsde.finalproject.soap.Reminder>
     */
    @WebMethod
    @WebResult(name = "reminder", targetNamespace = "")
    @RequestWrapper(localName = "readPersonRemindersByDate", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.ReadPersonRemindersByDate")
    @ResponseWrapper(localName = "readPersonRemindersByDateResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.ReadPersonRemindersByDateResponse")
    @Action(input = "http://soap.finalproject.introsde/People/readPersonRemindersByDateRequest", output = "http://soap.finalproject.introsde/People/readPersonRemindersByDateResponse")
    public List<Reminder> readPersonRemindersByDate(
        @WebParam(name = "personId", targetNamespace = "")
        Long personId,
        @WebParam(name = "date", targetNamespace = "")
        String date);

    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(name = "measureType", targetNamespace = "")
    @RequestWrapper(localName = "readMeasureTypes", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.ReadMeasureTypes")
    @ResponseWrapper(localName = "readMeasureTypesResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.ReadMeasureTypesResponse")
    @Action(input = "http://soap.finalproject.introsde/People/readMeasureTypesRequest", output = "http://soap.finalproject.introsde/People/readMeasureTypesResponse")
    public List<String> readMeasureTypes();

    /**
     * 
     * @param personId
     * @return
     *     returns java.util.List<introsde.finalproject.soap.Reminder>
     */
    @WebMethod
    @WebResult(name = "reminders-history", targetNamespace = "")
    @RequestWrapper(localName = "readPersonReminders", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.ReadPersonReminders")
    @ResponseWrapper(localName = "readPersonRemindersResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.ReadPersonRemindersResponse")
    @Action(input = "http://soap.finalproject.introsde/People/readPersonRemindersRequest", output = "http://soap.finalproject.introsde/People/readPersonRemindersResponse")
    public List<Reminder> readPersonReminders(
        @WebParam(name = "personId", targetNamespace = "")
        Long personId);

    /**
     * 
     * @param mTypeId
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(name = "res", targetNamespace = "")
    @RequestWrapper(localName = "deleteMeasureType", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.DeleteMeasureType")
    @ResponseWrapper(localName = "deleteMeasureTypeResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.DeleteMeasureTypeResponse")
    @Action(input = "http://soap.finalproject.introsde/People/deleteMeasureTypeRequest", output = "http://soap.finalproject.introsde/People/deleteMeasureTypeResponse")
    public int deleteMeasureType(
        @WebParam(name = "mTypeId", targetNamespace = "")
        Long mTypeId);

    /**
     * 
     * @param measureHistoryI
     * @param measureType
     * @param personId
     * @return
     *     returns introsde.finalproject.soap.MeasureHistory
     */
    @WebMethod
    @WebResult(name = "measureHistory", targetNamespace = "")
    @RequestWrapper(localName = "createPersonMeasurement", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.CreatePersonMeasurement")
    @ResponseWrapper(localName = "createPersonMeasurementResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.CreatePersonMeasurementResponse")
    @Action(input = "http://soap.finalproject.introsde/People/createPersonMeasurementRequest", output = "http://soap.finalproject.introsde/People/createPersonMeasurementResponse")
    public MeasureHistory createPersonMeasurement(
        @WebParam(name = "personId", targetNamespace = "")
        Long personId,
        @WebParam(name = "measureType", targetNamespace = "")
        String measureType,
        @WebParam(name = "measureHistory_i", targetNamespace = "")
        MeasureHistory measureHistoryI);

    /**
     * 
     * @param gTypeI
     * @return
     *     returns introsde.finalproject.soap.GoalType
     */
    @WebMethod
    @WebResult(name = "gtype", targetNamespace = "")
    @RequestWrapper(localName = "updateGoalType", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.UpdateGoalType")
    @ResponseWrapper(localName = "updateGoalTypeResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.UpdateGoalTypeResponse")
    @Action(input = "http://soap.finalproject.introsde/People/updateGoalTypeRequest", output = "http://soap.finalproject.introsde/People/updateGoalTypeResponse")
    public GoalType updateGoalType(
        @WebParam(name = "gType_i", targetNamespace = "")
        GoalType gTypeI);

    /**
     * 
     * @param reminderU
     * @param personId
     * @return
     *     returns introsde.finalproject.soap.Reminder
     */
    @WebMethod
    @WebResult(name = "reminder", targetNamespace = "")
    @RequestWrapper(localName = "updatePersonReminder", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.UpdatePersonReminder")
    @ResponseWrapper(localName = "updatePersonReminderResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.UpdatePersonReminderResponse")
    @Action(input = "http://soap.finalproject.introsde/People/updatePersonReminderRequest", output = "http://soap.finalproject.introsde/People/updatePersonReminderResponse")
    public Reminder updatePersonReminder(
        @WebParam(name = "personId", targetNamespace = "")
        Long personId,
        @WebParam(name = "reminder_u", targetNamespace = "")
        Reminder reminderU);

    /**
     * 
     * @param measureType
     * @param personId
     * @param measureHistoryU
     * @return
     *     returns introsde.finalproject.soap.MeasureHistory
     */
    @WebMethod
    @WebResult(name = "measureHistory", targetNamespace = "")
    @RequestWrapper(localName = "updatePersonMeasurement", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.UpdatePersonMeasurement")
    @ResponseWrapper(localName = "updatePersonMeasurementResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.UpdatePersonMeasurementResponse")
    @Action(input = "http://soap.finalproject.introsde/People/updatePersonMeasurementRequest", output = "http://soap.finalproject.introsde/People/updatePersonMeasurementResponse")
    public MeasureHistory updatePersonMeasurement(
        @WebParam(name = "personId", targetNamespace = "")
        Long personId,
        @WebParam(name = "measureType", targetNamespace = "")
        String measureType,
        @WebParam(name = "measureHistory_u", targetNamespace = "")
        MeasureHistory measureHistoryU);

    /**
     * 
     * @param reminderId
     * @param personId
     * @return
     *     returns introsde.finalproject.soap.Reminder
     */
    @WebMethod
    @WebResult(name = "reminder", targetNamespace = "")
    @RequestWrapper(localName = "readPersonReminder", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.ReadPersonReminder")
    @ResponseWrapper(localName = "readPersonReminderResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.ReadPersonReminderResponse")
    @Action(input = "http://soap.finalproject.introsde/People/readPersonReminderRequest", output = "http://soap.finalproject.introsde/People/readPersonReminderResponse")
    public Reminder readPersonReminder(
        @WebParam(name = "personId", targetNamespace = "")
        Long personId,
        @WebParam(name = "reminderId", targetNamespace = "")
        Long reminderId);

    /**
     * 
     * @param goalU
     * @param goalType
     * @param measureType
     * @param personId
     * @return
     *     returns introsde.finalproject.soap.Goal
     */
    @WebMethod
    @WebResult(name = "goal", targetNamespace = "")
    @RequestWrapper(localName = "updatePersonGoal", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.UpdatePersonGoal")
    @ResponseWrapper(localName = "updatePersonGoalResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.UpdatePersonGoalResponse")
    @Action(input = "http://soap.finalproject.introsde/People/updatePersonGoalRequest", output = "http://soap.finalproject.introsde/People/updatePersonGoalResponse")
    public Goal updatePersonGoal(
        @WebParam(name = "personId", targetNamespace = "")
        Long personId,
        @WebParam(name = "measureType", targetNamespace = "")
        String measureType,
        @WebParam(name = "goalType", targetNamespace = "")
        String goalType,
        @WebParam(name = "goal_u", targetNamespace = "")
        Goal goalU);

    /**
     * 
     * @param gTypeId
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(name = "res", targetNamespace = "")
    @RequestWrapper(localName = "deleteGoalType", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.DeleteGoalType")
    @ResponseWrapper(localName = "deleteGoalTypeResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.DeleteGoalTypeResponse")
    @Action(input = "http://soap.finalproject.introsde/People/deleteGoalTypeRequest", output = "http://soap.finalproject.introsde/People/deleteGoalTypeResponse")
    public int deleteGoalType(
        @WebParam(name = "gTypeId", targetNamespace = "")
        Long gTypeId);

    /**
     * 
     * @param gTypeI
     * @return
     *     returns introsde.finalproject.soap.GoalType
     */
    @WebMethod
    @WebResult(name = "gType", targetNamespace = "")
    @RequestWrapper(localName = "createGoalType", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.CreateGoalType")
    @ResponseWrapper(localName = "createGoalTypeResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.CreateGoalTypeResponse")
    @Action(input = "http://soap.finalproject.introsde/People/createGoalTypeRequest", output = "http://soap.finalproject.introsde/People/createGoalTypeResponse")
    public GoalType createGoalType(
        @WebParam(name = "gType_i", targetNamespace = "")
        GoalType gTypeI);

    /**
     * 
     * @param mhId
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(name = "res", targetNamespace = "")
    @RequestWrapper(localName = "deletePersonMeasurement", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.DeletePersonMeasurement")
    @ResponseWrapper(localName = "deletePersonMeasurementResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.DeletePersonMeasurementResponse")
    @Action(input = "http://soap.finalproject.introsde/People/deletePersonMeasurementRequest", output = "http://soap.finalproject.introsde/People/deletePersonMeasurementResponse")
    public int deletePersonMeasurement(
        @WebParam(name = "mhId", targetNamespace = "")
        Long mhId);

    /**
     * 
     * @param reminderI
     * @param personId
     * @return
     *     returns introsde.finalproject.soap.Reminder
     */
    @WebMethod
    @WebResult(name = "reminder", targetNamespace = "")
    @RequestWrapper(localName = "createPersonReminder", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.CreatePersonReminder")
    @ResponseWrapper(localName = "createPersonReminderResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.CreatePersonReminderResponse")
    @Action(input = "http://soap.finalproject.introsde/People/createPersonReminderRequest", output = "http://soap.finalproject.introsde/People/createPersonReminderResponse")
    public Reminder createPersonReminder(
        @WebParam(name = "personId", targetNamespace = "")
        Long personId,
        @WebParam(name = "reminder_i", targetNamespace = "")
        Reminder reminderI);

    /**
     * 
     * @param measureType
     * @param personId
     * @param measureId
     * @return
     *     returns introsde.finalproject.soap.MeasureHistory
     */
    @WebMethod
    @WebResult(name = "measurehistory", targetNamespace = "")
    @RequestWrapper(localName = "readPersonMeasurement", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.ReadPersonMeasurement")
    @ResponseWrapper(localName = "readPersonMeasurementResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.ReadPersonMeasurementResponse")
    @Action(input = "http://soap.finalproject.introsde/People/readPersonMeasurementRequest", output = "http://soap.finalproject.introsde/People/readPersonMeasurementResponse")
    public MeasureHistory readPersonMeasurement(
        @WebParam(name = "personId", targetNamespace = "")
        Long personId,
        @WebParam(name = "measureType", targetNamespace = "")
        String measureType,
        @WebParam(name = "measureId", targetNamespace = "")
        Long measureId);

    /**
     * 
     * @param reminderId
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(name = "res", targetNamespace = "")
    @RequestWrapper(localName = "deletePersonReminder", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.DeletePersonReminder")
    @ResponseWrapper(localName = "deletePersonReminderResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.DeletePersonReminderResponse")
    @Action(input = "http://soap.finalproject.introsde/People/deletePersonReminderRequest", output = "http://soap.finalproject.introsde/People/deletePersonReminderResponse")
    public int deletePersonReminder(
        @WebParam(name = "reminderId", targetNamespace = "")
        Long reminderId);

    /**
     * 
     * @param goalId
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(name = "res", targetNamespace = "")
    @RequestWrapper(localName = "deletePersonGoal", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.DeletePersonGoal")
    @ResponseWrapper(localName = "deletePersonGoalResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.DeletePersonGoalResponse")
    @Action(input = "http://soap.finalproject.introsde/People/deletePersonGoalRequest", output = "http://soap.finalproject.introsde/People/deletePersonGoalResponse")
    public int deletePersonGoal(
        @WebParam(name = "goalId", targetNamespace = "")
        Long goalId);

    /**
     * 
     * @param measureType
     * @param personId
     * @param date
     * @return
     *     returns introsde.finalproject.soap.MeasureHistory
     */
    @WebMethod
    @WebResult(name = "measurehistory", targetNamespace = "")
    @RequestWrapper(localName = "readPersonMeasurementByDate", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.ReadPersonMeasurementByDate")
    @ResponseWrapper(localName = "readPersonMeasurementByDateResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.ReadPersonMeasurementByDateResponse")
    @Action(input = "http://soap.finalproject.introsde/People/readPersonMeasurementByDateRequest", output = "http://soap.finalproject.introsde/People/readPersonMeasurementByDateResponse")
    public MeasureHistory readPersonMeasurementByDate(
        @WebParam(name = "personId", targetNamespace = "")
        Long personId,
        @WebParam(name = "measureType", targetNamespace = "")
        String measureType,
        @WebParam(name = "date", targetNamespace = "")
        String date);

    /**
     * 
     * @param goalI
     * @param goalType
     * @param measureType
     * @param personId
     * @return
     *     returns introsde.finalproject.soap.Goal
     */
    @WebMethod
    @WebResult(name = "goal", targetNamespace = "")
    @RequestWrapper(localName = "createPersonGoal", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.CreatePersonGoal")
    @ResponseWrapper(localName = "createPersonGoalResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.CreatePersonGoalResponse")
    @Action(input = "http://soap.finalproject.introsde/People/createPersonGoalRequest", output = "http://soap.finalproject.introsde/People/createPersonGoalResponse")
    public Goal createPersonGoal(
        @WebParam(name = "personId", targetNamespace = "")
        Long personId,
        @WebParam(name = "measureType", targetNamespace = "")
        String measureType,
        @WebParam(name = "goalType", targetNamespace = "")
        String goalType,
        @WebParam(name = "goal_i", targetNamespace = "")
        Goal goalI);

    /**
     * 
     * @param goalId
     * @param personId
     * @return
     *     returns introsde.finalproject.soap.Goal
     */
    @WebMethod
    @WebResult(name = "goal", targetNamespace = "")
    @RequestWrapper(localName = "readPersonGoal", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.ReadPersonGoal")
    @ResponseWrapper(localName = "readPersonGoalResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.ReadPersonGoalResponse")
    @Action(input = "http://soap.finalproject.introsde/People/readPersonGoalRequest", output = "http://soap.finalproject.introsde/People/readPersonGoalResponse")
    public Goal readPersonGoal(
        @WebParam(name = "personId", targetNamespace = "")
        Long personId,
        @WebParam(name = "goalId", targetNamespace = "")
        Long goalId);

    /**
     * 
     * @return
     *     returns java.util.List<introsde.finalproject.soap.GoalType>
     */
    @WebMethod
    @WebResult(name = "goalType", targetNamespace = "")
    @RequestWrapper(localName = "readGoalTypes", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.ReadGoalTypes")
    @ResponseWrapper(localName = "readGoalTypesResponse", targetNamespace = "http://soap.finalproject.introsde/", className = "introsde.finalproject.soap.ReadGoalTypesResponse")
    @Action(input = "http://soap.finalproject.introsde/People/readGoalTypesRequest", output = "http://soap.finalproject.introsde/People/readGoalTypesResponse")
    public List<GoalType> readGoalTypes();

}
