package introsde.finalproject.client;

import introsde.finalproject.model.Goal;
import introsde.finalproject.model.GoalType;
import introsde.finalproject.model.MeasureHistory;
import introsde.finalproject.model.Person;
import introsde.finalproject.model.MeasureType;
import introsde.finalproject.soap.People;

import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class GoalClient{
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
    	
    	
    	System.out.println("******************** METHOD #8 - SAVE PERSON MEASUREMENT ********************");
        MeasureHistory mh1 = new MeasureHistory();
        MeasureType newMT1 = new MeasureType();
        newMT1.setMeasureType("weight");
        mh1.setDateRegistered("2015-01-30");
        mh1.setMeasureType(newMT1);
        mh1.setMeasureValue("65");
        MeasureHistory newMH1 = people.createPersonMeasurement(newPersonCreated.getIdPerson(),"weight", mh1); 
        Long newMid1=newMH1.getMid();
        System.out.println(newMid1);
        System.out.println();
       
        MeasureHistory mh2 = new MeasureHistory();
        MeasureType newMT2 = new MeasureType();
        newMT2.setMeasureType("bloodpressure");
        mh2.setDateRegistered("2015-01-30");
        mh2.setMeasureType(newMT2);
        mh2.setMeasureValue("100");
        MeasureHistory newMH2 = people.createPersonMeasurement(newPersonCreated.getIdPerson(), "bloodpressure",mh2); 
        Long newMid2=newMH2.getMid();
        System.out.println(newMid2);
        System.out.println();
        
        
        MeasureHistory mh3 = new MeasureHistory();
        MeasureType newMT3 = new MeasureType();
        newMT3.setMeasureType("walkingsteps");
        mh3.setDateRegistered("2015-01-30");
        mh3.setMeasureType(newMT3);
        mh3.setMeasureValue("500");
        MeasureHistory newMH3 = people.createPersonMeasurement(newPersonCreated.getIdPerson(), "walkingsteps",mh3); 
        Long newMid3=newMH3.getMid();
        System.out.println(newMid3);
        System.out.println();
        
        MeasureHistory mh4 = new MeasureHistory();
        MeasureType newMT4 = new MeasureType();
        newMT4.setMeasureType("sleepinghours");
        mh4.setDateRegistered("2015-01-30");
        mh4.setMeasureType(newMT4);
        mh4.setMeasureValue("10");
        MeasureHistory newMH4 = people.createPersonMeasurement(newPersonCreated.getIdPerson(), "sleepinghours", mh4); 
        Long newMid4=newMH4.getMid();
        System.out.println(newMid4);
        System.out.println();
        
        
        System.out.println("******************** METHOD #6 - READ PERSON MEASURE HISTORY ********************");
        List<MeasureHistory> mhList = people.readPersonMeasureHistory(newPersonCreated.getIdPerson(), "weight"); 
        listAllMeasureHistory(mhList);
        System.out.println();
        mhList = people.readPersonMeasureHistory(newPersonCreated.getIdPerson(), "bloodpressure"); 
        listAllMeasureHistory(mhList);
        System.out.println();
        mhList = people.readPersonMeasureHistory(newPersonCreated.getIdPerson(), "walkingsteps"); 
        listAllMeasureHistory(mhList);
        System.out.println();
        mhList = people.readPersonMeasureHistory(newPersonCreated.getIdPerson(), "sleepinghours"); 
        listAllMeasureHistory(mhList);
        System.out.println();
        
        
        
        System.out.println("******************** METHOD #8 - SAVE PERSON GOALS ********************");
        Goal g1 = new Goal();
        g1.setDateRegistered("2015-01-30");
        g1.setGoalValue("1");
        Goal newG1 = people.createPersonGoal(newPersonCreated.getIdPerson(),"weight","weekly", g1); 
        Long newGID1=newG1.getIdGoal();
        System.out.println(newGID1);
        System.out.println();
        
        Goal g2 = new Goal();
        g2.setDateRegistered("2015-01-30");
        g2.setGoalValue("120");
        Goal newG2 = people.createPersonGoal(newPersonCreated.getIdPerson(),"bloodpressure","daily", g2); 
        Long newGID2=newG2.getIdGoal();
        System.out.println(newGID2);
        System.out.println();
        
        Goal g3 = new Goal();
        g3.setDateRegistered("2015-01-30");
        g3.setGoalValue("1200");
        Goal newG3 = people.createPersonGoal(newPersonCreated.getIdPerson(),"walkingsteps","daily", g3); 
        Long newGID3=newG3.getIdGoal();
        System.out.println(newGID3);
        System.out.println();
        
        Goal g4 = new Goal();
        g4.setDateRegistered("2015-01-30");
        g4.setGoalValue("8");
        Goal newG4 = people.createPersonGoal(newPersonCreated.getIdPerson(),"sleepinghours","daily", g4); 
        Long newGID4 = newG4.getIdGoal();
        System.out.println(newGID4);
        System.out.println();
       
        System.out.println("******************** METHOD #6 - READ PERSON GOALs ********************");
        List<Goal> gList = people.readPersonGoalHistory(newPersonCreated.getIdPerson()); 
        listAllGoalHistory(gList);
        
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