
package introsde.finalproject.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the introsde.finalproject.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DeleteGoalTypeResponse_QNAME = new QName("http://soap.finalproject.introsde/", "deleteGoalTypeResponse");
    private final static QName _ReadGoalTypeResponse_QNAME = new QName("http://soap.finalproject.introsde/", "readGoalTypeResponse");
    private final static QName _UpdatePersonResponse_QNAME = new QName("http://soap.finalproject.introsde/", "updatePersonResponse");
    private final static QName _DeleteMeasureType_QNAME = new QName("http://soap.finalproject.introsde/", "deleteMeasureType");
    private final static QName _ReadPersonMeasureHistory_QNAME = new QName("http://soap.finalproject.introsde/", "readPersonMeasureHistory");
    private final static QName _ReadPersonMeasurement_QNAME = new QName("http://soap.finalproject.introsde/", "readPersonMeasurement");
    private final static QName _ReadPersonRemindersByDate_QNAME = new QName("http://soap.finalproject.introsde/", "readPersonRemindersByDate");
    private final static QName _ReadPerson_QNAME = new QName("http://soap.finalproject.introsde/", "readPerson");
    private final static QName _DeletePersonMeasurement_QNAME = new QName("http://soap.finalproject.introsde/", "deletePersonMeasurement");
    private final static QName _DeletePersonReminder_QNAME = new QName("http://soap.finalproject.introsde/", "deletePersonReminder");
    private final static QName _CreatePersonGoalResponse_QNAME = new QName("http://soap.finalproject.introsde/", "createPersonGoalResponse");
    private final static QName _UpdatePersonReminderResponse_QNAME = new QName("http://soap.finalproject.introsde/", "updatePersonReminderResponse");
    private final static QName _CreatePersonReminderResponse_QNAME = new QName("http://soap.finalproject.introsde/", "createPersonReminderResponse");
    private final static QName _Measure_QNAME = new QName("http://soap.finalproject.introsde/", "measure");
    private final static QName _DeletePersonReminderResponse_QNAME = new QName("http://soap.finalproject.introsde/", "deletePersonReminderResponse");
    private final static QName _CreatePersonGoal_QNAME = new QName("http://soap.finalproject.introsde/", "createPersonGoal");
    private final static QName _UpdatePersonMeasurementResponse_QNAME = new QName("http://soap.finalproject.introsde/", "updatePersonMeasurementResponse");
    private final static QName _ReadGoalTypes_QNAME = new QName("http://soap.finalproject.introsde/", "readGoalTypes");
    private final static QName _UpdatePersonReminder_QNAME = new QName("http://soap.finalproject.introsde/", "updatePersonReminder");
    private final static QName _ReadPersonListResponse_QNAME = new QName("http://soap.finalproject.introsde/", "readPersonListResponse");
    private final static QName _ReadPersonMeasurementByDateResponse_QNAME = new QName("http://soap.finalproject.introsde/", "readPersonMeasurementByDateResponse");
    private final static QName _DeletePersonResponse_QNAME = new QName("http://soap.finalproject.introsde/", "deletePersonResponse");
    private final static QName _UpdatePersonGoal_QNAME = new QName("http://soap.finalproject.introsde/", "updatePersonGoal");
    private final static QName _ReadMeasureType_QNAME = new QName("http://soap.finalproject.introsde/", "readMeasureType");
    private final static QName _CreatePersonMeasurementResponse_QNAME = new QName("http://soap.finalproject.introsde/", "createPersonMeasurementResponse");
    private final static QName _ReadPersonGoals_QNAME = new QName("http://soap.finalproject.introsde/", "readPersonGoals");
    private final static QName _CreateMeasureTypeResponse_QNAME = new QName("http://soap.finalproject.introsde/", "createMeasureTypeResponse");
    private final static QName _ReadPersonMeasureHistoryResponse_QNAME = new QName("http://soap.finalproject.introsde/", "readPersonMeasureHistoryResponse");
    private final static QName _ReadPersonResponse_QNAME = new QName("http://soap.finalproject.introsde/", "readPersonResponse");
    private final static QName _ReadPersonGoal_QNAME = new QName("http://soap.finalproject.introsde/", "readPersonGoal");
    private final static QName _DeletePerson_QNAME = new QName("http://soap.finalproject.introsde/", "deletePerson");
    private final static QName _ReadMeasureTypes_QNAME = new QName("http://soap.finalproject.introsde/", "readMeasureTypes");
    private final static QName _CreateMeasureType_QNAME = new QName("http://soap.finalproject.introsde/", "createMeasureType");
    private final static QName _CreatePerson_QNAME = new QName("http://soap.finalproject.introsde/", "createPerson");
    private final static QName _CreatePersonResponse_QNAME = new QName("http://soap.finalproject.introsde/", "createPersonResponse");
    private final static QName _DeletePersonGoal_QNAME = new QName("http://soap.finalproject.introsde/", "deletePersonGoal");
    private final static QName _ReadPersonGoalResponse_QNAME = new QName("http://soap.finalproject.introsde/", "readPersonGoalResponse");
    private final static QName _ReadPersonMeasurementByDate_QNAME = new QName("http://soap.finalproject.introsde/", "readPersonMeasurementByDate");
    private final static QName _DeletePersonMeasurementResponse_QNAME = new QName("http://soap.finalproject.introsde/", "deletePersonMeasurementResponse");
    private final static QName _CreateGoalTypeResponse_QNAME = new QName("http://soap.finalproject.introsde/", "createGoalTypeResponse");
    private final static QName _ReadPersonList_QNAME = new QName("http://soap.finalproject.introsde/", "readPersonList");
    private final static QName _ReadPersonRemindersByDateResponse_QNAME = new QName("http://soap.finalproject.introsde/", "readPersonRemindersByDateResponse");
    private final static QName _ReadGoalTypesResponse_QNAME = new QName("http://soap.finalproject.introsde/", "readGoalTypesResponse");
    private final static QName _ReadPersonGoalsResponse_QNAME = new QName("http://soap.finalproject.introsde/", "readPersonGoalsResponse");
    private final static QName _UpdateMeasureTypeResponse_QNAME = new QName("http://soap.finalproject.introsde/", "updateMeasureTypeResponse");
    private final static QName _ReadPersonReminderResponse_QNAME = new QName("http://soap.finalproject.introsde/", "readPersonReminderResponse");
    private final static QName _UpdatePersonGoalResponse_QNAME = new QName("http://soap.finalproject.introsde/", "updatePersonGoalResponse");
    private final static QName _ReadMeasureTypeResponse_QNAME = new QName("http://soap.finalproject.introsde/", "readMeasureTypeResponse");
    private final static QName _ReadMeasureTypesResponse_QNAME = new QName("http://soap.finalproject.introsde/", "readMeasureTypesResponse");
    private final static QName _ReadPersonReminder_QNAME = new QName("http://soap.finalproject.introsde/", "readPersonReminder");
    private final static QName _CreatePersonReminder_QNAME = new QName("http://soap.finalproject.introsde/", "createPersonReminder");
    private final static QName _CreateGoalType_QNAME = new QName("http://soap.finalproject.introsde/", "createGoalType");
    private final static QName _ReadGoalType_QNAME = new QName("http://soap.finalproject.introsde/", "readGoalType");
    private final static QName _DeleteMeasureTypeResponse_QNAME = new QName("http://soap.finalproject.introsde/", "deleteMeasureTypeResponse");
    private final static QName _DeleteGoalType_QNAME = new QName("http://soap.finalproject.introsde/", "deleteGoalType");
    private final static QName _UpdateMeasureType_QNAME = new QName("http://soap.finalproject.introsde/", "updateMeasureType");
    private final static QName _ReadPersonReminders_QNAME = new QName("http://soap.finalproject.introsde/", "readPersonReminders");
    private final static QName _ReadPersonRemindersResponse_QNAME = new QName("http://soap.finalproject.introsde/", "readPersonRemindersResponse");
    private final static QName _UpdatePerson_QNAME = new QName("http://soap.finalproject.introsde/", "updatePerson");
    private final static QName _CreatePersonMeasurement_QNAME = new QName("http://soap.finalproject.introsde/", "createPersonMeasurement");
    private final static QName _UpdateGoalType_QNAME = new QName("http://soap.finalproject.introsde/", "updateGoalType");
    private final static QName _DeletePersonGoalResponse_QNAME = new QName("http://soap.finalproject.introsde/", "deletePersonGoalResponse");
    private final static QName _UpdateGoalTypeResponse_QNAME = new QName("http://soap.finalproject.introsde/", "updateGoalTypeResponse");
    private final static QName _UpdatePersonMeasurement_QNAME = new QName("http://soap.finalproject.introsde/", "updatePersonMeasurement");
    private final static QName _ReadPersonMeasurementResponse_QNAME = new QName("http://soap.finalproject.introsde/", "readPersonMeasurementResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: introsde.finalproject.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdatePersonGoalResponse }
     * 
     */
    public UpdatePersonGoalResponse createUpdatePersonGoalResponse() {
        return new UpdatePersonGoalResponse();
    }

    /**
     * Create an instance of {@link ReadMeasureTypeResponse }
     * 
     */
    public ReadMeasureTypeResponse createReadMeasureTypeResponse() {
        return new ReadMeasureTypeResponse();
    }

    /**
     * Create an instance of {@link ReadPersonReminderResponse }
     * 
     */
    public ReadPersonReminderResponse createReadPersonReminderResponse() {
        return new ReadPersonReminderResponse();
    }

    /**
     * Create an instance of {@link UpdateMeasureTypeResponse }
     * 
     */
    public UpdateMeasureTypeResponse createUpdateMeasureTypeResponse() {
        return new UpdateMeasureTypeResponse();
    }

    /**
     * Create an instance of {@link ReadGoalTypesResponse }
     * 
     */
    public ReadGoalTypesResponse createReadGoalTypesResponse() {
        return new ReadGoalTypesResponse();
    }

    /**
     * Create an instance of {@link ReadPersonGoalsResponse }
     * 
     */
    public ReadPersonGoalsResponse createReadPersonGoalsResponse() {
        return new ReadPersonGoalsResponse();
    }

    /**
     * Create an instance of {@link ReadPersonList }
     * 
     */
    public ReadPersonList createReadPersonList() {
        return new ReadPersonList();
    }

    /**
     * Create an instance of {@link ReadPersonRemindersByDateResponse }
     * 
     */
    public ReadPersonRemindersByDateResponse createReadPersonRemindersByDateResponse() {
        return new ReadPersonRemindersByDateResponse();
    }

    /**
     * Create an instance of {@link CreateGoalTypeResponse }
     * 
     */
    public CreateGoalTypeResponse createCreateGoalTypeResponse() {
        return new CreateGoalTypeResponse();
    }

    /**
     * Create an instance of {@link DeletePersonMeasurementResponse }
     * 
     */
    public DeletePersonMeasurementResponse createDeletePersonMeasurementResponse() {
        return new DeletePersonMeasurementResponse();
    }

    /**
     * Create an instance of {@link ReadPersonMeasurementByDate }
     * 
     */
    public ReadPersonMeasurementByDate createReadPersonMeasurementByDate() {
        return new ReadPersonMeasurementByDate();
    }

    /**
     * Create an instance of {@link ReadPersonGoalResponse }
     * 
     */
    public ReadPersonGoalResponse createReadPersonGoalResponse() {
        return new ReadPersonGoalResponse();
    }

    /**
     * Create an instance of {@link CreatePerson }
     * 
     */
    public CreatePerson createCreatePerson() {
        return new CreatePerson();
    }

    /**
     * Create an instance of {@link DeletePersonGoal }
     * 
     */
    public DeletePersonGoal createDeletePersonGoal() {
        return new DeletePersonGoal();
    }

    /**
     * Create an instance of {@link CreatePersonResponse }
     * 
     */
    public CreatePersonResponse createCreatePersonResponse() {
        return new CreatePersonResponse();
    }

    /**
     * Create an instance of {@link CreateMeasureType }
     * 
     */
    public CreateMeasureType createCreateMeasureType() {
        return new CreateMeasureType();
    }

    /**
     * Create an instance of {@link ReadMeasureTypes }
     * 
     */
    public ReadMeasureTypes createReadMeasureTypes() {
        return new ReadMeasureTypes();
    }

    /**
     * Create an instance of {@link ReadPersonMeasurementResponse }
     * 
     */
    public ReadPersonMeasurementResponse createReadPersonMeasurementResponse() {
        return new ReadPersonMeasurementResponse();
    }

    /**
     * Create an instance of {@link UpdatePersonMeasurement }
     * 
     */
    public UpdatePersonMeasurement createUpdatePersonMeasurement() {
        return new UpdatePersonMeasurement();
    }

    /**
     * Create an instance of {@link UpdateGoalTypeResponse }
     * 
     */
    public UpdateGoalTypeResponse createUpdateGoalTypeResponse() {
        return new UpdateGoalTypeResponse();
    }

    /**
     * Create an instance of {@link DeletePersonGoalResponse }
     * 
     */
    public DeletePersonGoalResponse createDeletePersonGoalResponse() {
        return new DeletePersonGoalResponse();
    }

    /**
     * Create an instance of {@link UpdateGoalType }
     * 
     */
    public UpdateGoalType createUpdateGoalType() {
        return new UpdateGoalType();
    }

    /**
     * Create an instance of {@link UpdatePerson }
     * 
     */
    public UpdatePerson createUpdatePerson() {
        return new UpdatePerson();
    }

    /**
     * Create an instance of {@link ReadPersonRemindersResponse }
     * 
     */
    public ReadPersonRemindersResponse createReadPersonRemindersResponse() {
        return new ReadPersonRemindersResponse();
    }

    /**
     * Create an instance of {@link CreatePersonMeasurement }
     * 
     */
    public CreatePersonMeasurement createCreatePersonMeasurement() {
        return new CreatePersonMeasurement();
    }

    /**
     * Create an instance of {@link DeleteGoalType }
     * 
     */
    public DeleteGoalType createDeleteGoalType() {
        return new DeleteGoalType();
    }

    /**
     * Create an instance of {@link UpdateMeasureType }
     * 
     */
    public UpdateMeasureType createUpdateMeasureType() {
        return new UpdateMeasureType();
    }

    /**
     * Create an instance of {@link ReadPersonReminders }
     * 
     */
    public ReadPersonReminders createReadPersonReminders() {
        return new ReadPersonReminders();
    }

    /**
     * Create an instance of {@link DeleteMeasureTypeResponse }
     * 
     */
    public DeleteMeasureTypeResponse createDeleteMeasureTypeResponse() {
        return new DeleteMeasureTypeResponse();
    }

    /**
     * Create an instance of {@link CreateGoalType }
     * 
     */
    public CreateGoalType createCreateGoalType() {
        return new CreateGoalType();
    }

    /**
     * Create an instance of {@link ReadGoalType }
     * 
     */
    public ReadGoalType createReadGoalType() {
        return new ReadGoalType();
    }

    /**
     * Create an instance of {@link CreatePersonReminder }
     * 
     */
    public CreatePersonReminder createCreatePersonReminder() {
        return new CreatePersonReminder();
    }

    /**
     * Create an instance of {@link ReadMeasureTypesResponse }
     * 
     */
    public ReadMeasureTypesResponse createReadMeasureTypesResponse() {
        return new ReadMeasureTypesResponse();
    }

    /**
     * Create an instance of {@link ReadPersonReminder }
     * 
     */
    public ReadPersonReminder createReadPersonReminder() {
        return new ReadPersonReminder();
    }

    /**
     * Create an instance of {@link DeletePersonReminderResponse }
     * 
     */
    public DeletePersonReminderResponse createDeletePersonReminderResponse() {
        return new DeletePersonReminderResponse();
    }

    /**
     * Create an instance of {@link CreatePersonGoal }
     * 
     */
    public CreatePersonGoal createCreatePersonGoal() {
        return new CreatePersonGoal();
    }

    /**
     * Create an instance of {@link MeasureHistory }
     * 
     */
    public MeasureHistory createMeasureHistory() {
        return new MeasureHistory();
    }

    /**
     * Create an instance of {@link UpdatePersonReminderResponse }
     * 
     */
    public UpdatePersonReminderResponse createUpdatePersonReminderResponse() {
        return new UpdatePersonReminderResponse();
    }

    /**
     * Create an instance of {@link CreatePersonReminderResponse }
     * 
     */
    public CreatePersonReminderResponse createCreatePersonReminderResponse() {
        return new CreatePersonReminderResponse();
    }

    /**
     * Create an instance of {@link DeletePersonReminder }
     * 
     */
    public DeletePersonReminder createDeletePersonReminder() {
        return new DeletePersonReminder();
    }

    /**
     * Create an instance of {@link CreatePersonGoalResponse }
     * 
     */
    public CreatePersonGoalResponse createCreatePersonGoalResponse() {
        return new CreatePersonGoalResponse();
    }

    /**
     * Create an instance of {@link DeletePersonMeasurement }
     * 
     */
    public DeletePersonMeasurement createDeletePersonMeasurement() {
        return new DeletePersonMeasurement();
    }

    /**
     * Create an instance of {@link ReadPerson }
     * 
     */
    public ReadPerson createReadPerson() {
        return new ReadPerson();
    }

    /**
     * Create an instance of {@link ReadPersonRemindersByDate }
     * 
     */
    public ReadPersonRemindersByDate createReadPersonRemindersByDate() {
        return new ReadPersonRemindersByDate();
    }

    /**
     * Create an instance of {@link ReadPersonMeasureHistory }
     * 
     */
    public ReadPersonMeasureHistory createReadPersonMeasureHistory() {
        return new ReadPersonMeasureHistory();
    }

    /**
     * Create an instance of {@link ReadPersonMeasurement }
     * 
     */
    public ReadPersonMeasurement createReadPersonMeasurement() {
        return new ReadPersonMeasurement();
    }

    /**
     * Create an instance of {@link UpdatePersonResponse }
     * 
     */
    public UpdatePersonResponse createUpdatePersonResponse() {
        return new UpdatePersonResponse();
    }

    /**
     * Create an instance of {@link DeleteMeasureType }
     * 
     */
    public DeleteMeasureType createDeleteMeasureType() {
        return new DeleteMeasureType();
    }

    /**
     * Create an instance of {@link ReadGoalTypeResponse }
     * 
     */
    public ReadGoalTypeResponse createReadGoalTypeResponse() {
        return new ReadGoalTypeResponse();
    }

    /**
     * Create an instance of {@link DeleteGoalTypeResponse }
     * 
     */
    public DeleteGoalTypeResponse createDeleteGoalTypeResponse() {
        return new DeleteGoalTypeResponse();
    }

    /**
     * Create an instance of {@link DeletePerson }
     * 
     */
    public DeletePerson createDeletePerson() {
        return new DeletePerson();
    }

    /**
     * Create an instance of {@link ReadPersonGoal }
     * 
     */
    public ReadPersonGoal createReadPersonGoal() {
        return new ReadPersonGoal();
    }

    /**
     * Create an instance of {@link ReadPersonResponse }
     * 
     */
    public ReadPersonResponse createReadPersonResponse() {
        return new ReadPersonResponse();
    }

    /**
     * Create an instance of {@link ReadPersonMeasureHistoryResponse }
     * 
     */
    public ReadPersonMeasureHistoryResponse createReadPersonMeasureHistoryResponse() {
        return new ReadPersonMeasureHistoryResponse();
    }

    /**
     * Create an instance of {@link CreateMeasureTypeResponse }
     * 
     */
    public CreateMeasureTypeResponse createCreateMeasureTypeResponse() {
        return new CreateMeasureTypeResponse();
    }

    /**
     * Create an instance of {@link ReadPersonGoals }
     * 
     */
    public ReadPersonGoals createReadPersonGoals() {
        return new ReadPersonGoals();
    }

    /**
     * Create an instance of {@link CreatePersonMeasurementResponse }
     * 
     */
    public CreatePersonMeasurementResponse createCreatePersonMeasurementResponse() {
        return new CreatePersonMeasurementResponse();
    }

    /**
     * Create an instance of {@link ReadMeasureType }
     * 
     */
    public ReadMeasureType createReadMeasureType() {
        return new ReadMeasureType();
    }

    /**
     * Create an instance of {@link UpdatePersonGoal }
     * 
     */
    public UpdatePersonGoal createUpdatePersonGoal() {
        return new UpdatePersonGoal();
    }

    /**
     * Create an instance of {@link DeletePersonResponse }
     * 
     */
    public DeletePersonResponse createDeletePersonResponse() {
        return new DeletePersonResponse();
    }

    /**
     * Create an instance of {@link ReadPersonMeasurementByDateResponse }
     * 
     */
    public ReadPersonMeasurementByDateResponse createReadPersonMeasurementByDateResponse() {
        return new ReadPersonMeasurementByDateResponse();
    }

    /**
     * Create an instance of {@link ReadPersonListResponse }
     * 
     */
    public ReadPersonListResponse createReadPersonListResponse() {
        return new ReadPersonListResponse();
    }

    /**
     * Create an instance of {@link UpdatePersonReminder }
     * 
     */
    public UpdatePersonReminder createUpdatePersonReminder() {
        return new UpdatePersonReminder();
    }

    /**
     * Create an instance of {@link ReadGoalTypes }
     * 
     */
    public ReadGoalTypes createReadGoalTypes() {
        return new ReadGoalTypes();
    }

    /**
     * Create an instance of {@link UpdatePersonMeasurementResponse }
     * 
     */
    public UpdatePersonMeasurementResponse createUpdatePersonMeasurementResponse() {
        return new UpdatePersonMeasurementResponse();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link Goal }
     * 
     */
    public Goal createGoal() {
        return new Goal();
    }

    /**
     * Create an instance of {@link Reminder }
     * 
     */
    public Reminder createReminder() {
        return new Reminder();
    }

    /**
     * Create an instance of {@link GoalType }
     * 
     */
    public GoalType createGoalType() {
        return new GoalType();
    }

    /**
     * Create an instance of {@link MeasureType }
     * 
     */
    public MeasureType createMeasureType() {
        return new MeasureType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteGoalTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "deleteGoalTypeResponse")
    public JAXBElement<DeleteGoalTypeResponse> createDeleteGoalTypeResponse(DeleteGoalTypeResponse value) {
        return new JAXBElement<DeleteGoalTypeResponse>(_DeleteGoalTypeResponse_QNAME, DeleteGoalTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadGoalTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "readGoalTypeResponse")
    public JAXBElement<ReadGoalTypeResponse> createReadGoalTypeResponse(ReadGoalTypeResponse value) {
        return new JAXBElement<ReadGoalTypeResponse>(_ReadGoalTypeResponse_QNAME, ReadGoalTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "updatePersonResponse")
    public JAXBElement<UpdatePersonResponse> createUpdatePersonResponse(UpdatePersonResponse value) {
        return new JAXBElement<UpdatePersonResponse>(_UpdatePersonResponse_QNAME, UpdatePersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "deleteMeasureType")
    public JAXBElement<DeleteMeasureType> createDeleteMeasureType(DeleteMeasureType value) {
        return new JAXBElement<DeleteMeasureType>(_DeleteMeasureType_QNAME, DeleteMeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonMeasureHistory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "readPersonMeasureHistory")
    public JAXBElement<ReadPersonMeasureHistory> createReadPersonMeasureHistory(ReadPersonMeasureHistory value) {
        return new JAXBElement<ReadPersonMeasureHistory>(_ReadPersonMeasureHistory_QNAME, ReadPersonMeasureHistory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonMeasurement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "readPersonMeasurement")
    public JAXBElement<ReadPersonMeasurement> createReadPersonMeasurement(ReadPersonMeasurement value) {
        return new JAXBElement<ReadPersonMeasurement>(_ReadPersonMeasurement_QNAME, ReadPersonMeasurement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonRemindersByDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "readPersonRemindersByDate")
    public JAXBElement<ReadPersonRemindersByDate> createReadPersonRemindersByDate(ReadPersonRemindersByDate value) {
        return new JAXBElement<ReadPersonRemindersByDate>(_ReadPersonRemindersByDate_QNAME, ReadPersonRemindersByDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "readPerson")
    public JAXBElement<ReadPerson> createReadPerson(ReadPerson value) {
        return new JAXBElement<ReadPerson>(_ReadPerson_QNAME, ReadPerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePersonMeasurement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "deletePersonMeasurement")
    public JAXBElement<DeletePersonMeasurement> createDeletePersonMeasurement(DeletePersonMeasurement value) {
        return new JAXBElement<DeletePersonMeasurement>(_DeletePersonMeasurement_QNAME, DeletePersonMeasurement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePersonReminder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "deletePersonReminder")
    public JAXBElement<DeletePersonReminder> createDeletePersonReminder(DeletePersonReminder value) {
        return new JAXBElement<DeletePersonReminder>(_DeletePersonReminder_QNAME, DeletePersonReminder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePersonGoalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "createPersonGoalResponse")
    public JAXBElement<CreatePersonGoalResponse> createCreatePersonGoalResponse(CreatePersonGoalResponse value) {
        return new JAXBElement<CreatePersonGoalResponse>(_CreatePersonGoalResponse_QNAME, CreatePersonGoalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePersonReminderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "updatePersonReminderResponse")
    public JAXBElement<UpdatePersonReminderResponse> createUpdatePersonReminderResponse(UpdatePersonReminderResponse value) {
        return new JAXBElement<UpdatePersonReminderResponse>(_UpdatePersonReminderResponse_QNAME, UpdatePersonReminderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePersonReminderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "createPersonReminderResponse")
    public JAXBElement<CreatePersonReminderResponse> createCreatePersonReminderResponse(CreatePersonReminderResponse value) {
        return new JAXBElement<CreatePersonReminderResponse>(_CreatePersonReminderResponse_QNAME, CreatePersonReminderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureHistory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "measure")
    public JAXBElement<MeasureHistory> createMeasure(MeasureHistory value) {
        return new JAXBElement<MeasureHistory>(_Measure_QNAME, MeasureHistory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePersonReminderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "deletePersonReminderResponse")
    public JAXBElement<DeletePersonReminderResponse> createDeletePersonReminderResponse(DeletePersonReminderResponse value) {
        return new JAXBElement<DeletePersonReminderResponse>(_DeletePersonReminderResponse_QNAME, DeletePersonReminderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePersonGoal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "createPersonGoal")
    public JAXBElement<CreatePersonGoal> createCreatePersonGoal(CreatePersonGoal value) {
        return new JAXBElement<CreatePersonGoal>(_CreatePersonGoal_QNAME, CreatePersonGoal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePersonMeasurementResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "updatePersonMeasurementResponse")
    public JAXBElement<UpdatePersonMeasurementResponse> createUpdatePersonMeasurementResponse(UpdatePersonMeasurementResponse value) {
        return new JAXBElement<UpdatePersonMeasurementResponse>(_UpdatePersonMeasurementResponse_QNAME, UpdatePersonMeasurementResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadGoalTypes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "readGoalTypes")
    public JAXBElement<ReadGoalTypes> createReadGoalTypes(ReadGoalTypes value) {
        return new JAXBElement<ReadGoalTypes>(_ReadGoalTypes_QNAME, ReadGoalTypes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePersonReminder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "updatePersonReminder")
    public JAXBElement<UpdatePersonReminder> createUpdatePersonReminder(UpdatePersonReminder value) {
        return new JAXBElement<UpdatePersonReminder>(_UpdatePersonReminder_QNAME, UpdatePersonReminder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "readPersonListResponse")
    public JAXBElement<ReadPersonListResponse> createReadPersonListResponse(ReadPersonListResponse value) {
        return new JAXBElement<ReadPersonListResponse>(_ReadPersonListResponse_QNAME, ReadPersonListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonMeasurementByDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "readPersonMeasurementByDateResponse")
    public JAXBElement<ReadPersonMeasurementByDateResponse> createReadPersonMeasurementByDateResponse(ReadPersonMeasurementByDateResponse value) {
        return new JAXBElement<ReadPersonMeasurementByDateResponse>(_ReadPersonMeasurementByDateResponse_QNAME, ReadPersonMeasurementByDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "deletePersonResponse")
    public JAXBElement<DeletePersonResponse> createDeletePersonResponse(DeletePersonResponse value) {
        return new JAXBElement<DeletePersonResponse>(_DeletePersonResponse_QNAME, DeletePersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePersonGoal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "updatePersonGoal")
    public JAXBElement<UpdatePersonGoal> createUpdatePersonGoal(UpdatePersonGoal value) {
        return new JAXBElement<UpdatePersonGoal>(_UpdatePersonGoal_QNAME, UpdatePersonGoal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadMeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "readMeasureType")
    public JAXBElement<ReadMeasureType> createReadMeasureType(ReadMeasureType value) {
        return new JAXBElement<ReadMeasureType>(_ReadMeasureType_QNAME, ReadMeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePersonMeasurementResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "createPersonMeasurementResponse")
    public JAXBElement<CreatePersonMeasurementResponse> createCreatePersonMeasurementResponse(CreatePersonMeasurementResponse value) {
        return new JAXBElement<CreatePersonMeasurementResponse>(_CreatePersonMeasurementResponse_QNAME, CreatePersonMeasurementResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonGoals }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "readPersonGoals")
    public JAXBElement<ReadPersonGoals> createReadPersonGoals(ReadPersonGoals value) {
        return new JAXBElement<ReadPersonGoals>(_ReadPersonGoals_QNAME, ReadPersonGoals.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateMeasureTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "createMeasureTypeResponse")
    public JAXBElement<CreateMeasureTypeResponse> createCreateMeasureTypeResponse(CreateMeasureTypeResponse value) {
        return new JAXBElement<CreateMeasureTypeResponse>(_CreateMeasureTypeResponse_QNAME, CreateMeasureTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonMeasureHistoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "readPersonMeasureHistoryResponse")
    public JAXBElement<ReadPersonMeasureHistoryResponse> createReadPersonMeasureHistoryResponse(ReadPersonMeasureHistoryResponse value) {
        return new JAXBElement<ReadPersonMeasureHistoryResponse>(_ReadPersonMeasureHistoryResponse_QNAME, ReadPersonMeasureHistoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "readPersonResponse")
    public JAXBElement<ReadPersonResponse> createReadPersonResponse(ReadPersonResponse value) {
        return new JAXBElement<ReadPersonResponse>(_ReadPersonResponse_QNAME, ReadPersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonGoal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "readPersonGoal")
    public JAXBElement<ReadPersonGoal> createReadPersonGoal(ReadPersonGoal value) {
        return new JAXBElement<ReadPersonGoal>(_ReadPersonGoal_QNAME, ReadPersonGoal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "deletePerson")
    public JAXBElement<DeletePerson> createDeletePerson(DeletePerson value) {
        return new JAXBElement<DeletePerson>(_DeletePerson_QNAME, DeletePerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadMeasureTypes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "readMeasureTypes")
    public JAXBElement<ReadMeasureTypes> createReadMeasureTypes(ReadMeasureTypes value) {
        return new JAXBElement<ReadMeasureTypes>(_ReadMeasureTypes_QNAME, ReadMeasureTypes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateMeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "createMeasureType")
    public JAXBElement<CreateMeasureType> createCreateMeasureType(CreateMeasureType value) {
        return new JAXBElement<CreateMeasureType>(_CreateMeasureType_QNAME, CreateMeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "createPerson")
    public JAXBElement<CreatePerson> createCreatePerson(CreatePerson value) {
        return new JAXBElement<CreatePerson>(_CreatePerson_QNAME, CreatePerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "createPersonResponse")
    public JAXBElement<CreatePersonResponse> createCreatePersonResponse(CreatePersonResponse value) {
        return new JAXBElement<CreatePersonResponse>(_CreatePersonResponse_QNAME, CreatePersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePersonGoal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "deletePersonGoal")
    public JAXBElement<DeletePersonGoal> createDeletePersonGoal(DeletePersonGoal value) {
        return new JAXBElement<DeletePersonGoal>(_DeletePersonGoal_QNAME, DeletePersonGoal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonGoalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "readPersonGoalResponse")
    public JAXBElement<ReadPersonGoalResponse> createReadPersonGoalResponse(ReadPersonGoalResponse value) {
        return new JAXBElement<ReadPersonGoalResponse>(_ReadPersonGoalResponse_QNAME, ReadPersonGoalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonMeasurementByDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "readPersonMeasurementByDate")
    public JAXBElement<ReadPersonMeasurementByDate> createReadPersonMeasurementByDate(ReadPersonMeasurementByDate value) {
        return new JAXBElement<ReadPersonMeasurementByDate>(_ReadPersonMeasurementByDate_QNAME, ReadPersonMeasurementByDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePersonMeasurementResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "deletePersonMeasurementResponse")
    public JAXBElement<DeletePersonMeasurementResponse> createDeletePersonMeasurementResponse(DeletePersonMeasurementResponse value) {
        return new JAXBElement<DeletePersonMeasurementResponse>(_DeletePersonMeasurementResponse_QNAME, DeletePersonMeasurementResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateGoalTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "createGoalTypeResponse")
    public JAXBElement<CreateGoalTypeResponse> createCreateGoalTypeResponse(CreateGoalTypeResponse value) {
        return new JAXBElement<CreateGoalTypeResponse>(_CreateGoalTypeResponse_QNAME, CreateGoalTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "readPersonList")
    public JAXBElement<ReadPersonList> createReadPersonList(ReadPersonList value) {
        return new JAXBElement<ReadPersonList>(_ReadPersonList_QNAME, ReadPersonList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonRemindersByDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "readPersonRemindersByDateResponse")
    public JAXBElement<ReadPersonRemindersByDateResponse> createReadPersonRemindersByDateResponse(ReadPersonRemindersByDateResponse value) {
        return new JAXBElement<ReadPersonRemindersByDateResponse>(_ReadPersonRemindersByDateResponse_QNAME, ReadPersonRemindersByDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadGoalTypesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "readGoalTypesResponse")
    public JAXBElement<ReadGoalTypesResponse> createReadGoalTypesResponse(ReadGoalTypesResponse value) {
        return new JAXBElement<ReadGoalTypesResponse>(_ReadGoalTypesResponse_QNAME, ReadGoalTypesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonGoalsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "readPersonGoalsResponse")
    public JAXBElement<ReadPersonGoalsResponse> createReadPersonGoalsResponse(ReadPersonGoalsResponse value) {
        return new JAXBElement<ReadPersonGoalsResponse>(_ReadPersonGoalsResponse_QNAME, ReadPersonGoalsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateMeasureTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "updateMeasureTypeResponse")
    public JAXBElement<UpdateMeasureTypeResponse> createUpdateMeasureTypeResponse(UpdateMeasureTypeResponse value) {
        return new JAXBElement<UpdateMeasureTypeResponse>(_UpdateMeasureTypeResponse_QNAME, UpdateMeasureTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonReminderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "readPersonReminderResponse")
    public JAXBElement<ReadPersonReminderResponse> createReadPersonReminderResponse(ReadPersonReminderResponse value) {
        return new JAXBElement<ReadPersonReminderResponse>(_ReadPersonReminderResponse_QNAME, ReadPersonReminderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePersonGoalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "updatePersonGoalResponse")
    public JAXBElement<UpdatePersonGoalResponse> createUpdatePersonGoalResponse(UpdatePersonGoalResponse value) {
        return new JAXBElement<UpdatePersonGoalResponse>(_UpdatePersonGoalResponse_QNAME, UpdatePersonGoalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadMeasureTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "readMeasureTypeResponse")
    public JAXBElement<ReadMeasureTypeResponse> createReadMeasureTypeResponse(ReadMeasureTypeResponse value) {
        return new JAXBElement<ReadMeasureTypeResponse>(_ReadMeasureTypeResponse_QNAME, ReadMeasureTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadMeasureTypesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "readMeasureTypesResponse")
    public JAXBElement<ReadMeasureTypesResponse> createReadMeasureTypesResponse(ReadMeasureTypesResponse value) {
        return new JAXBElement<ReadMeasureTypesResponse>(_ReadMeasureTypesResponse_QNAME, ReadMeasureTypesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonReminder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "readPersonReminder")
    public JAXBElement<ReadPersonReminder> createReadPersonReminder(ReadPersonReminder value) {
        return new JAXBElement<ReadPersonReminder>(_ReadPersonReminder_QNAME, ReadPersonReminder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePersonReminder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "createPersonReminder")
    public JAXBElement<CreatePersonReminder> createCreatePersonReminder(CreatePersonReminder value) {
        return new JAXBElement<CreatePersonReminder>(_CreatePersonReminder_QNAME, CreatePersonReminder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateGoalType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "createGoalType")
    public JAXBElement<CreateGoalType> createCreateGoalType(CreateGoalType value) {
        return new JAXBElement<CreateGoalType>(_CreateGoalType_QNAME, CreateGoalType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadGoalType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "readGoalType")
    public JAXBElement<ReadGoalType> createReadGoalType(ReadGoalType value) {
        return new JAXBElement<ReadGoalType>(_ReadGoalType_QNAME, ReadGoalType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMeasureTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "deleteMeasureTypeResponse")
    public JAXBElement<DeleteMeasureTypeResponse> createDeleteMeasureTypeResponse(DeleteMeasureTypeResponse value) {
        return new JAXBElement<DeleteMeasureTypeResponse>(_DeleteMeasureTypeResponse_QNAME, DeleteMeasureTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteGoalType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "deleteGoalType")
    public JAXBElement<DeleteGoalType> createDeleteGoalType(DeleteGoalType value) {
        return new JAXBElement<DeleteGoalType>(_DeleteGoalType_QNAME, DeleteGoalType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateMeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "updateMeasureType")
    public JAXBElement<UpdateMeasureType> createUpdateMeasureType(UpdateMeasureType value) {
        return new JAXBElement<UpdateMeasureType>(_UpdateMeasureType_QNAME, UpdateMeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonReminders }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "readPersonReminders")
    public JAXBElement<ReadPersonReminders> createReadPersonReminders(ReadPersonReminders value) {
        return new JAXBElement<ReadPersonReminders>(_ReadPersonReminders_QNAME, ReadPersonReminders.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonRemindersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "readPersonRemindersResponse")
    public JAXBElement<ReadPersonRemindersResponse> createReadPersonRemindersResponse(ReadPersonRemindersResponse value) {
        return new JAXBElement<ReadPersonRemindersResponse>(_ReadPersonRemindersResponse_QNAME, ReadPersonRemindersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "updatePerson")
    public JAXBElement<UpdatePerson> createUpdatePerson(UpdatePerson value) {
        return new JAXBElement<UpdatePerson>(_UpdatePerson_QNAME, UpdatePerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePersonMeasurement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "createPersonMeasurement")
    public JAXBElement<CreatePersonMeasurement> createCreatePersonMeasurement(CreatePersonMeasurement value) {
        return new JAXBElement<CreatePersonMeasurement>(_CreatePersonMeasurement_QNAME, CreatePersonMeasurement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateGoalType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "updateGoalType")
    public JAXBElement<UpdateGoalType> createUpdateGoalType(UpdateGoalType value) {
        return new JAXBElement<UpdateGoalType>(_UpdateGoalType_QNAME, UpdateGoalType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePersonGoalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "deletePersonGoalResponse")
    public JAXBElement<DeletePersonGoalResponse> createDeletePersonGoalResponse(DeletePersonGoalResponse value) {
        return new JAXBElement<DeletePersonGoalResponse>(_DeletePersonGoalResponse_QNAME, DeletePersonGoalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateGoalTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "updateGoalTypeResponse")
    public JAXBElement<UpdateGoalTypeResponse> createUpdateGoalTypeResponse(UpdateGoalTypeResponse value) {
        return new JAXBElement<UpdateGoalTypeResponse>(_UpdateGoalTypeResponse_QNAME, UpdateGoalTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePersonMeasurement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "updatePersonMeasurement")
    public JAXBElement<UpdatePersonMeasurement> createUpdatePersonMeasurement(UpdatePersonMeasurement value) {
        return new JAXBElement<UpdatePersonMeasurement>(_UpdatePersonMeasurement_QNAME, UpdatePersonMeasurement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonMeasurementResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.finalproject.introsde/", name = "readPersonMeasurementResponse")
    public JAXBElement<ReadPersonMeasurementResponse> createReadPersonMeasurementResponse(ReadPersonMeasurementResponse value) {
        return new JAXBElement<ReadPersonMeasurementResponse>(_ReadPersonMeasurementResponse_QNAME, ReadPersonMeasurementResponse.class, null, value);
    }

}
