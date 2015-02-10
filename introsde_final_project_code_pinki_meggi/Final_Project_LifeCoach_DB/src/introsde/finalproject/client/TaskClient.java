package introsde.finalproject.client;

import introsde.finalproject.model.Goal;
import introsde.finalproject.model.GoalType;
import introsde.finalproject.model.MeasureHistory;
import introsde.finalproject.model.Person;
import introsde.finalproject.model.MeasureType;
import introsde.finalproject.model.Reminder;
import introsde.finalproject.soap.People;

import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class TaskClient{
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:777/soap/people?wsdl");
        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://soap.finalproject.introsde/", "PeopleService");
        Service service = Service.create(url, qname);
        People people = service.getPort(People.class);
        
    	System.out.println("******************** METHOD #1 - LIST ALL PEOPLE ********************");
    	List<Person> pList = people.readPersonList();
    	listAllPeople(pList);
    	System.out.println();
      	   
    	System.out.println("******************** METHOD #4 - CREATE PERSON ********************");
    	Person newPerson = new Person();
    	newPerson.setFirstname("Pinki");
    	newPerson.setLastname("Kotecha");
    	newPerson.setUsername("pkotecha");
    	newPerson.setPassword("123456");
    	newPerson.setEmail("pinki.kotecha@gmail.com");
    	
    	
    	newPerson.setBirthdate("29-06-1982");
    	Person newPersonCreated = people.createPerson(newPerson);
    	printPersonInfo(newPersonCreated);
    	System.out.println();
      	    
     	System.out.println("******************** METHOD #1 - LIST ALL PEOPLE ********************");
    	pList = people.readPersonList();
    	listAllPeople(pList);
    	System.out.println();
    	
    	
    	System.out.println("******************** METHOD #8 - SAVE PERSON REMINDERS ********************");
        Reminder r1 = new Reminder();
        r1.setDescription(" Go to walk at 5pm");
        r1.setTypeReminder("daily");
        r1.setDateRegistered("30-01-2015");
        
        Reminder newR1 = people.createPersonReminder(newPersonCreated.getIdPerson(), r1); 
        Long newrid1=newR1.getIdReminder();
        System.out.println(newrid1);
        System.out.println();
       
        Reminder r2 = new Reminder();
        r2.setDescription("Measure blood pressure at 10pm ");
        r2.setTypeReminder("daily");
        r2.setDateRegistered("30-01-2015");
        
        Reminder newR2 = people.createPersonReminder(newPersonCreated.getIdPerson(), r2); 
        Long newrid2=newR1.getIdReminder();
        System.out.println(newrid2);
        System.out.println();
        
        Reminder r3 = new Reminder();
        r3.setDescription("Measure weight before sleep");
        r3.setTypeReminder("weekly");
        r3.setWDay("Friday");
        r3.setDateRegistered("30-01-2015");
        Reminder newR3 = people.createPersonReminder(newPersonCreated.getIdPerson(), r3); 
        Long newrid3=newR3.getIdReminder();
        System.out.println(newrid3);
        System.out.println();
        
        Reminder r4 = new Reminder();
        r4.setDescription("Go to doctor appointment");
        r4.setTypeReminder("specific_date");
        r4.setSDate("04-03-2015");
        r4.setDateRegistered("30-01-2015");
        Reminder newR4 = people.createPersonReminder(newPersonCreated.getIdPerson(), r4); 
        Long newrid4=newR4.getIdReminder();
        System.out.println(newrid4);
        System.out.println();
        

        Reminder r5 = new Reminder();
        r5.setDescription("Go to SPA");
        r5.setTypeReminder("monthly");
        r5.setMDay("27");
        r5.setDateRegistered("30-01-2015");
        Reminder newR5 = people.createPersonReminder(newPersonCreated.getIdPerson(), r5); 
        Long newrid5=newR5.getIdReminder();
        System.out.println(newrid5);
        System.out.println();
        
        System.out.println("******************** METHOD #6 - READ PERSON MEASURE HISTORY ********************");
        List<Reminder> rList = people.readPersonReminders(newPersonCreated.getIdPerson()); 
        
        for (int i=0; i<rList.size();i++){
        	Reminder r= rList.get(i);
        	System.out.println("	RID:"+ r.getIdReminder());
         	System.out.println("	Date Registerd:"+ r.getDateRegistered());
         	System.out.println("	Description:"+ r.getDescription());
         	System.out.println("	Type:"+ r.getTypeReminder());
         	System.out.println("	WDay:"+ r.getWDay());
         	System.out.println("	MDay:"+ r.getMDay());
         	System.out.println("	SDate:"+ r.getSDate());
         	System.out.println();
        }
        System.out.println();
     }
    
	public static void printPersonInfo(Person p) throws ParseException{
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println("ID:"+ p.getIdPerson());
   	 	System.out.println("Full Name: "+p.getFirstname()+" "+p.getLastname());
     	//System.out.println("BirthDate: "+df.format(p.getBirthdate()));
   	 	System.out.println("BirthDate: "+p.getBirthdate());
   	 	System.out.println("Username: "+p.getUsername());
     	System.out.println("Password: "+p.getPassword());
    }
	
	public static void printMeasureInfo(MeasureHistory m){
		System.out.println("	MID:"+ m.getMid());
     	MeasureType t = m.getMeasureType();
     	System.out.println("	Date Registerd:"+ m.getDateRegistered());
     	System.out.println("	Measure Type:"+ t.getMeasureType());
     	System.out.println("	Measure Value:"+ m.getMeasureValue());
    }
 
	public static void printGoalInfo(Goal g){
		System.out.println("	GID:"+ g.getIdGoal());
     	GoalType t = g.getGoalType();
     	System.out.println("	Date Registerd:"+ g.getDateRegistered());
     	System.out.println("	Measure Type:"+ t.getMeasureType().getMeasureType());
     	System.out.println("	Description:"+ t.getDescription());
     	System.out.println("	Goal Type:"+ t.getType());
     	System.out.println("	Goal Value:"+ g.getGoalValue());
    }
 
	public static void listAllPeople(List<Person> pList) throws ParseException{
    	for (int i=0; i<pList.size();i++){
    		printPersonInfo(pList.get(i));
        	System.out.println();
    	}
    }
 
    public static void listAllMeasureHistory(List<MeasureHistory> mhList){
    	for (int i=0; i<mhList.size();i++){
        	printMeasureInfo(mhList.get(i));
        	System.out.println();
    	}
    }
    
    public static void listAllGoalHistory(List<Goal> mhList){
    	for (int i=0; i<mhList.size();i++){
        	printGoalInfo(mhList.get(i));
        	System.out.println();
    	}
    }
}